package stack_que;

import java.util.*;

public class PG_LEVEL2_주식가격 {

    class Solution {
        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < prices.length; i++) {
                while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                    int idx = stack.pop();
                    answer[idx] = i - idx;
                }
                stack.add(i);
            }

            int len = prices.length;
            while (!stack.isEmpty()) {
                int idx = stack.pop();
                answer[idx] = len - idx - 1;
            }
            return answer;
        }
    }

}
