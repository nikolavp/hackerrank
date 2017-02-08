package org.nikolavp.algorithm.implementation;

import java.util.Scanner;

/**
 * @author Nikola Petrov nikola.petrov@ontotext.com
 */
public class BiggerIsGreater {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		final int N = scanner.nextInt();

		for (int i = 0; i < N; i++) {
			final String input = scanner.next();
			boolean found = false;
			for (int j = input.length() -1; j >= 1; j--) {
				final char c = input.charAt(j);
				final char other = input.charAt(j - 1);
				if (c > other) {
					StringBuilder builder = new StringBuilder();
					builder.append(input.substring(0, j - 1));
					builder.append(c);
					builder.append(other);
					if (j + 1 < input.length()) {
						builder.append(input.substring(j + 1, input.length()));
					}
					System.out.println(builder.toString());
					found = true;
					break;
				}
			}
			if (!found) {
				System.out.println("no answer");
			}
		}
	}
}
