package org.nikolavp.algorithm.strings;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/mars-exploration
 */
public class MarsExploration {
    public static void main(String[] args) {
        String s = new Scanner(System.in).next();
        char[] expected = new char[] {'S', 'O', 'S'};
        int changed = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != expected[i % 3]) {
                changed++;
            }
        }
        System.out.println(changed);
    }
}
