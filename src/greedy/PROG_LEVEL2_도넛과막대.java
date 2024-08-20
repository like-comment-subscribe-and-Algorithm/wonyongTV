package greedy;

import java.util.HashMap;
import java.util.Map;

public class PROG_LEVEL2_도넛과막대 {
    /*
    *               IN 간선  OUT 간선
    * 생성한 정점       0        >1
    * 도넛            >=1       1   (정점으로 부터 가는 길 + 다시 순회하며 들어온 간선) 때문에 IN 간선이 >= 1 이다.
    * 막대            >=1       0
    * 8자             >=2       2
    *
    * 정점을 제외하고 모든 도형은 도넛, 막대 8자 중 하나이기 때문에
    * 정점에서 나가는 간선 개수 와 총 도넛, 막대, 8자의 수는 같다.
    * 따라서 8자의 개수와 막대의 개수를 구하고
    * 도넛의 개수를 [ 정점에서 나가는 간선 개수 - (8자의 개수 + 막대의 개수) ]를 통해서 구한다.
    * 
     * */
    class Solution {
        public int[] solution(int[][] edges) {
            Map<Integer, Integer> in = new HashMap<>();
            Map<Integer, Integer> out = new HashMap<>();

            for (int[] edge : edges) {
                in.put(edge[1], in.getOrDefault(edge[1], 0) + 1);
                out.put(edge[0], out.getOrDefault(edge[0], 0) + 1);
            }

            int[] answer = new int[4];
            for (int o : out.keySet()) {
                if (out.get(o) > 1) {
                    if (!in.containsKey(o)) {
                        answer[0] = o;
                    } else {
                        answer[3] += 1;
                    }
                }
            }

            for (int i : in.keySet()) {
                if (!out.containsKey(i)) {
                    answer[2] += 1;
                }
            }

            answer[1] = out.get(answer[0]) - answer[2] - answer[3];
            return answer;
        }
    }
}
