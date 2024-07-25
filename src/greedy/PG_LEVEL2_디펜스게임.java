package greedy;

import java.util.Collections;
import java.util.PriorityQueue;

public class PG_LEVEL2_디펜스게임 {
    public int solution(int n, int k, int[] enemy) {
        if (k >= enemy.length) {
            return enemy.length;
        }

        // 사용한 병사 수를 나타내는 pq
        PriorityQueue<Integer> d = new PriorityQueue<Integer>(Collections.reverseOrder());
        // 무적권을 사용한 병사 수를 나타내는 pq
        PriorityQueue<Integer> m = new PriorityQueue<Integer>();
        int answer = 0;
        for (int e : enemy) {
            // System.out.println("남은 병사 "+n+" 현재 적 : "+e+  " 사용 병사 : " + d + " 무적권 : " + m);

            // 남은 병사 수 > 현재 적 일 때, 병사 수를 사용한다.
            if (n >= e) {
                n -= e;
                answer++;
                d.add(e);
                continue;
            }
            if (k > 0) {
                // 무적권을 사용한다.
                m.add(e);
                k -= 1;
                answer++;
                // 병사를 사용한 수 중 가장 큰 값과 무적권을 사용한 가장 작은 값을 비교해서
                // 이전에 사용한 병사 수가 현재 사용한 무적권 보다 클 경우
                // 무적권 사용을 변경한다.
                while (!m.isEmpty() && !d.isEmpty() && m.peek() < d.peek()) {
                    int mj = m.poll();
                    int damage = d.poll();
                    m.add(damage);
                    d.add(mj);
                    n = n + damage - mj;
                }
                continue;
            }
            break;
        }
        return answer;
    }
}
