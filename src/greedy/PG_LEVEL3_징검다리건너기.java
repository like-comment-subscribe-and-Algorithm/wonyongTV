package greedy;

import java.util.PriorityQueue;

public class PG_LEVEL3_징검다리건너기 {
    class Solution {
        public int solution(int[] stones, int k) {
            PriorityQueue<Stone> s = new PriorityQueue<>((s1, s2) -> s2.w - s1.w);
            for(int i = 0 ; i < k ; i++) {
                s.add(new Stone(i, stones[i]));
            }

            int answer = s.peek().w;
            for(int i = k; i < stones.length ; i++) {
                while(!s.isEmpty() && i - s.peek().idx >= k) s.poll();
                s.add(new Stone(i, stones[i]));
                answer = Math.min(answer, s.peek().w);
            }
            return answer;
        }
    }

    class Stone {
        int idx;
        int w;

        Stone(int idx, int w) {
            this.idx = idx;
            this.w = w;
        }
    }
}
