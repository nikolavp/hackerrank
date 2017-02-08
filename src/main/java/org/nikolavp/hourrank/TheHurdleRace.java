package com.nikolavp.hourrank;

import java.util.Scanner;

/**
 * @author Nikola Petrov nikola.petrov@ontotext.com
 */
public class TheHurdleRace {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		final int n = scanner.nextInt();
		final int k = scanner.nextInt();

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			final int h_i = scanner.nextInt();
			max = Math.max(h_i, max);
		}

		if (max > k) {
			System.out.println(max - k);
		} else {
			System.out.println(0);
		}
	}
}
