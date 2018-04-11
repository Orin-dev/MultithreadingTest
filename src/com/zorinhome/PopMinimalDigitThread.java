package com.zorinhome;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class PopMinimalDigitThread extends Thread {

    private volatile List<Integer> digits;

    @Override
    public void run() {
        while (true) {
            synchronized (digits) {
                try {
                    if (digits.size() != 0) {
                        Integer min = Collections.min(digits);
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

    public PopMinimalDigitThread(List<Integer> digits) {
        this.digits = digits;
    }

    public List<Integer> getDigits() {
        return digits;
    }

    public void setDigits(List<Integer> digits) {
        this.digits = digits;
    }
}
