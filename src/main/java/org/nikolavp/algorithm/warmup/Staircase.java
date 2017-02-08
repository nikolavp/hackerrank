package com.nikolavp.warmup;

import java.util.Scanner;

/**
 * @author Nikola Petrov nikola.petrov@ontotext.com
 */
public class Staircase {
	public static void main(String[] args) {
		final int n = new Scanner(System.in).nextInt();

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < n - i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print("#");
			}
			System.out.println();
		}
	}
}
