package org.nikolavp.algorithm.implementation;

import java.util.Scanner;

/**
 * @author Nikola Petrov nikola.petrov@ontotext.com
 */
public class Encryption {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		final String sentence = scanner.nextLine()
				.replace(" ", "");

		final int length = sentence.length();
		final int lower = (int) Math.floor(Math.sqrt(length));
		final int ceil = (int) Math.ceil(Math.sqrt(length));

		int rows;
		int columns = 0;
		boolean found = false;
		outer:
		for (rows = lower; rows <= ceil; rows++) {
			for (columns = rows; columns <= ceil; columns++) {
				if (rows * columns >= length) {
					break outer;
				}
			}
		}

		for (int i = 0; i < columns; i++) {
			for (int j = 0; j < rows; j++) {
				final int index = i + j * columns;
				if (index < length) {
					System.out.print(sentence.charAt(index));
				}
			}
			System.out.print(' ');
		}
		System.out.println();
	}
}
