package stack_que;
import java.util.*;

public class LC739_Medium_DailyTemperatures {
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            Stack<Tmp> stack = new Stack<>();
            int[] answer = new int[temperatures.length];
            for(int i = 0 ; i < temperatures.length ; i++) {
                int t = temperatures[i];

                while(!stack.isEmpty() && stack.peek().temp < t) {
                    Tmp tmp = stack.pop();
                    answer[tmp.index] = i - tmp.index;
                }

                stack.add(new Tmp(t, i));
            }

            return answer;
        }
    }

    class Tmp {
        int temp;
        int index;

        public Tmp(int temp, int index) {
            this.temp = temp;
            this.index = index;
        }
    }
}
