package com.zero.programmer.be.rent.vehicle.service;

import com.zero.programmer.be.rent.vehicle.dto.request.EmailIsRegisterRequestDto;
import com.zero.programmer.be.rent.vehicle.dto.request.LoginRequestDto;
import com.zero.programmer.be.rent.vehicle.dto.request.RegisterCustomerRequestDto;
import com.zero.programmer.be.rent.vehicle.dto.response.EmailIsRegisterResponseDto;
import com.zero.programmer.be.rent.vehicle.dto.response.EmailVerificationResponseDto;
import com.zero.programmer.be.rent.vehicle.dto.response.LoginResponseDto;
import com.zero.programmer.be.rent.vehicle.dto.response.UserResponseDto;

public interface AuthService {
    LoginResponseDto login(LoginRequestDto requestDto);
    UserResponseDto registerCustomer(RegisterCustomerRequestDto requestDto);
    EmailVerificationResponseDto emailVerification(String tokenVerification);
    LoginResponseDto registerCustomerWithGoogle(RegisterCustomerRequestDto requestDto);
    EmailIsRegisterResponseDto checkEmailIsRegistered(EmailIsRegisterRequestDto requestDto);
}
