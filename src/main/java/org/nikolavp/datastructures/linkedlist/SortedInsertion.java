package org.nikolavp.datastructures.linkedlist;

import java.util.Scanner;

public class SortedInsertion {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node tree = null;
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            tree = SortedInsert(tree, scanner.nextInt());
        }
    }

    private static class Node {
        int data;
        Node next;
        Node prev;
    }

    private static Node SortedInsert(Node head,int data) {
        Node newNode = new Node();
        newNode.data = data;
        if (head == null) {
            return newNode;
        }
        Node current = head;
        while (current.next != null && current.next.data <= data) {
            current = current.next;
        }

        if (current.next == null) {
            //append to list
            newNode.prev = current;
            current.next = newNode;
        } else {
            // put new node in the middle
            current.next.prev = newNode;
            newNode.next = current.next;
            current.next = newNode;
            newNode.prev = current;

        }
        return head;
    }
}
