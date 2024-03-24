package com.zero.programmer.be.rent.vehicle.util;

import com.zero.programmer.be.rent.vehicle.constant.GlobalMessage;
import com.zero.programmer.be.rent.vehicle.exception.AppException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Util {

    private Util() {
        throw new AppException(GlobalMessage.CANNOT_INSTANCE_HELPER_CLASS);
    }

    public static boolean isStringContainNumber(String value) {
        for (char c : value.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isStringContainUpperCaseLetter(String value) {
        for (char c : value.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isStringContainSymbol(String value) {
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(value);
        return matcher.find();
    }

    public static String generateRandomStringAndNumber(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = (int) (Math.random() * characters.length());
            char randomChar = characters.charAt(randomIndex);
            randomString.append(randomChar);
        }

        return randomString.toString();
    }
}
