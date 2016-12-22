package org.nikolavp.datastructures.algorithm.implementation;

import java.util.Scanner;

public class SockMerchant {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[101];
        for (int i = 0; i < n; i++) {
            int socketColor = in.nextInt();
            c[socketColor]++;
        }

        int sockPairs = 0;
        for (int i = 0; i < c.length; i++) {
            sockPairs += c[i] / 2;
        }

        System.out.println(sockPairs);
    }
}
