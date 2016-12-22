package org.nikolavp.datastructures.stacks;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            String s = in.next();
            if (isBalanced(s)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isBalanced(String s) {
        Deque<Character> brackets = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                brackets.push(c);
            } else {
                // start popping until we find our pair
                boolean foundMatching = false;
                if (c == ')') {
                    foundMatching = isMatching(brackets, '(');
                } else if (c == ']') {
                    foundMatching = isMatching(brackets, '[');
                } else if (c == '}') {
                    foundMatching = isMatching(brackets, '{');
                }
                if (!foundMatching) {
                    return false;
                }
            }
        }
        return brackets.size() == 0;
    }

    private static boolean isMatching(Deque<Character> brackets, char c) {
        Character character =  brackets.pollFirst();
        return character != null && character == c;
    }
}
