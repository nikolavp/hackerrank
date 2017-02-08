package com.nikolavp.dynamicprogramming;

import java.util.Scanner;

/**
 * @author Nikola Petrov nikola.petrov@ontotext.com
 */
public class Equal {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		final int T = scanner.nextInt();

		for (int i = 0; i < T; i++) {
			System.out.println(runTestCase(scanner));
		}
	}

	private static int runTestCase(Scanner scanner) {
		int N = scanner.nextInt();
		int[] collegues = new int[N];

		int min = Integer.MAX_VALUE;
		for (int j = 0; j < N; j++) {
			collegues[j] = scanner.nextInt();
			min = Math.min(min, collegues[j]);
		}
		int operations = tryWith(collegues, min);
		for (int i = 1; i < 4; i++) {
			final int target = min - i;
			if (target < 0) {
				break;
			}

			operations = Math.min(operations, tryWith(collegues, target));
		}


		return operations;
	}

	private static int tryWith(int[] collegues, int min) {
		collegues = collegues.clone();
		for (int i = 0; i < collegues.length; i++) {
			collegues[i] -= min;
		}

		int operations = 0;
		for (int i = 0; i < collegues.length; i++) {
			while (collegues[i] > 0) {
				if (collegues[i] >= 5) {
					collegues[i] -= 5;
					operations++;
				} else if (collegues[i] >= 2) {
					collegues[i] -= 2;
					operations++;
				} else {
					assert collegues[i] >= 1;
					collegues[i] -= 1;
					operations++;
				}
			}
		}
		return operations;
	}
}
