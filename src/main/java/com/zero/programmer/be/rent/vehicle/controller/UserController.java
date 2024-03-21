package com.zero.programmer.be.rent.vehicle.controller;

import com.zero.programmer.be.rent.vehicle.constant.Endpoint;
import com.zero.programmer.be.rent.vehicle.dto.response.UserResponseDto;
import com.zero.programmer.be.rent.vehicle.service.UserService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(Endpoint.USER)
@AllArgsConstructor(onConstructor = @__(@Autowired))
@SecurityRequirement(name = "Authorization")
public class UserController {

    private final UserService userService;

    @GetMapping
    public UserResponseDto getUserByEmail(
            @RequestParam String email
    ) {
        return userService.getUserByEmail(email);
    }

    @GetMapping("/test")
    public Map<String, String> test() {
        Map<String, String> map = new HashMap<>();
        map.put("name", "Jhon");
        return map;
    }
}
