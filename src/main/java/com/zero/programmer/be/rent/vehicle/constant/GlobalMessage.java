package com.zero.programmer.be.rent.vehicle.constant;

import org.springframework.http.HttpStatus;

public enum GlobalMessage {
    SUCCESS(HttpStatus.OK, "Success | Sukses"),
    WRONG_EMAIL_OR_PASSWORD(HttpStatus.UNAUTHORIZED, "Wrong Email Or Password | Email Atau Password Salah"),
    ACCOUNT_NOT_ACTIVE(HttpStatus.UNAUTHORIZED, "Account Not Active | Akun Tidak Aktif"),
    FORBIDDEN(HttpStatus.FORBIDDEN, "Forbidden | Forbidden"),
    DATA_NOT_FOUND(HttpStatus.BAD_REQUEST, "Data Not Found | Data Tidak Ditemukan"),
    EMAIL_IS_REGISTERED(HttpStatus.BAD_REQUEST, "Email Has Been Registered | Email Telah Terdaftar"),
    PASSWORD_MUST_CONTAIN_NUMBER(HttpStatus.BAD_REQUEST, "Password Must Contain Number | Password Harus Terdiri Dari Angka"),
    PASSWORD_MUST_CONTAIN_UPPER_CASE_LETTER(HttpStatus.BAD_REQUEST, "Password Must Contain Upper Case Letter | Password Harus Terdiri Dari Huruf Kapital"),
    PASSWORD_MUST_CONTAIN_SYMBOL(HttpStatus.BAD_REQUEST, "Password Must Contain Symbol | Password Harus Terdiri Dari Simbol"),
    PASSWORD_NOT_EQUAL(HttpStatus.BAD_REQUEST, "Password Not Same | Password Tidak Sama"),
    CANNOT_INSTANCE_HELPER_CLASS(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error | Internal Server Error"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error | Internal Server Error");
    public final HttpStatus httpStatus;
    public final String message;

    GlobalMessage(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
