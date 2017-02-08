package com.nikolavp.warmup;

import java.util.Scanner;

/**
 * @author Nikola Petrov nikola.petrov@ontotext.com
 */
public class CompareTheTriplets {
	public static void main(String[] args) {
		int[] alice = new int[3];
		int[] bob = new int[3];

		Scanner scanner = new Scanner(System.in);
		populate(alice, scanner);
		populate(bob, scanner);
		int aliceScore = 0;
		int bobScore = 0;
		for (int i = 0; i < alice.length; i++) {
			if (alice[i] > bob[i]) {
				aliceScore++;
			} else if (alice[i] < bob[i]) {
				bobScore++;
			}
		}
		System.out.println(aliceScore + " " + bobScore);
	}

	private static void populate(int[] bob, Scanner scanner) {
		for (int i = 0; i < bob.length; i++) {
			bob[i] = scanner.nextInt();
		}
	}
}
