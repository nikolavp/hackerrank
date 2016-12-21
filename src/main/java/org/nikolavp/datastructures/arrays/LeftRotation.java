package org.nikolavp.datastructures.arrays;

import java.util.Scanner;

public class LeftRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int rotations = scanner.nextInt();

        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            builder.append(array[(i + rotations) % N]).append(' ');
        }
        System.out.println(builder.toString().trim());
    }
}
