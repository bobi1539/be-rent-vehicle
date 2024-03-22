package com.zero.programmer.be.rent.vehicle.service.impl;

import com.zero.programmer.be.rent.vehicle.constant.GlobalMessage;
import com.zero.programmer.be.rent.vehicle.dto.JwtTokenComponentDto;
import com.zero.programmer.be.rent.vehicle.dto.request.LoginRequestDto;
import com.zero.programmer.be.rent.vehicle.dto.request.RegisterCustomerRequestDto;
import com.zero.programmer.be.rent.vehicle.dto.response.LoginResponseDto;
import com.zero.programmer.be.rent.vehicle.dto.response.UserResponseDto;
import com.zero.programmer.be.rent.vehicle.entity.MRole;
import com.zero.programmer.be.rent.vehicle.entity.MUser;
import com.zero.programmer.be.rent.vehicle.exception.AppException;
import com.zero.programmer.be.rent.vehicle.repository.RoleRepository;
import com.zero.programmer.be.rent.vehicle.repository.UserRepository;
import com.zero.programmer.be.rent.vehicle.service.AuthService;
import com.zero.programmer.be.rent.vehicle.service.JwtService;
import com.zero.programmer.be.rent.vehicle.service.ValidationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuthServiceImpl extends ValidationService implements AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

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

    @Override
    public UserResponseDto registerCustomer(RegisterCustomerRequestDto requestDto) {
        validateDuplicateEmail(requestDto.getEmail());
        validatePassword(requestDto.getPassword(), requestDto.getRepeatPassword());
        MUser user = saveCustomer(requestDto);
        return mapUserToResponse(user);
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
                .roleId(user.getRole().getId())
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
                .role(getRoleCustomer())
                .build();
        setCreatedAndUpdatedBySystem(user);
        return user;
    }

    private String hashPassword(String password) {
        return passwordEncoder.encode(password);
    }

    private MRole getRoleCustomer() {
        return roleRepository.findByIdAndIsDeleted(2L, false)
                .orElseThrow(() -> new AppException(GlobalMessage.DATA_NOT_FOUND));
    }

    private MUser saveCustomer(RegisterCustomerRequestDto requestDto) {
        MUser userCustomer = composeUser(requestDto);
        return userRepository.save(userCustomer);
    }
}
