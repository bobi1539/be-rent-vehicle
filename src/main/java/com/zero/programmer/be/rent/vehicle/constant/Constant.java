package com.zero.programmer.be.rent.vehicle.constant;

import com.zero.programmer.be.rent.vehicle.exception.AppException;

public final class Constant {

    private Constant() {
        throw new AppException(GlobalMessage.CANNOT_INSTANCE_HELPER_CLASS);
    }
    public static final String ERROR = "Error : ";
    public static final String SYSTEM = "SYSTEM";
    public static final String FROM_EMAIL = "burnedeadapp@gmail.com";
    public static final String LINK_EMAIL_VERIFICATION = "http://localhost:5173/auth/email-verification?token=";
}
