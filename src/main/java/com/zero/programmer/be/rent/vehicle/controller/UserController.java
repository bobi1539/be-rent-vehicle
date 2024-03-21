package com.zero.programmer.be.rent.vehicle.controller;

import com.zero.programmer.be.rent.vehicle.constant.Endpoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(Endpoint.USER)
public class UserController {

    @GetMapping
    public Map<String, String> test() {
        Map<String, String> map = new HashMap<>();
        map.put("Hello", "John");
        return map;
    }
}
