package com.zero.programmer.be.rent.vehicle.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class UtilTest {

    @Test
    void testIsStringContainNumber() {
        boolean isStringContainNumber = Util.isStringContainNumber("abc123");
        assertTrue(isStringContainNumber);

        isStringContainNumber = Util.isStringContainNumber("abc");
        assertFalse(isStringContainNumber);
    }

    @Test
    void testIsStringContainUpperCaseLetter() {
        boolean containUpperCase = Util.isStringContainUpperCaseLetter("Abcde");
        assertTrue(containUpperCase);

        containUpperCase = Util.isStringContainUpperCaseLetter("abc");
        assertFalse(containUpperCase);
    }

    @Test
    void testIsStringContainSymbol() {
        boolean containSymbol = Util.isStringContainSymbol("abc@123");
        assertTrue(containSymbol);

        containSymbol = Util.isStringContainSymbol("abc");
        assertFalse(containSymbol);
    }

    @Test
    void testGenerateRandomStringAndNumber() {
        String value = Util.generateRandomStringAndNumber(50);
        assertNotNull(value);
        log.info("Random String : {}", value);
    }
}