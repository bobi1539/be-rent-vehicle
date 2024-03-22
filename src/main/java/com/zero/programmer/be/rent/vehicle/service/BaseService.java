package com.zero.programmer.be.rent.vehicle.service;

import com.zero.programmer.be.rent.vehicle.constant.Constant;
import com.zero.programmer.be.rent.vehicle.dto.response.BaseEntityResponseDto;
import com.zero.programmer.be.rent.vehicle.dto.response.RoleResponseDto;
import com.zero.programmer.be.rent.vehicle.dto.response.UserResponseDto;
import com.zero.programmer.be.rent.vehicle.entity.BaseEntity;
import com.zero.programmer.be.rent.vehicle.entity.MRole;
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
                .role(mapRoleToResponse(user.getRole()))
                .build();
        mapBaseEntityToResponse(userResponseDto, user);
        return userResponseDto;
    }

    protected RoleResponseDto mapRoleToResponse(MRole role) {
        RoleResponseDto roleResponseDto = RoleResponseDto.builder()
                .id(role.getId())
                .name(role.getName())
                .build();
        mapBaseEntityToResponse(roleResponseDto, role);
        return roleResponseDto;
    }

    protected void setCreatedAndUpdatedBySystem(BaseEntity baseEntity) {
        baseEntity.setCreatedBy(1L);
        baseEntity.setCreatedByName(Constant.SYSTEM);
        baseEntity.setUpdatedBy(1L);
        baseEntity.setUpdatedByName(Constant.SYSTEM);
    }
}
