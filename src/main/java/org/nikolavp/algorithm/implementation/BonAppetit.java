package org.nikolavp.algorithm.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Nikola Petrov nikola.petrov@ontotext.com
 */
public class BonAppetit {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		final int n = scanner.nextInt();
		final int k = scanner.nextInt();

		int[] food = new int[n];
		for (int i = 0; i < n; i++) {
			food[i] = scanner.nextInt();
		}
		final int charged = scanner.nextInt();

		final int sum = Arrays.stream(food).sum();
		final int halfNeedsToBeSplit = (sum - food[k]) / 2;
		if (charged > halfNeedsToBeSplit) {
			System.out.println(charged - halfNeedsToBeSplit);
		} else {
			System.out.println("Bon Appetit");
		}
	}
}
