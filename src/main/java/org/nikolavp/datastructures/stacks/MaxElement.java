package org.nikolavp.datastructures.stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxElement {

    public static class Counter {
        private final int value;
        private int c = 1;
        public Counter(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        // A list that mimics a stack that can answer the queries...
        List<Counter> stack = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            int query = scanner.nextInt();

            switch (query) {
                case 1: {
                    int argument = scanner.nextInt();
                    if (stack.isEmpty()) {
                        stack.add(new Counter(argument));
                    } else {
                        Counter counter = stack.get(stack.size() - 1);
                        if (counter.value >= argument) {
                            counter.c++;
                        } else {
                            stack.add(new Counter(argument));
                        }
                    }
                }
                break;
                case 2: {
                    Counter counter = stack.get(stack.size() - 1);
                    counter.c--;
                    if (counter.c == 0) {
                        stack.remove(stack.size() - 1);
                    }
                }
                break;
                case 3: {
                    System.out.println(stack.get(stack.size() - 1).value);
                }
            }
        }
    }
}
