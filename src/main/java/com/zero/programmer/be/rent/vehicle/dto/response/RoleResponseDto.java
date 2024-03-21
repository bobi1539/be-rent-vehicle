package com.zero.programmer.be.rent.vehicle.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RoleResponseDto extends BaseEntityResponseDto {
    private Long id;
    private String name;
}
