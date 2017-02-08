package org.nikolavp.algorithm.implementation;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/jumping-on-the-clouds
 */
public class JumpingOnTheClouds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean[] thunderCloud = new boolean[scanner.nextInt()];
        for (int i = 0; i < thunderCloud.length; i++) {
            if (scanner.nextInt() == 1) {
                thunderCloud[i] = true;
            }
        }

        int i = 0;
        int c = 0;
        while (i < thunderCloud.length - 1) {
            int twoHop = i + 2;
            if (twoHop < thunderCloud.length) {
                if (!thunderCloud[twoHop]) {
                    c++;
                    i += 2;
                    continue;
                }
            }
            int oneHop = i + 1;
            if (oneHop < thunderCloud.length) {
                if (!thunderCloud[oneHop]) {
                    c++;
                    i += 1;
                }
            }
        }
        System.out.println(c);
    }
}
