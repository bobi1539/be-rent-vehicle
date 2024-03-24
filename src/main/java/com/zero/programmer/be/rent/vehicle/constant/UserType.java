package com.zero.programmer.be.rent.vehicle.constant;

public enum UserType {
    ADMIN("ADMIN"),
    CUSTOMER("CUSTOMER");

    public final String value;

    UserType(String value) {
        this.value = value;
    }
}
