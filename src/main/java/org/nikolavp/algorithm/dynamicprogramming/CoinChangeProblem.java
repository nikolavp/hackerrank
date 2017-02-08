package com.nikolavp.dynamicprogramming;

import java.util.Scanner;

/**
 * @author Nikola Petrov nikola.petrov@ontotext.com
 */
public class CoinChangeProblem {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		final int N = scanner.nextInt();
		final int M = scanner.nextInt();
		int coins[] = new int[M];
		for (int i = 0; i < coins.length; i++) {
			coins[i] = scanner.nextInt();
		}

		long[] results = new long[N + 1];
		results[0] = 1;

		// Add coins to the solution gradually
		// in the end the last element in the array is the answer
		// and on each slot we have the answer for the coins to that
		// place
		for (int coin : coins) {
			// we just simulate adding the coin to the solutions from the previous iteration
			for (int j = coin; j <= N; j++) {
				results[j] += results[j - coin];
			}
		}
		System.out.println(results[N]);
	}
}
