package com.zero.programmer.be.rent.vehicle.constant;

import com.zero.programmer.be.rent.vehicle.exception.AppException;

public final class ValidationMessage {
    private ValidationMessage() {
        throw new AppException(GlobalMessage.CANNOT_INSTANCE_HELPER_CLASS);
    }

    public static final String EMAIL_REQUIRED = "Email Is Required | Email Tidak Boleh Kosong";
    public static final String PASSWORD_REQUIRED = "Password Is Required | Password Tidak Boleh Kosong";

}
