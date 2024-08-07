package brute_force;

public class PG_LEVEL2_혼자놀기의달인 {
    class Solution {
        public int solution(int[] cards) {
            int answer = 0;

            for(int i = 0 ; i< cards.length ; i++) {
                // 첫번째 값(C1) 구하기
                boolean[] visited = new boolean[cards.length];
                int c1 = 1;
                visited[i] = true;
                int next = cards[i]-1;
                while(!visited[next]) {
                    c1++;
                    visited[next] = true;
                    next = cards[next]-1;
                }

                // 두번째 값(C2) 구하기
                for(int j = 0 ; j< cards.length ; j++) {
                    if(visited[j]) continue;

                    boolean[] temp = copy(visited);

                    int c2 = 1;
                    int next2 = cards[j] - 1;
                    temp[j] = true;
                    while(!temp[next2]) {
                        c2++;
                        temp[next2] = true;
                        next2 = cards[next2]-1;
                    }

                    answer = Math.max(answer, c1 * c2);
                }
            }

            return answer;
        }

        public boolean[] copy(boolean[] visited) {
            boolean[] temp = new boolean[visited.length];
            for(int i = 0 ; i < visited.length ; i++) {
                temp[i] = visited[i];
            }
            return temp;
        }
    }
}
