package com.zero.programmer.be.rent.vehicle.service;

import com.zero.programmer.be.rent.vehicle.dto.request.LoginRequestDto;
import com.zero.programmer.be.rent.vehicle.dto.response.LoginResponseDto;

public interface AuthService {
    LoginResponseDto login(LoginRequestDto requestDto);
}
