package org.nikolavp.datastructures.arrays;

import java.util.Scanner;

public class ArraysDS {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String[] ints = new String[N];

        for (int i = ints.length - 1; i >= 0; i--) {
            ints[i] = String.valueOf(scanner.nextInt());
        }
        System.out.println(String.join(" ", ints));
    }
}
