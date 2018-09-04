package com.orindev.bostongenetest.multithreadingtest;

import java.util.NoSuchElementException;
import java.util.SortedSet;

public class PopMinimalDigitThread extends Thread {

    private volatile SortedSet<Integer> digits;

    @Override
    public void run() {
        while (true) {
            synchronized (digits) {
                try {
                    if (digits.size() != 0) {
                        Integer min = digits.first();
                        digits.remove(min);
                        System.out.println("Minimal digit is " + min);
                    }
                } catch (NoSuchElementException e) {
                    e.printStackTrace();
                }

            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public PopMinimalDigitThread(SortedSet<Integer> digits) {
        this.digits = digits;
    }

    public SortedSet<Integer> getDigits() {
        return digits;
    }

    public void setDigits(SortedSet<Integer> digits) {
        this.digits = digits;
    }
}
