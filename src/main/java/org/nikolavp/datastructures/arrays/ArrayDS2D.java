package org.nikolavp.datastructures.arrays;

import java.util.Scanner;

public class ArrayDS2D {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        short[][] matrix = new short[6][6];

        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 5; j++) {
                matrix[i][j] = scan.nextShort();
            }
        }

        int maxSum = Integer.MIN_VALUE;

        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                int sum = hourGlass(i, j, matrix);
                maxSum = Math.max(sum, maxSum);
            }
        }
        System.out.println(maxSum);
    }

    private static int hourGlass(int i, int j, short[][] matrix) {
        return matrix[i -1][j - 1] + matrix[i - 1][j] + matrix[i -1][j + 1] +
                                     matrix[i][j] +
               matrix[i + 1][j - 1] + matrix[i + 1][j] + matrix[i + 1][j + 1];
    }
}
