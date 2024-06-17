package stack_que;

import java.util.*;

public class LC316_Mediumn_RemoveDuplicateLetters {
    class Solution {
        public String removeDuplicateLetters(String s) {
            Set<Character> seen = new HashSet<>();
            int[] counts = new int[26];
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                counts[s.charAt(i) - 97]++;
            }

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                counts[c - 97] -= 1;
                if (seen.contains(c)) {
                    continue;
                }

                while (!stack.isEmpty() && c < stack.peek() && counts[stack.peek() - 97] > 0) {
                    seen.remove(stack.pop());
                }

                seen.add(c);
                stack.add(c);
            }

            StringBuilder sb = new StringBuilder();
            for (char c : stack) {
                sb.append(c);
            }
            return sb.toString();
        }
    }
}
