package com.zero.programmer.be.rent.vehicle.constant;

import org.springframework.http.HttpStatus;

public enum GlobalMessage {
    SUCCESS(HttpStatus.OK, "Success | Sukses"),
    CANNOT_INSTANCE_HELPER_CLASS(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error | Internal Server Error"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error | Internal Server Error");
    public final HttpStatus httpStatus;
    public final String message;

    GlobalMessage(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
