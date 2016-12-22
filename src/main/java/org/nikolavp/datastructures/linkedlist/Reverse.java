package org.nikolavp.datastructures.linkedlist;

public class Reverse {

    private static class Node {
        int data;
        Node next;
        Node prev;
    }


    private static Node Reverse(Node head) {
        if (head == null) {
            return null;
        }
        Node current = head;
        Node prev;
        while (current.next != null) {
            Node next = current.next;
            prev = current.prev;
            current.prev = next;
            current.next = prev;
            current = next;
        }

        prev = current.prev;
        current.prev = null;
        current.next = prev;

        return current;
    }

    public static void main(String[] args) {
    }
}
