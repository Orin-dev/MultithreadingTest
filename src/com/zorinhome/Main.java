package com.zorinhome;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> list = Collections.synchronizedList(new ArrayList<>());

        WordsToDigitsThread wordsToDigitsThread = new WordsToDigitsThread(list);
        wordsToDigitsThread.start();

	    PopMinimalDigitThread popMinimalDigitThread = new PopMinimalDigitThread(list);
	    popMinimalDigitThread.start();



    }
}
