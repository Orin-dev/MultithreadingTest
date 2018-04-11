package com.zorinhome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WordsToDigitsThread extends Thread {

    private volatile List<Integer> digits;

    public WordsToDigitsThread(List<Integer> list) {
        digits = list;
    }

    @Override
    public void run(){

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

//        Scanner scanner = new Scanner(System.in);

        while (true){
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

            List<String> strings = Arrays.asList(line.split(" "));

            int digit;

            if(strings.contains("thousand") || strings.contains("thousand"))



            for (String s: strings
                 ) {
                switch (s){
                    case "one":
                }
            }

        }
    }



    }
}
