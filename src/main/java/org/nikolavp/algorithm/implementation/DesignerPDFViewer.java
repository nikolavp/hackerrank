package org.nikolavp.algorithm.implementation;

import java.util.Scanner;

/**
 * @author Nikola Petrov nikola.petrov@ontotext.com
 */
public class DesignerPDFViewer {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] lettersHeight = new int[26];
		for (int i = 0; i < lettersHeight.length; i++) {
			lettersHeight[i] = scanner.nextInt();
		}

		final String word = scanner.next();
		int tallest = Integer.MIN_VALUE;
		for (int i = 0; i < word.length(); i++) {
			final int index = word.charAt(i) - 97;
			tallest = Math.max(tallest, lettersHeight[index]);
		}
		System.out.println(tallest * word.length());
	}
}
