package greedy;

import java.util.Arrays;

public class PG_LEVEL2_가장큰수 {

    class Solution {
        public String solution(int[] numbers) {
            String[] strings = new String[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                strings[i] = "" + numbers[i];
            }
            Arrays.sort(strings, (s1, s2) -> {
                return (s2 + s1).compareTo((s1 + s2));
            });

            if (strings[0].equals("0")) return "0";

            String answer = "";
            for (String s : strings) {
                answer += s;
            }

            return answer;
        }
    }
}
