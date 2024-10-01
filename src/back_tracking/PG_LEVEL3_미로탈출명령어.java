package back_tracking;

public class PG_LEVEL3_미로탈출명령어 {
    // 4시 22분 시작
    // 5시 08분 11점
    // 5시 33분 결국 못 풀고, 블로그 참고해서 해결
    class Solution {
        int[][] moves = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
        String[] strs = {"d","l","r","u"};
        int n,m,r,c,k;
        boolean isAns = false;
        String answer = "";
        public String solution(int n, int m, int x, int y, int r, int c, int k) {
            this.n = n;
            this.m = m;
            this.r = r;
            this.c = c;
            this.k = k;

            dfs(x,y,"",0);
            if(answer.isEmpty()) return "impossible";
            return answer;
        }

        void dfs(int row, int col, String str, int cnt) {
            if(isAns) return;

            int dist = Math.abs(r-row) + Math.abs(c-col);

            // 최단 루트를 벗어났을 때
            if(k - cnt - dist < 0) return;
            // 최단 루트를 벗어난 후, 다시 도착지점까지 왔다 갔다 하기 위해 짝수 번의 기회가 필요하다.
            if((k - cnt - dist) % 2 == 1) return;

            if(cnt == k) {
                if(col == c && row == r) {
                    answer = str;
                    isAns = true;
                }
                return;
            }

            for(int i = 0 ; i < 4 ; i++) {
                int nr = row + moves[i][0];
                int nc = col + moves[i][1];
                if(nr > n || nr < 1 || nc > m || nc < 1) continue;

                dfs(nr, nc, str + strs[i], cnt+1);
            }
        }
    }
}
