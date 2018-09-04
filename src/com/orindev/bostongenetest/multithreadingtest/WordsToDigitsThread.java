package com.orindev.bostongenetest.multithreadingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;

public class WordsToDigitsThread extends Thread {

    private final SortedSet<Integer> digits;

    private final DigitsFinder digitsFinder = new DigitsFinder();

    private List<String> strings;

    public WordsToDigitsThread(SortedSet<Integer> list) {
        digits = list;
    }

    @Override
    public void run() {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = null;
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if("STOP".equals(line)){
                return;
            }

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
