package org.nikolavp.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DynamicArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int Q = scanner.nextInt();
        int lastAns = 0;

        List[] seqList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            seqList[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < Q; i++) {
            int q = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            List<Integer> seq = findSeq(seqList, x, lastAns);
            switch (q) {
                case 1:
                    seq.add(y);
                    break;
                case 2:
                    lastAns = seq.get(y % seq.size());
                    System.out.println(lastAns);
                    break;
                default:
                    throw new IllegalStateException("Invalid query type " + q);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static List<Integer> findSeq(List[] seqList, int x, int lastAns) {
        return seqList[(x ^ lastAns) % seqList.length];
    }
}
