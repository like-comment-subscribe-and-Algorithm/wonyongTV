package greedy;

import java.util.*;

public class PG_LEVEL2_요격시스템 {
    class Solution {
        public int solution(int[][] targets) {
            Arrays.sort(targets, (t1,t2) -> t1[1]-t2[1]);
            int answer = 1;
            int end = targets[0][1];
            for(int i = 1 ; i < targets.length ; i++) {
                if(end > targets[i][0]) continue;
                answer++;
                end = targets[i][1];
            }
            return answer;
        }
    }
}
