package com.zero.programmer.be.rent.vehicle.controller;

import com.zero.programmer.be.rent.vehicle.constant.GlobalMessage;
import com.zero.programmer.be.rent.vehicle.dto.request.HeaderRequest;
import com.zero.programmer.be.rent.vehicle.dto.response.BaseResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
@Slf4j
public abstract class BaseController {

    public static <T> BaseResponse<T> buildSuccessResponse(T object) {
        return BaseResponse.<T>builder()
                .code(GlobalMessage.SUCCESS.httpStatus.value())
                .message(GlobalMessage.SUCCESS.message)
                .data(object)
                .build();
    }

    @ModelAttribute("header")
    public HeaderRequest buildHeader(HttpServletRequest request) {
        if (!ObjectUtils.isEmpty(request.getAttribute("header"))) {
            return (HeaderRequest) request.getAttribute("header");
        } else {
            return HeaderRequest.builder()
                    .userId(getHeader(request, "userId"))
                    .userFullName(getHeader(request, "fullName"))
                    .build();
        }
    }

    private String getHeader(HttpServletRequest servletRequest, String header) {
        return !ObjectUtils.isEmpty(servletRequest.getHeader(header)) ? servletRequest.getHeader(header) : "";
    }
}
