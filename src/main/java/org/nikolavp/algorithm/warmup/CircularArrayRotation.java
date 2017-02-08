package com.nikolavp.warmup;

import java.util.Scanner;

/**
 * @author Nikola Petrov nikola.petrov@ontotext.com
 */
public class CircularArrayRotation {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		final int n = scanner.nextInt();
		final int k = scanner.nextInt() % n;
		final int q = scanner.nextInt();

		int[] array = new int[n];
		for (int i = 0; i < array.length; i++) {
			array[i] = scanner.nextInt();
		}

		for (int i = 0; i < q; i++) {
			final int index = scanner.nextInt();
			int rotations = index - k;
			if (rotations < 0) {
				rotations += array.length;
			}
			System.out.println(array[rotations]);
		}
	}
}
