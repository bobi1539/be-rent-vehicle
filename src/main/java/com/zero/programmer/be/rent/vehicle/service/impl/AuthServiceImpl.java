package com.zero.programmer.be.rent.vehicle.service.impl;

import com.zero.programmer.be.rent.vehicle.constant.Constant;
import com.zero.programmer.be.rent.vehicle.constant.GlobalMessage;
import com.zero.programmer.be.rent.vehicle.constant.UserType;
import com.zero.programmer.be.rent.vehicle.dto.JwtTokenComponentDto;
import com.zero.programmer.be.rent.vehicle.dto.request.LoginRequestDto;
import com.zero.programmer.be.rent.vehicle.dto.request.RegisterCustomerRequestDto;
import com.zero.programmer.be.rent.vehicle.dto.request.SendEmailDto;
import com.zero.programmer.be.rent.vehicle.dto.response.EmailVerificationResponseDto;
import com.zero.programmer.be.rent.vehicle.dto.response.LoginResponseDto;
import com.zero.programmer.be.rent.vehicle.dto.response.UserResponseDto;
import com.zero.programmer.be.rent.vehicle.entity.MToken;
import com.zero.programmer.be.rent.vehicle.entity.MUser;
import com.zero.programmer.be.rent.vehicle.exception.AppException;
import com.zero.programmer.be.rent.vehicle.repository.TokenRepository;
import com.zero.programmer.be.rent.vehicle.repository.UserRepository;
import com.zero.programmer.be.rent.vehicle.service.AuthService;
import com.zero.programmer.be.rent.vehicle.service.EmailService;
import com.zero.programmer.be.rent.vehicle.service.JwtService;
import com.zero.programmer.be.rent.vehicle.service.ValidationService;
import com.zero.programmer.be.rent.vehicle.util.Util;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuthServiceImpl extends ValidationService implements AuthService {

    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final EmailService emailService;

    @Override
    public LoginResponseDto login(LoginRequestDto requestDto) {
        MUser user = getUserByEmail(requestDto.getEmail());
        verifyPassword(requestDto.getPassword(), user.getPassword());
        verifyUserIsActive(user.isActive());
        String token = jwtService.generateToken(composeTokenComponentDto(user));
        return LoginResponseDto.builder()
                .token(token)
                .build();
    }

    @Transactional
    @Override
    public UserResponseDto registerCustomer(RegisterCustomerRequestDto requestDto) {
        validateDuplicateEmail(requestDto.getEmail());
        validatePassword(requestDto.getPassword(), requestDto.getRepeatPassword());

        MUser user = saveUser(requestDto);
        String token = saveToken(user);

        sendEmailVerification(user.getEmail(), token);
        return mapUserToResponse(user);
    }

    @Transactional
    @Override
    public EmailVerificationResponseDto emailVerification(String tokenVerification) {
        MToken token = findToken(tokenVerification);
        validateTokenExpired(token);
        updateToken(token);
        updateUser(token.getUser());
        String jwtToken = jwtService.generateToken(composeTokenComponentDto(token.getUser()));
        return EmailVerificationResponseDto.builder()
                .token(jwtToken)
                .build();
    }

    private MUser getUserByEmail(String email) {
        return userRepository.findByEmailAndIsDeleted(email, false)
                .orElseThrow(() -> new AppException(GlobalMessage.WRONG_EMAIL_OR_PASSWORD));
    }

    private void verifyPassword(String password, String hashPassword) {
        boolean matches = passwordEncoder.matches(password, hashPassword);
        if (!matches) {
            throw new AppException(GlobalMessage.WRONG_EMAIL_OR_PASSWORD);
        }
    }

    private void verifyUserIsActive(boolean isActive) {
        if (!isActive) {
            throw new AppException(GlobalMessage.ACCOUNT_NOT_ACTIVE);
        }
    }

    private JwtTokenComponentDto composeTokenComponentDto(MUser user) {
        return JwtTokenComponentDto.builder()
                .userId(user.getId())
                .type(user.getType())
                .email(user.getEmail())
                .fullName(user.getFullName())
                .build();
    }

    private void validateDuplicateEmail(String email) {
        Optional<MUser> optionalUser = userRepository.findByEmailAndIsDeleted(email, false);
        if (optionalUser.isPresent()) {
            throw new AppException(GlobalMessage.EMAIL_IS_REGISTERED);
        }
    }

    private MUser composeUser(RegisterCustomerRequestDto requestDto) {
        MUser user = MUser.builder()
                .fullName(requestDto.getFullName())
                .email(requestDto.getEmail())
                .password(hashPassword(requestDto.getPassword()))
                .isActive(false)
                .type(UserType.CUSTOMER.value)
                .build();
        setCreatedAndUpdatedBySystem(user);
        return user;
    }

    private String hashPassword(String password) {
        return passwordEncoder.encode(password);
    }

    private MUser saveUser(RegisterCustomerRequestDto requestDto) {
        MUser userCustomer = composeUser(requestDto);
        return userRepository.save(userCustomer);
    }

    private String saveToken(MUser user) {
        MToken token = composeToken(user);
        tokenRepository.save(token);
        return token.getToken();
    }

    private MToken composeToken(MUser user) {
        LocalDateTime expiredAt = LocalDateTime.now().plusMinutes(5);
        return MToken.builder()
                .token(generateTokenEmailVerification())
                .isVerified(false)
                .expiredAt(expiredAt)
                .user(user)
                .createdBy(user.getId())
                .createdByName(user.getFullName())
                .updatedBy(user.getId())
                .updatedByName(user.getFullName())
                .build();
    }

    private void sendEmailVerification(String email, String token) {
        Thread thread = new Thread(() -> {
            SendEmailDto emailDto = SendEmailDto.builder()
                    .to(email)
                    .subject("Verifikasi Email")
                    .body(getBodyEmail(token))
                    .build();
            emailService.sendEmail(emailDto);
        });
        thread.start();
    }

    private String getBodyEmail(String token) {
        return "Klik link ini untuk verifikasi email anda. " +
                Constant.LINK_EMAIL_VERIFICATION + token;
    }

    private String generateTokenEmailVerification() {
        return Util.generateRandomStringAndNumber(50);
    }

    private MToken findToken(String token) {
        return tokenRepository.findByTokenAndIsVerifiedAndIsDeleted(token, false, false)
                .orElseThrow(() -> new AppException(GlobalMessage.TOKEN_NOT_VALID));
    }

    private void validateTokenExpired(MToken token) {
        if (token.getExpiredAt().isBefore(LocalDateTime.now())) {
            throw new AppException(GlobalMessage.TOKEN_IS_EXPIRED);
        }
    }

    private void updateToken(MToken token) {
        token.setVerified(true);
        token.setVerifiedAt(LocalDateTime.now());
        token.setUpdatedBy(1L);
        token.setUpdatedByName(Constant.SYSTEM);
        tokenRepository.save(token);
    }

    private void updateUser(MUser user) {
        user.setActive(true);
        userRepository.save(user);
    }
}
