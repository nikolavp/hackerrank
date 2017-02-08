package org.nikolavp.algorithm.implementation;

import java.util.Scanner;

/**
 * @author Nikola Petrov nikola.petrov@ontotext.com
 */
public class NonDivisibleSubset {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		final int n = scanner.nextInt();
		int[] buckets = new int[scanner.nextInt()];

		for (int i = 0; i < n; i++) {
			buckets[scanner.nextInt() % buckets.length]++;
		}

		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] > 0) {
				if (i * 2 % buckets.length == 0) {
					buckets[i] = 1;
				}
			}
		}

		int result = buckets[0];
		for (int i = 1; i <= buckets.length / 2; i++) {
			final int otherIdx = buckets.length - i;
			result += Math.max(buckets[i], buckets[otherIdx]);
		}
		System.out.println(result);
	}
}
