package org.nikolavp.rookierank;

import java.util.*;
import java.util.stream.Collectors;

public class MigratoryBirds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nextInt = scanner.nextInt();


        Map<Integer, List<Integer>> grouped = Arrays.stream(new int[nextInt])
                .map((content_) -> scanner.nextInt())
                .boxed()
                .collect(Collectors.groupingBy((value) -> value));

        int max = -1;
        int value = -1;
        Set<Map.Entry<Integer, List<Integer>>> entries = grouped.entrySet();
        for (Map.Entry<Integer, List<Integer>> entry : entries) {
            if (entry.getValue().size() == max) {
                value = Math.min(entry.getKey(), value);
            } else if (entry.getValue().size() > max) {
                value = entry.getKey();
                max = entry.getValue().size();
            }
        }
        System.out.println(value);
    }
}
