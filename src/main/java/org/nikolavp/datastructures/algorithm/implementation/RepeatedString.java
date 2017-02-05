package org.nikolavp.datastructures.algorithm.implementation;

import java.util.Scanner;

public class RepeatedString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.next();
        long N = scanner.nextLong();

        long fullStringTimes = N / string.length();
        int remaining = (int) (N % string.length());

        System.out.println(fullStringTimes * occurances(string, string.length()) + occurances(string, remaining));
    }

    private static int occurances(String string, int to) {
        int numberOfAInSingleString = 0;
        for (int i = 0; i < to; i++) {
            if (string.charAt(i) == 'a') {
                numberOfAInSingleString++;
            }
        }
        return numberOfAInSingleString;
    }
}
