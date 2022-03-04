package com.leetcode;

public class StringIntTest {

	public static long intToString () {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            String j = Integer.toString(i);
        }
        long finishTime = System.currentTimeMillis();

        return finishTime - startTime;
    }

    public static long stringValueOf () {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            String j = String.valueOf(i);
        }
        long finishTime = System.currentTimeMillis();

        return finishTime - startTime;
    }

    public static void main(String[] args) {
        long intToStringElapsed = 0;
        long stringValueOfElapsed = 0;
        for (int i = 0; i < 10; i++) {
            stringValueOfElapsed+= stringValueOf();
            intToStringElapsed += intToString();
        }
        System.out.println("Average intToString = " + (intToStringElapsed / 10));
        System.out.println("Average stringValueOf = " + (stringValueOfElapsed / 10));
    }
}
