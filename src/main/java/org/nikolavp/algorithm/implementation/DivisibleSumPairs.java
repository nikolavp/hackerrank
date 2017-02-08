package org.nikolavp.algorithm.implementation;

import java.util.Scanner;

/**
 * @author Nikola Petrov nikola.petrov@ontotext.com
 */
public class DivisibleSumPairs {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int a[] = new int[n];
		for(int i=0; i < n; i++){
			a[i] = in.nextInt();
		}

		int c = 0;
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if ((a[i] + a[j]) % k == 0) {
					c++;
				}
			}
		}
		System.out.println(c);
	}
}
