package com.zero.programmer.be.rent.vehicle.controller;

import com.zero.programmer.be.rent.vehicle.constant.Endpoint;
import com.zero.programmer.be.rent.vehicle.dto.request.LoginRequestDto;
import com.zero.programmer.be.rent.vehicle.dto.request.RegisterCustomerRequestDto;
import com.zero.programmer.be.rent.vehicle.dto.response.LoginResponseDto;
import com.zero.programmer.be.rent.vehicle.dto.response.UserResponseDto;
import com.zero.programmer.be.rent.vehicle.service.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Endpoint.AUTH)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponseDto login(
            @RequestBody @Valid LoginRequestDto requestDto
    ) {
        return authService.login(requestDto);
    }

    @PostMapping("/register")
    public UserResponseDto registerCustomer(
            @RequestBody @Valid RegisterCustomerRequestDto requestDto
    ) {
        return authService.registerCustomer(requestDto);
    }
}
