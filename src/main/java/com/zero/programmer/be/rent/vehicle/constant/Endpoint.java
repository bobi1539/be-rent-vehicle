package com.zero.programmer.be.rent.vehicle.constant;

import com.zero.programmer.be.rent.vehicle.exception.AppException;

public final class Endpoint {

    private Endpoint() {
        throw new AppException(GlobalMessage.CANNOT_INSTANCE_HELPER_CLASS);
    }
    public static final String BASE_ENDPOINT = "/api/rent-vehicle";
    public static final String USER = BASE_ENDPOINT + "/users";
}
