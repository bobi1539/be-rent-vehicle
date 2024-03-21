package com.zero.programmer.be.rent.vehicle.dto.request;

import com.zero.programmer.be.rent.vehicle.constant.ValidationMessage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LoginRequestDto {

    @NotNull(message = ValidationMessage.EMAIL_REQUIRED)
    @NotBlank(message = ValidationMessage.EMAIL_REQUIRED)
    private String email;

    @NotNull(message = ValidationMessage.PASSWORD_REQUIRED)
    @NotBlank(message = ValidationMessage.PASSWORD_REQUIRED)
    private String password;
}
