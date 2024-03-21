package com.zero.programmer.be.rent.vehicle.controller;

import com.zero.programmer.be.rent.vehicle.constant.Constant;
import com.zero.programmer.be.rent.vehicle.constant.GlobalMessage;
import com.zero.programmer.be.rent.vehicle.dto.response.BaseResponse;
import com.zero.programmer.be.rent.vehicle.exception.AppException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@AllArgsConstructor
@Slf4j
public class ErrorHandlerController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse<Object>> exception(Exception e) {
        log.error(Constant.ERROR, e);

        BaseResponse<Object> baseResponse = BaseResponse.builder()
                .code(GlobalMessage.INTERNAL_SERVER_ERROR.httpStatus.value())
                .message(GlobalMessage.INTERNAL_SERVER_ERROR.message)
                .build();
        return new ResponseEntity<>(baseResponse, GlobalMessage.INTERNAL_SERVER_ERROR.httpStatus);
    }

    @ExceptionHandler(AppException.class)
    public ResponseEntity<BaseResponse<Object>> exception(AppException e) {
        log.error(Constant.ERROR, e);

        BaseResponse<Object> baseResponse = BaseResponse.builder()
                .code(e.getHttpStatus().value())
                .message(e.getMessage())
                .build();
        return new ResponseEntity<>(baseResponse, e.getHttpStatus());
    }
}
