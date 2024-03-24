package com.zero.programmer.be.rent.vehicle.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EmailVerificationResponseDto {
    private String token;
}
