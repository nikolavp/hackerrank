package com.nikolavp.hourrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Nikola Petrov nikola.petrov@ontotext.com
 */
public class ContainersOfBalls {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		outer:
		for (int a0 = 0; a0 < q; a0++) {
			int n = in.nextInt();
//			int[][] M = new int[n][n];

			int[] containersSum = new int[n];
			int[] typesSum = new int[n];

			for (int container = 0; container < n; container++) {
				for (int type = 0; type < n; type++) {
					final int element = in.nextInt();
					containersSum[container] += element;
					typesSum[type] += element;
//					M[container][type] = element;
				}
			}
			Arrays.sort(containersSum);
			Arrays.sort(typesSum);

			for (int i = 0; i < containersSum.length; i++) {
				if (containersSum[i] != typesSum[i]) {
					System.out.println("Impossible");
					continue outer;
				}
			}

			System.out.println("Possible");
		}

		
	}
}
