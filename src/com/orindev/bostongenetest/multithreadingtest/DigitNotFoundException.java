package com.orindev.bostongenetest.multithreadingtest;

public class DigitNotFoundException extends Exception {
    DigitNotFoundException() {
        super("Digit not found or wrong grammar");
    }
}
