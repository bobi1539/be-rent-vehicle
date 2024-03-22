package com.zero.programmer.be.rent.vehicle.service;

import com.zero.programmer.be.rent.vehicle.constant.GlobalMessage;
import com.zero.programmer.be.rent.vehicle.exception.AppException;
import com.zero.programmer.be.rent.vehicle.util.Util;

public abstract class ValidationService extends BaseService {
    protected void validatePassword(String password, String repeatPassword) {
        validatePasswordContainNumber(password);
        validatePasswordContainUpperCaseLetter(password);
        validatePasswordContainSymbol(password);
        validateRepeatPassword(password, repeatPassword);
    }

    private void validatePasswordContainNumber(String password) {
        boolean isContainNumber = Util.isStringContainNumber(password);
        if (!isContainNumber) {
            throw new AppException(GlobalMessage.PASSWORD_MUST_CONTAIN_NUMBER);
        }
    }

    private void validatePasswordContainUpperCaseLetter(String password) {
        boolean isContainUpperCaseLetter = Util.isStringContainUpperCaseLetter(password);
        if (!isContainUpperCaseLetter) {
            throw new AppException(GlobalMessage.PASSWORD_MUST_CONTAIN_UPPER_CASE_LETTER);
        }
    }

    private void validatePasswordContainSymbol(String password) {
        boolean isContainSymbol = Util.isStringContainSymbol(password);
        if (!isContainSymbol) {
            throw new AppException(GlobalMessage.PASSWORD_MUST_CONTAIN_SYMBOL);
        }
    }

    private void validateRepeatPassword(String password, String repeatPassword) {
        if (!password.equals(repeatPassword)) {
            throw new AppException(GlobalMessage.PASSWORD_NOT_EQUAL);
        }
    }
}
