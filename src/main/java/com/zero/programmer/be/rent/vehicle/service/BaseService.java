package com.zero.programmer.be.rent.vehicle.service;

import com.zero.programmer.be.rent.vehicle.dto.response.BaseEntityResponseDto;
import com.zero.programmer.be.rent.vehicle.entity.BaseEntity;

public abstract class BaseService {

    protected void mapBaseEntityToResponse(
            BaseEntityResponseDto responseDto, BaseEntity baseEntity
    ) {
        responseDto.setCreatedAt(baseEntity.getCreatedAt());
        responseDto.setCreatedBy(baseEntity.getCreatedBy());
        responseDto.setCreatedByName(baseEntity.getCreatedByName());
        responseDto.setUpdatedAt(baseEntity.getUpdatedAt());
        responseDto.setUpdatedBy(baseEntity.getUpdatedBy());
        responseDto.setUpdatedByName(baseEntity.getUpdatedByName());
    }
}
