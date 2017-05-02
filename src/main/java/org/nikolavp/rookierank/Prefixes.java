package org.nikolavp.rookierank;

import java.util.*;

public class Prefixes {

    private static long cost;
    private static List<String> finalSet;// = new ArrayList<>();

    public static class IsNeighbour {
        private boolean bool;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = scanner.nextInt();
        List[] buckets = new List[11];
        Map<String, IsNeighbour> strings = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String str = scanner.next();
            int idx = str.length() - 1;
            if (buckets[idx] == null) {
                buckets[idx] = new LinkedList();
            }
            buckets[idx].add(str);
            strings.put(str, new IsNeighbour());
        }

        for (int i = buckets.length - 1; i >= 0; i--) {
            List<String> bucket = buckets[i];
            if (bucket == null) {
                continue;
            }
            for (String str : bucket) {
                IsNeighbour isNeighbour = strings.get(str);
                if (isNeighbour.bool) {
                    continue;
                }

                boolean notFound = true;
                int length = str.length();
                for (int j = length - 1; j > 0; j--) {
                    String substring = str.substring(0, j);
                    IsNeighbour neighbour = strings.get(substring);
                    if (neighbour != null) {
                        neighbour.bool = true;
                        notFound = false;
                        addCost(str);
                        break;
                    }
                }
                if (notFound) {
                    addCost(str);
                }
            }
        }

        System.out.println(cost);
//        System.out.println(finalSet);
    }


    private static void addCost(String word) {
        for (int i = 0; i < word.length(); i++) {
            cost += word.charAt(i);
        }
        if (finalSet != null) {
            finalSet.add(word);
        }
    }
    // 4 A AB ABCD ABCE
}
