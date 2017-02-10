package org.nikolavp.rookierank;

import java.util.ArrayDeque;
import java.util.Scanner;

public class KnightLOnAChessboard {

    private final int[][] board;
    private final int a;
    private final int b;


    class Tuple {
        int distance;
        int x;
        int y;

        @Override
        public String toString() {
            return "Tuple{" +
                    "distance=" + distance +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    private KnightLOnAChessboard(int n, int a, int b) {
        board = new int[n][n];
        this.a = a;
        this.b = b;
    }

    public int getMovesToEnd() {
        ArrayDeque<Tuple> entries = new ArrayDeque<>();
        Tuple e = new Tuple();
        e.x = 0;
        e.y = 0;
        e.distance = 0;
        entries.add(e);
        while (!entries.isEmpty()) {
            Tuple next = entries.poll();
            board[next.x][next.y] = next.distance;
            if (next.x == board.length - 1 && next.y == board.length - 1) {
                return next.distance;
            }
            for (int aMove : new int[] {a, -a}) {
                for (int bMove : new int[] {b, -b}) {
                    int newX = next.x + aMove;
                    int newY = next.y + bMove;
                    if (insideAndNotVisited(newX, newY)) {
                        Tuple tuple = new Tuple();
                        tuple.distance = next.distance + 1;
                        board[newX][newY] = tuple.distance;
                        tuple.x = newX;
                        tuple.y = newY;
                        entries.add(tuple);
                    }

                    newX = next.x + bMove;
                    newY = next.y + aMove;
                    if (insideAndNotVisited(newX, newY)) {
                        Tuple tuple = new Tuple();
                        tuple.distance = next.distance + 1;
                        board[newX][newY] = tuple.distance;
                        tuple.x = next.x + bMove;
                        tuple.y = next.y + aMove;
                        entries.add(tuple);
                    }
                }
            }
        }
        return -1;
    }

    private boolean insideAndNotVisited(int x, int y) {
        if (y < 0 || x < 0 || x >= board.length || y >= board.length) {
            return false;
        }
        return board[x][y] == 0;
    }


    public static void main(String[] args) {

//        System.out.println(new KnightLOnAChessboard(5, 1, 1).getMovesToEnd());
        int n = new Scanner(System.in).nextInt();

        int[][] result = new int[n][n];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (i <= j) {
                    result[i][j] = new KnightLOnAChessboard(n, i, j).getMovesToEnd();
                    System.out.print(result[i][j]);
                } else {
                    System.out.print(result[j][i]);
                }
                if (j != n -1) {
                    System.out.print(' ');
                }
            }
            System.out.println();
        }
    }
}