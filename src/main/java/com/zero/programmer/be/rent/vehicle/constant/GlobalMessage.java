package com.zero.programmer.be.rent.vehicle.constant;

import org.springframework.http.HttpStatus;

public enum GlobalMessage {
    SUCCESS(HttpStatus.OK, "Success | Sukses"),
    WRONG_EMAIL_OR_PASSWORD(HttpStatus.UNAUTHORIZED, "Wrong Email Or Password | Email Atau Password Salah"),
    ACCOUNT_NOT_ACTIVE(HttpStatus.UNAUTHORIZED, "Account Not Active | Akun Tidak Aktif"),
    DATA_NOT_FOUND(HttpStatus.BAD_REQUEST, "Data Not Found | Data Tidak Ditemukan"),
    FORBIDDEN(HttpStatus.FORBIDDEN, "Forbidden | Forbidden"),
    CANNOT_INSTANCE_HELPER_CLASS(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error | Internal Server Error"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error | Internal Server Error");
    public final HttpStatus httpStatus;
    public final String message;

    GlobalMessage(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
