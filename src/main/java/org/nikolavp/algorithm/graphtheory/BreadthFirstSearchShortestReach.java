package org.nikolavp.algorithm.graphtheory;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Nikola Petrov nikola.petrov@ontotext.com
 */
public class BreadthFirstSearchShortestReach {

	public static class Node {
		int distanceFromStartingNode = -1;
		List<Node> neighbours = new ArrayList<>();
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		final int T = scanner.nextInt();

		for (int i = 0; i < T; i++) {
			Node[] nodes = new Node[scanner.nextInt()];
			for (int j = 0; j < nodes.length; j++) {
				nodes[j] = new Node();
			}

			final int M = scanner.nextInt();
			for (int j = 0; j < M; j++) {
				final int start = scanner.nextInt() - 1;
				final int end = scanner.nextInt() - 1;
				nodes[start].neighbours.add(nodes[end]);
				nodes[end].neighbours.add(nodes[start]);
			}

			final int start = scanner.nextInt() - 1;
			Queue<Node> toVisit = new ArrayDeque<>();
			final Node node = nodes[start];
			node.distanceFromStartingNode = 0;
			toVisit.add(node);
			
			while (!toVisit.isEmpty()) {
				final Node next = toVisit.poll();
				for (Node other : next.neighbours) {
					if (other.distanceFromStartingNode == -1) {
						other.distanceFromStartingNode = next.distanceFromStartingNode + 6;
						toVisit.add(other);
					}
				}
			}

			for (int j = 0; j < nodes.length; j++) {
				if (j == start) {
					continue;
				}
				System.out.print(nodes[j].distanceFromStartingNode);
				if (j < nodes.length - 1) {
					System.out.print(' ');
				}
			}
			System.out.println();
		}
	}
}
