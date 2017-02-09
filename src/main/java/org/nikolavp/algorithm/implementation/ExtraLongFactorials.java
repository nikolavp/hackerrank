package org.nikolavp.algorithm.implementation;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Nikola Petrov nikola.petrov@ontotext.com
 */
public class ExtraLongFactorials {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		final int n = scanner.nextInt();

		BigInteger result = BigInteger.ONE;
		for (int i = 1; i <= n; i++) {
			result = result.multiply(BigInteger.valueOf(i));
		}
		System.out.println(result);
	}
}
