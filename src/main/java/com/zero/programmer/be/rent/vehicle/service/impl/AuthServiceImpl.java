package com.zero.programmer.be.rent.vehicle.service.impl;

import com.zero.programmer.be.rent.vehicle.constant.GlobalMessage;
import com.zero.programmer.be.rent.vehicle.dto.JwtTokenComponentDto;
import com.zero.programmer.be.rent.vehicle.dto.request.LoginRequestDto;
import com.zero.programmer.be.rent.vehicle.dto.response.LoginResponseDto;
import com.zero.programmer.be.rent.vehicle.entity.MUser;
import com.zero.programmer.be.rent.vehicle.exception.AppException;
import com.zero.programmer.be.rent.vehicle.repository.UserRepository;
import com.zero.programmer.be.rent.vehicle.service.AuthService;
import com.zero.programmer.be.rent.vehicle.service.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
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
}
