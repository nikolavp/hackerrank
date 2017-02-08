package org.nikolavp.algorithm.graphtheory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EvenTree {

    private static Node[] vertices;
    private static int edgesToRemove = 0;

    private static class Node {
        private final int n;
        List<Integer> connectedNeighbours = new ArrayList<>();
        private boolean visited;

        public Node(int i) {
            this.n = i;
        }

        public void visit() {
            visited = true;
        }

        @Override
        public String toString() {
            return n + " to " + connectedNeighbours;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        vertices = new Node[N];
        for (int i = 0; i < vertices.length; i++) {
            vertices[i] = new Node(i);
        }

        for (int i = 0; i < M; i++) {
            int node1 = scanner.nextInt() - 1;
            int node2 = scanner.nextInt() - 1;
            vertices[node1].connectedNeighbours.add(node2);
            vertices[node2].connectedNeighbours.add(node1);
        }

        visit(vertices[0]);
        System.out.println(edgesToRemove);
    }

    private static int visit(Node node) {
        node.visit();

        int numberOfNodesInSubtree = 0;
        for (int n : node.connectedNeighbours) {
            if (!vertices[n].visited) {
                numberOfNodesInSubtree += visit(vertices[n]);
            }
        }

        /*
         * Don't remove edges for the starting node because it is not connected to another node.
         */
        if (node.n != 0 && numberOfNodesInSubtree > 0 && numberOfNodesInSubtree % 2 == 1) {
            edgesToRemove++;
            return 0;
        }

        return numberOfNodesInSubtree + 1;
    }
}
