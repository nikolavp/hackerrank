package org.nikolavp.algorithm.implementation;

import java.util.Scanner;

/**
 * @author Nikola Petrov nikola.petrov@ontotext.com
 */
public class AppleAndOrange {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int t = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		int m = in.nextInt();
		int n = in.nextInt();

		int applesOnHouse = 0;
		for (int i = 0; i < m; i++) {
			final int appleLocation = a + in.nextInt();
			if (inside(s, t, appleLocation)) {
				applesOnHouse++;
			}
		}

		int orangesOnHouse = 0;
		for (int orange_i = 0; orange_i < n; orange_i++) {
			final int orangeLocation = b + in.nextInt();
			if (inside(s, t, orangeLocation)) {
				orangesOnHouse++;
			}
		}

		System.out.println(applesOnHouse);
		System.out.println(orangesOnHouse);
	}

	private static boolean inside(int s, int t, int appleLocation) {
		return appleLocation >= s && appleLocation <= t;
	}
}
