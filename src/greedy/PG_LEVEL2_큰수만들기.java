package greedy;

import java.util.Stack;

public class PG_LEVEL2_큰수만들기 {

    class Solution {
        public String solution(String number, int k) {
            String[] nums = number.split("");
            Stack<String> stack = new Stack<>();
            int keep = nums.length - k;

            for (int i = 0; i < nums.length; i++) {
                while (!stack.isEmpty() && k > 0 && Integer.parseInt(stack.peek()) < Integer.parseInt(nums[i])) {
                    stack.pop();
                    k--;
                }
                stack.add(nums[i]);
            }

            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }

            return sb.reverse().substring(0, keep);
        }
    }
}
