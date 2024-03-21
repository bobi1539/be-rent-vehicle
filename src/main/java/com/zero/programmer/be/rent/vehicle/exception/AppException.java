package com.zero.programmer.be.rent.vehicle.exception;

import com.zero.programmer.be.rent.vehicle.constant.GlobalMessage;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class AppException extends RuntimeException {
    private final HttpStatus httpStatus;
    private final String message;

    public AppException(GlobalMessage globalMessage) {
        super(globalMessage.message);
        this.httpStatus = globalMessage.httpStatus;
        this.message = globalMessage.message;
    }
}
