package com.zorinhome;

public class DigitNotFoundException extends Exception {
    DigitNotFoundException(){
        super("Digit not found or wrong grammar");
    }
}
