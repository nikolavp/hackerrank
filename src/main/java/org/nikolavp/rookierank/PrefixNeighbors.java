package org.nikolavp.rookierank;

import java.util.*;

public class PrefixNeighbors {


    private static List<String> finalSet = new ArrayList<>();
    private static int cost = 0;

    enum State {
        TRUE,
        FALSE,
        STOP;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = scanner.nextInt();
        List[] buckets = new List[11];

        outer:
        for (int i = 0; i < n; i++) {
            String str = scanner.next();
            int idx = str.length() - 1;
            if (buckets[idx] == null) {
                buckets[idx] = new LinkedList();
            }
            ListIterator<String> iterator = buckets[idx].listIterator();
            while (iterator.hasNext()) {
                if (iterator.next().compareTo(str) >= 0) {
                    iterator.previous();
                    iterator.add(str);
                    iterator.next();
                    continue outer;
                }
            }
            buckets[idx].add(str);
        }

//        List<String> finalSet = new ArrayList<>();
        for (int i = buckets.length - 1; i > 0; i--) {
            List bucket = buckets[i];
            if (bucket == null) {
                continue;
            }
            Iterator iterator = bucket.iterator();

            while (iterator.hasNext()) {

                String str = (String) iterator.next();
                boolean found = false;
                neighbour:
                for (int j = i - 1; j >= 0; j--) {
                    List otherBucket = buckets[j];
                    if (otherBucket == null) {
                        continue;
                    }
                    Iterator<String> otherIterator = otherBucket.iterator();
                    while (otherIterator.hasNext()) {
                        String otherStr = otherIterator.next();
                        State prefix = isPrefix(otherStr, str);
                        switch (prefix) {
                            case STOP:
                                continue neighbour;
                            case FALSE:
                                break;
                            case TRUE:
                                otherIterator.remove();
                                iterator.remove();
                                addCost(str);
                                found = true;
                                break neighbour;
                        }
                    }
                }
                if (!found) {
                    iterator.remove();
                    addCost(str);
                }
            }
        }
        if (buckets[0] != null) {
            for (Object str : buckets[0]) {
                addCost((String) str);
            }
        }
        System.out.println(cost);
        if (finalSet != null) {
            System.out.println(finalSet);
        }
    }

    private static State isPrefix(String prefix, String string) {
        for (int i = 0; i < prefix.length(); i++) {
            if (prefix.charAt(i) > string.charAt(i)) {
                return State.STOP;
            } else if (prefix.charAt(i) < string.charAt(i)) {
                return State.FALSE;
            }
        }
        return State.TRUE;
    }

    private static void addCost(String word) {
        for (int i = 0; i < word.length(); i++) {
            cost += word.charAt(i);
        }
        if (finalSet != null) {
            finalSet.add(word);
        }
    }

    // 7 A ABE ABA AC ACD AB ABC

    // 6 A ABE AC ACD AB ABC
}
