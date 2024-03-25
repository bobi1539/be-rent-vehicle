package com.zero.programmer.be.rent.vehicle.dto.request;

import com.zero.programmer.be.rent.vehicle.constant.ValidationMessage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RegisterCustomerRequestDto {


    @NotNull(message = ValidationMessage.FULL_NAME_REQUIRED)
    @NotBlank(message = ValidationMessage.FULL_NAME_REQUIRED)
    private String fullName;

    @NotNull(message = ValidationMessage.EMAIL_REQUIRED)
    @NotBlank(message = ValidationMessage.EMAIL_REQUIRED)
    private String email;

    @NotNull(message = ValidationMessage.PASSWORD_REQUIRED)
    @NotBlank(message = ValidationMessage.PASSWORD_REQUIRED)
    @Length(min = 8, message = ValidationMessage.PASSWORD_MIN)
    private String password;

    @NotNull(message = ValidationMessage.REPEAT_PASSWORD_REQUIRED)
    @NotBlank(message = ValidationMessage.REPEAT_PASSWORD_REQUIRED)
    private String repeatPassword;

    @NotNull(message = ValidationMessage.IS_ACTIVE_REQUIRED)
    private Boolean isActive;
}
