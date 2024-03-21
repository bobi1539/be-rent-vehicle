package com.zero.programmer.be.rent.vehicle.service;

import com.zero.programmer.be.rent.vehicle.dto.JwtTokenComponentDto;
import com.zero.programmer.be.rent.vehicle.dto.response.UserResponseDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

    String generateToken(JwtTokenComponentDto dto);

    boolean validateToken(String token, UserDetails userDetails);

    String extractEmail(String token);
}
