package org.nikolavp.datastructures.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SparseArrays {

    private static class Counter {
        private int n = 0;
    }

    public static void main(String[] args) {
        Map<String, Counter> frequencyTable = new HashMap<String, Counter>() {
            @Override
            public Counter get(Object key) {
                Counter result = super.get(key);
                if (result == null) {
                    result = new Counter();
                    put((String) key, result);
                }
                return result;
            }
        };

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            String string = scanner.next();
            frequencyTable.get(string).n++;
        }

        int Q = scanner.nextInt();
        for (int i = 0; i < Q; i++) {
            String string = scanner.next();
            System.out.println(frequencyTable.get(string).n);
        }
    }
}
