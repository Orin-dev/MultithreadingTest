package com.orindev.bostongenetest.multithreadingtest;

import java.util.List;

public class DigitsFinder {

    private List<String> strings;

    private int value;

    DigitsFinder(List<String> strings) {
        this.strings = strings;
    }

    public int calculate() throws DigitNotFoundException {
        getThousands();
        getHundreds();
        getWhatElse();

        int result = value;
        value = 0;

        return result;
    }

    private void getThousands() throws DigitNotFoundException {
        if (strings.contains("thousand") && strings.indexOf("thousand") == 1 && strings.get(0).equals("one"))
            value += 1000;
        else if (strings.contains("thousands") && strings.indexOf("thousands") == 1)
            value += 1000 * findDigit(strings.get(0));
        else
            return;
        strings = strings.subList(2, strings.size());
    }

    private void getHundreds() throws DigitNotFoundException {
        if (strings.contains("hundred") && (strings.indexOf("hundred") == 1) && strings.get(0).equals("one"))
            value += 100;
        else if (strings.contains("hundreds") && (strings.indexOf("hundreds") == 1))
            value += 100 * findDigit(strings.get(0));
        else
            return;
        strings = strings.subList(2, strings.size());
    }

    private void getWhatElse() throws DigitNotFoundException {
        int val = 0;
        try {
            val = findDigit(strings.get(0));
        } catch (DigitNotFoundException e) {
            val = findTeens(strings.get(0));
        }

        if (val == 0) {
            val = findTens(strings.get(0));
            if (val > 0 && strings.size() == 2)
                value += findDigit(strings.get(1));
        } else if (strings.size() < 2) {
            value += val;
            return;
        } else throw new DigitNotFoundException();
        value += val;
    }

    private int findDigit(String s) throws DigitNotFoundException {
        switch (s) {
            case "zero":
                return 0;
            case "one":
                return 1;
            case "two":
                return 2;
            case "three":
                return 3;
            case "four":
                return 4;
            case "five":
                return 5;
            case "six":
                return 6;
            case "seven":
                return 7;
            case "eight":
                return 8;
            case "nine":
                return 9;
            default:
                throw new DigitNotFoundException();
        }
    }

    private int findTens(String s) {
        switch (s) {
            case "twenty":
                return 20;
            case "thirty":
                return 30;
            case "forty":
                return 40;
            case "fifty":
                return 50;
            case "sixty":
                return 60;
            case "seventy":
                return 70;
            case "eighty":
                return 80;
            case "ninety":
                return 90;
            default:
                return 0;
        }
    }

    private int findTeens(String s) {
        switch (s) {
            case "ten":
                return 10;
            case "eleven":
                return 11;
            case "twelve":
                return 12;
            case "thirteen":
                return 13;
            case "fourteen":
                return 14;
            case "fifteen":
                return 15;
            case "sixteen":
                return 16;
            case "seventeen":
                return 17;
            case "eighteen":
                return 18;
            case "nineteen":
                return 19;
            default:
                return 0;
        }
    }

    public DigitsFinder() {
    }

    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }

}
