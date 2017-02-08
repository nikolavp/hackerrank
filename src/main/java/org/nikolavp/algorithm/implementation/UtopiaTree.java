package org.nikolavp.algorithm.implementation;

import java.util.Scanner;

/**
 * @author Nikola Petrov nikola.petrov@ontotext.com
 */
public class UtopiaTree {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		final int T = scanner.nextInt();

		for (int i = 0; i < T; i++) {
			final int cycle = scanner.nextInt();
			int result = 1;
			for (int j = 0; j < cycle; j++) {
				if (j % 2 == 0) {
					result *= 2;
				} else {
					result += 1;
				}
			}
			System.out.println(result);
		}
	}
}
