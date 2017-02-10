package org.nikolavp.rookierank;

import java.util.Scanner;

public class HackerRankInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        String hackerrank = "hackerrank";
        for (int i = 0; i < T; i++) {
            String string = scanner.next();
            int idx = 0;
            for (int j = 0; j < string.length(); j++) {
                if (hackerrank.charAt(idx) == string.charAt(j)) {
                    idx++;
                }
                if (idx == hackerrank.length()) {
                    break;
                }
            }
            System.out.println(idx == hackerrank.length() ? "YES" : "NO");
        }
    }
}
