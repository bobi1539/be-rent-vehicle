package com.zero.programmer.be.rent.vehicle.service;

import com.zero.programmer.be.rent.vehicle.dto.response.BaseEntityResponseDto;
import com.zero.programmer.be.rent.vehicle.dto.response.UserResponseDto;
import com.zero.programmer.be.rent.vehicle.entity.BaseEntity;
import com.zero.programmer.be.rent.vehicle.entity.MUser;

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

    protected UserResponseDto mapUserToResponse(MUser user) {
        UserResponseDto userResponseDto = UserResponseDto.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .isActive(user.isActive())
                .type(user.getType())
                .build();
        mapBaseEntityToResponse(userResponseDto, user);
        return userResponseDto;
    }
}
