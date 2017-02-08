package com.nikolavp.sorting;

import java.util.Scanner;

/**
 * @author Nikola Petrov nikola.petrov@ontotext.com
 */
public class IntroToTutorialChallenge {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int toFind = scanner.nextInt();
		int arraySize = scanner.nextInt();
		for (int i = 0; i < arraySize; i++) {
			if (scanner.nextInt() == toFind) {
				System.out.println(i);
				break;
			}
		}

	}
}
