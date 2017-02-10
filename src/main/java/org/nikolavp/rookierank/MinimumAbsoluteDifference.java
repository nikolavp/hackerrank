package org.nikolavp.rookierank;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumAbsoluteDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        Arrays.sort(numbers);

        int value = Integer.MAX_VALUE;
        for (int i = 1; i < numbers.length; i++) {
            value = Math.min(value, Math.abs(numbers[i - 1] - numbers[i]));
        }

        System.out.println(value);
    }
}
