package com.zero.programmer.be.rent.vehicle.service;

import com.zero.programmer.be.rent.vehicle.dto.response.UserResponseDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

    UserResponseDto getUserByEmail(String email);

    UserDetails getUserDetailsByEmail(String email);
}
