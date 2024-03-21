package com.zero.programmer.be.rent.vehicle.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class HeaderRequest {

    @NotNull(message = "Id Pengguna Tidak Boleh Kosong")
    @NotBlank(message = "Id Pengguna Tidak Boleh Kosong")
    private String userId;

    @NotNull(message = "Nama Pengguna Tidak Boleh Kosong")
    @NotBlank(message = "Nama Pengguna Tidak Boleh Kosong")
    private String userFullName;
}
