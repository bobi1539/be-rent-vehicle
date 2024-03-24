package com.zero.programmer.be.rent.vehicle.service;

import com.zero.programmer.be.rent.vehicle.dto.request.SendEmailDto;

public interface EmailService {

    void sendEmail(SendEmailDto emailDto);
}
