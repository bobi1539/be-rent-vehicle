package com.zero.programmer.be.rent.vehicle.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class JwtTokenComponentDto {
    private Long userId;
    private Long roleId;
    private String email;
    private String fullName;
}
