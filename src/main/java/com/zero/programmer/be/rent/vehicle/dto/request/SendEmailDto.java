package com.zero.programmer.be.rent.vehicle.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SendEmailDto {
    private String to;
    private String subject;
    private String body;
}
