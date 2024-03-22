package com.zero.programmer.be.rent.vehicle.constant;

import com.zero.programmer.be.rent.vehicle.exception.AppException;

public final class ValidationMessage {
    private ValidationMessage() {
        throw new AppException(GlobalMessage.CANNOT_INSTANCE_HELPER_CLASS);
    }

    public static final String EMAIL_REQUIRED = "Email Is Required | Email Tidak Boleh Kosong";
    public static final String PASSWORD_REQUIRED = "Password Is Required | Password Tidak Boleh Kosong";
    public static final String REPEAT_PASSWORD_REQUIRED = "Repeat Password Is Required | Ulangi Password Tidak Boleh Kosong";
    public static final String FULL_NAME_REQUIRED = "Full Name Is Required | Nama Lengkap Tidak Boleh Kosong";
    public static final String PASSWORD_MIN = "Password Minimum 8 Character | Password Minimal 8 Karakter";
}
