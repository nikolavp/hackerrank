package org.nikolavp.algorithm.graphtheory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * @author Nikola Petrov nikola.petrov@ontotext.com
 */
public class JourneyToTheMoon {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		final int N = scanner.nextInt();
		final int I = scanner.nextInt();

		/* This exploits the fact that the nodes are from 0 to N -1 */
		DisjointSet set = new DisjointSet(N);
		for (int i = 0; i < I; i++) {
			set.union(set.findRoot(scanner.nextInt()), set.findRoot(scanner.nextInt()));
		}
		final Map<Integer, Counter> frequencies = set.frequencies();

		long sum = 0;
		long total = 0;

		for (Counter frequency : frequencies.values()) {
			total += sum * frequency.c;
			sum += frequency.c;
		}
		System.out.println(total);
	}

	private static class Counter {
		int c;

		@Override
		public String toString() {
			return String.valueOf(c);
		}
	}

	private static class DisjointSet {

		private final int[] set;

		public DisjointSet(int n) {
			this.set = new int[n];
			Arrays.fill(set, -1);
		}

		public void union(int a, int b) {
			if (a == b) {
				// nothing to do here;
				return;
			}
			assert set[a] < 0;
			assert set[b] < 0;
			if (set[b] < set[a]) {
				set[a] = b; // b is the new root because it is "taller" meaning it got more union calls
			} else {
				if (set[a] == set[b]) {
					set[b]--;
				}
				set[b] = a;
			}
		}

		public int findRoot(int x) {
			if (set[x] < 0) {
				return x;
			}
			set[x] = findRoot(set[x]);
			return set[x];
		}

		public Map<Integer, Counter> frequencies() {
			Map<Integer, Counter> result = new HashMap<>();
			for (int i = 0; i < set.length; i++) {
				final Counter frequency = result.computeIfAbsent(findRoot(i), (ignored) -> new Counter());
				frequency.c++;
			}
			return result;
		}
	}

}
