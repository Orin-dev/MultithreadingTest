package com.zorinhome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WordsToDigitsThread extends Thread {

    private final List<Integer> digits;

    private final DigitsFinder digitsFinder = new DigitsFinder();

    private List<String> strings;

    public WordsToDigitsThread(List<Integer> list) {
        digits = list;
    }

    @Override
    public void run() {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

//        Scanner scanner = new Scanner(System.in);

        while (true) {
            String line = null;
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

//            digits.add(scanner.nextInt());

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            strings = Arrays.asList(line.split(" "));

            digitsFinder.setStrings(strings);
            try {
                int digit = digitsFinder.calculate();
                digits.add(digit);
            } catch (DigitNotFoundException e) {
                e.printStackTrace();
            }

        }
    }


}
