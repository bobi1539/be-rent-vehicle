package com.zero.programmer.be.rent.vehicle.service.impl;

import com.zero.programmer.be.rent.vehicle.constant.Constant;
import com.zero.programmer.be.rent.vehicle.dto.request.SendEmailDto;
import com.zero.programmer.be.rent.vehicle.service.EmailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;

    @Override
    public void sendEmail(SendEmailDto emailDto) {
        log.info("Start Sending Email.");

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(Constant.FROM_EMAIL);
        mailMessage.setTo(emailDto.getTo());
        mailMessage.setSubject(emailDto.getSubject());
        mailMessage.setText(emailDto.getBody());

        mailSender.send(mailMessage);
        log.info("Finish Sending Email.");
    }
}
