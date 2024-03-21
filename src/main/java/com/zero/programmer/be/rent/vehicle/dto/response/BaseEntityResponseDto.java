package com.zero.programmer.be.rent.vehicle.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public abstract class BaseEntityResponseDto {
    protected Timestamp createdAt;
    protected Long createdBy;
    protected String createdByName;
    protected Timestamp updatedAt;
    protected Long updatedBy;
    protected String updatedByName;
    protected boolean isDeleted = false;
}
