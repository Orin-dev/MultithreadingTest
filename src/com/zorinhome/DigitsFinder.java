package com.zorinhome;

import java.util.List;

public class DigitsFinder {

    private List<String> strings;

    private int value;

    DigitsFinder(List<String> strings) {
        this.strings = strings;
    }

    private void getThousands(List<String> strings) throws DigitNotFoundException {
        if (strings.contains("thousand") && strings.indexOf("thousand") == 1 && strings.get(0).equals("one"))
            value += 1000;
        else if (strings.contains("thousands") && strings.indexOf("thousands") == 1)
            value += 1000 * findDigit(strings.get(0));
        else
            return;
        strings.remove(0);
        strings.remove(0);
    }

    private void getHundreds(List<String> strings) throws DigitNotFoundException {
        if (strings.contains("hundred") && (strings.indexOf("hundred") == 1) && strings.get(0).equals("one"))
            value += 100;
        else if (strings.contains("hundreds") && (strings.indexOf("hundred") == 1))
            value += 100 * findDigit(strings.get(0);
        else
            return;
        strings.remove(0);
        strings.remove(0);
    }

    private void getWhatElse(List<String> strings) throws DigitNotFoundException {
        int val = findLessTwenty(strings.get(0));

        if(val == 0) {
            val = findTens(strings.get(0));
            if (val > 0 && strings.size() == 2)
                value += findDigit(strings.get(1));
        }
        else return;
        value += val;
    }

    private int findDigit(String s) throws DigitNotFoundException {
        switch (s) {
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

    private int findTens(String s) throws DigitNotFoundException {
        switch (s) {
            case "twenty":
                return 20;
            case "thirty":
                return 30;
            case "forty":
                return 40;
            case "fifty":
                return 50;
            case "eighty":
                return 60;
            case "ninety":
                return 70;
            default:
                return 0;
        }
    }

    private int findLessTwenty(String s) throws DigitNotFoundException {
        switch (s) {
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
}
