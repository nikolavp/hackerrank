package org.nikolavp.algorithm.implementation;

import java.util.Scanner;

/**
 * @author Nikola Petrov nikola.petrov@ontotext.com
 */
public class AngryProfessor {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		final int T = scanner.nextInt();

		for (int i = 0; i < T; i++) {
			final int N = scanner.nextInt();
			final int K = scanner.nextInt();
			int k = 0;
			for (int j = 0; j < N; j++) {
				if (scanner.nextInt() <= 0) {
					k++;
				}
			}
			if (k >= K) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}
	}
}
