package org.nikolavp.algorithm.implementation;

import java.util.Scanner;

/**
 * @author Nikola Petrov nikola.petrov@ontotext.com
 */
public class Kangaroo {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x1 = in.nextInt();
		int v1 = in.nextInt();
		int x2 = in.nextInt();
		int v2 = in.nextInt();

		if (x1 > x2) {
			canMeet(v1, v2, x1 - x2);
		} else if (x1 == x2) {
			if (v1 == v2) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		} else {
			assert x1 < x2;
			canMeet(v2, v1, x2 - x1);
		}
	}

	private static void canMeet(int v1, int v2, int startingDistanceDifference) {
		if (v1 >= v2) {
			System.out.println("NO");
			return;
		}
		int speedDifference = v2 - v1;

		if (startingDistanceDifference % speedDifference == 0) {
			System.out.println("YES");
			return;
		}
		System.out.println("NO");
	}
}
