package org.nikolavp.algorithm.implementation;

import java.util.*;

public class EqualizeArray {

    public static class Counter {
        private int c = 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        Map<Integer, Counter> frequency = new HashMap<>();
        for (int i = 0; i < N; i++) {
            frequency.computeIfAbsent(scanner.nextInt(), (n) -> new Counter())
                    .c++;
        }

        Counter counter = frequency.values().stream().max(Comparator.comparing((c) -> c.c)).get();
        System.out.println(N - counter.c);
    }
}
