package org.nikolavp.algorithm.implementation;

import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Nikola Petrov nikola.petrov@ontotext.com
 */
public class AlmostSorted {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		final int n = scanner.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < array.length; i++) {
			array[i] = scanner.nextInt();
		}

		System.out.println(sort(array));
	}

	private static String sort(int... array) {

		if (array.length == 2) {
			if (array[0] > array[1]) {
				return "yes\nswap 1 2";
			}
			return "yes";
		}

		int firstDifference = -1;
		int reverseEnd = -1;
		int otherDifference = -1;
		boolean no = false;
		for (int i = 1; i < array.length; i++) {
			final int other = i - 1;
			if (reverseEnd != -1 && array[other] < array[i]) {
				no = true;
				if (array[firstDifference] > array[i]) {
					return "no";
				}
			}
			if (array[other] > array[i]) {
				if (firstDifference == -1) {
					firstDifference = other;
				} else {
					if (no) {
						return "no";
					}
					if (reverseEnd == -1 && firstDifference + 2 < i) {
						if (otherDifference != -1) {
							return "no";
						}
						otherDifference = i;
					} else {
						reverseEnd = i;
					}
				}
			}
		}

		if (firstDifference == -1) {
			return "yes";
		}

		if (reverseEnd != -1) {
			return "yes\nreverse " + (firstDifference + 1) + " " + (reverseEnd + 1);
		}

		if (otherDifference != -1) {
			return "yes\nswap " + (firstDifference + 1) + " " + (otherDifference + 1);
		}

		if (array[firstDifference] > array[firstDifference + 1]) {
			if (firstDifference + 2 < array.length && array[firstDifference + 2] < array[firstDifference]) {
				return "no";
			}
			if (firstDifference - 1 >= 0 && array[firstDifference - 1] > array[firstDifference + 1]) {
				return "no";
			}
			return "yes\nswap " + (firstDifference + 1) + " " + (firstDifference + 2);
		}

		return "no";
	}

	public static class TestClass {
		@Test
		public void shouldProperlySortList() throws Exception {
			Assert.assertEquals("yes\nswap 4 5", sort(1, 2, 3, 5, 4, 6));
			Assert.assertEquals("no", sort(new int[] {1, 5, 4, 3, 2, 3}));
			Assert.assertEquals("no", sort(new int[] {1, 5, 4, 3, 4}));
			Assert.assertEquals("yes\nswap 2 5", sort(new int[] {1, 5, 3, 4, 2}));
			Assert.assertEquals("yes\nreverse 2 5", sort(new int[] {1, 5, 4, 3, 2, 6}));
			Assert.assertEquals("yes\nswap 1 2", sort(new int[] {4, 2}));
			Assert.assertEquals("yes", sort(new int[] {2, 4}));
			Assert.assertEquals("no", sort(new int[] {3, 1, 2}));
		}
		
	}
}
