package org.nikolavp.datastructures.algorithm.strings;

import java.util.Scanner;

public class Camelcase {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int words = 1;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                words++;
            }
        }
        System.out.println(words);
    }

}
