package org.nikolavp.algorithm.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Nikola Petrov nikola.petrov@ontotext.com
 */
public class BetweenTwoSets {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		int[] b = new int[m];
		for (int i = 0; i < m; i++) {
			b[i] = in.nextInt();
		}

		final int lcm = lcm(a);
		final int gcd = gcd(b);
		int c = 0;
		int i = 1;
		while (i * lcm <= gcd) {
			if (gcd % (i * lcm) == 0) {
				c++;
			}
			i++;
		}
		System.out.println(c);
	}

	private static int gcd(int a, int b) {
		while (b > 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}

	private static int gcd(int[] array) {
		return Arrays.stream(array).reduce(BetweenTwoSets::gcd).getAsInt();
	}

	private static int lcm(int a, int b) {
		return a * (b / gcd(a, b));
	}

	private static int lcm(int[] array) {
		return Arrays.stream(array).reduce(BetweenTwoSets::lcm).getAsInt();
	}

}
