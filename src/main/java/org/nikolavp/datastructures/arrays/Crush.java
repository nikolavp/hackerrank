package org.nikolavp.datastructures.arrays;

import java.util.Scanner;

public class Crush {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        long[] arrayOfDiffs = new long[N + 1];
        for (int i = 0; i < M; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int k = scanner.nextInt();

            /**
             * Instead of updating all the elements we can keep track of the diferences in the subsequent
             * elements. This gives a much better complexity and passes all tests
             */
            arrayOfDiffs[a] += k;
            if (b + 1 < arrayOfDiffs.length) {
                arrayOfDiffs[b + 1] -= k;
            }
        }

        long max = Long.MIN_VALUE;
        long soFar = 0;
        for (int i = 1; i < arrayOfDiffs.length; i++) {
            soFar += arrayOfDiffs[i];
            max = Math.max(max, soFar);
        }
        System.out.println(max);
    }
}
