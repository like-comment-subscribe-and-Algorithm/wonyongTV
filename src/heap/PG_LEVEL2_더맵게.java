package heap;

import java.util.*;

public class PG_LEVEL2_더맵게 {

    class Solution {
        public int solution(int[] scoville, int K) {
            PriorityQueue<Integer> que = new PriorityQueue<>();
            for (int s : scoville) {
                que.add(s);
            }

            int answer = 0;
            while (que.peek() < K && que.size() > 1) {
                answer++;
                int f = que.poll();
                int s = que.poll();
                que.add(f + s * 2);
            }

            if (que.size() == 1 && que.poll() < K) return -1;
            return answer;
        }
    }
}
