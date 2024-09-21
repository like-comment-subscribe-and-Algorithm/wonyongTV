package brute_force;

import java.util.*;

public class PG_LEVEL2_수치최대화 {

    class Solution {
        public long solution(String expression) {
            List<String> exp = new ArrayList<>();
            int start = 0;
            int mid = 1;
            int end = expression.length();
            while (mid < end) {
                char c = expression.charAt(mid);
                if (c == '+' || c == '-' || c == '*') {
                    exp.add(expression.substring(start, mid));
                    exp.add(c + "");
                    start = mid + 1;
                    mid += 1;
                }
                mid++;
            }
            exp.add(expression.substring(start, mid));

            String[][] comb = {
                    {"+", "-", "*"},
                    {"+", "*", "-"},
                    {"-", "*", "+"},
                    {"-", "+", "*"},
                    {"*", "+", "-"},
                    {"*", "-", "+"}
            };
            long answer = 0;
            for (String[] com : comb) {
                Deque<String> arr = new ArrayDeque<>(exp);

                for (String c : com) {
                    Stack<String> stack = new Stack<>();
                    while (!arr.isEmpty()) {
                        String str = arr.pollFirst();
                        if (str.equals(c)) {
                            long n1 = Long.parseLong(stack.pop());
                            long n2 = Long.parseLong(arr.pollFirst());
                            long num = cal(n1, n2, c);
                            stack.add(num + "");
                        } else {
                            stack.add(str);
                        }
                    }

                    arr.addAll(stack);
                    if (stack.size() == 1) {
                        answer = Math.max(answer, Math.abs(Long.parseLong(stack.pop())));
                    }
                }
            }

            return answer;
        }

        public long cal(long n1, long n2, String o) {
            if (o.equals("+")) {
                return n1 + n2;
            }
            if (o.equals("-")) {
                return n1 - n2;
            }
            return n1 * n2;
        }

    }
}
