package com.orindev.bostongenetest.multithreadingtest;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        SortedSet<Integer> list = Collections.synchronizedSortedSet(new TreeSet<>());

        WordsToDigitsThread wordsToDigitsThread = new WordsToDigitsThread(list);
        wordsToDigitsThread.start();

	    PopMinimalDigitThread popMinimalDigitThread = new PopMinimalDigitThread(list);
	    popMinimalDigitThread.start();

    }
}
