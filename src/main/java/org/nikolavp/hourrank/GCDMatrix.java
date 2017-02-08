package com.nikolavp.hourrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Nikola Petrov nikola.petrov@ontotext.com
 */
public class GCDMatrix {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int q = in.nextInt();
		int[] a = new int[n];
		for(int a_i=0; a_i < n; a_i++){
			a[a_i] = in.nextInt();
		}
		int[] b = new int[m];
		for(int b_i=0; b_i < m; b_i++){
			b[b_i] = in.nextInt();
		}

		for(int a0 = 0; a0 < q; a0++){
			int r1 = in.nextInt();
			int c1 = in.nextInt();
			int r2 = in.nextInt();
			int c2 = in.nextInt();

			Set<Integer> set = new HashSet<>();
			for (int i = r1; i <= r2; i++) {
				for (int j = c1; j <= c2; j++) {
					set.add(gcd(a[i], b[j]));
				}
			}
			System.out.println(set.size());
		}
	}

	public static int gcd(int a, int b) {
		while (b != 0) {
			int temp = b;
			b = a % b;
			a = temp;
		}
		return a;
	}
}
