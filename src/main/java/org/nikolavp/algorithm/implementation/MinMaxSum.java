package org.nikolavp.algorithm.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Nikola Petrov nikola.petrov@ontotext.com
 */
public class MinMaxSum {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		long numbers[] = new long[5];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = scanner.nextInt();
		}

		final long sum = Arrays.stream(numbers).sum();
		long min = Long.MAX_VALUE;
		long max = Long.MIN_VALUE;
		for (int i = 0; i < numbers.length; i++) {
			long fourSumWithoutI = sum - numbers[i];
			min = Math.min(fourSumWithoutI, min);
			max = Math.max(fourSumWithoutI, max);
		}
		System.out.println(min + " " + max);
	}
}
