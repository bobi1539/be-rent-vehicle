package com.zero.programmer.be.rent.vehicle.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserResponseDto extends BaseEntityResponseDto {
    private Long id;
    private String fullName;
    private String phoneNumber;
    private String email;
    private boolean isActive;
    private String type;
}
