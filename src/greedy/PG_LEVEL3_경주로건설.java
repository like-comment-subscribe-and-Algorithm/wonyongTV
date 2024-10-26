package greedy;
import java.util.*;

public class PG_LEVEL3_경주로건설 {

    class Solution {
        int[][] moves = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        public int solution(int[][] board) {
            int size = board.length;
            PriorityQueue<Site> que = new PriorityQueue<>((s1,s2) -> s1.w - s2.w);

            boolean[][][] visited = new boolean[size][size][2];
            int[][][] weight = new int[size][size][2];
            for(int r = 0 ; r < size; r++) {
                for(int c = 0 ; c < size; c++) {
                    for(int d = 0 ; d < 2; d++) {
                        weight[r][c][d] = Integer.MAX_VALUE;
                    }
                }
            }

            que.add(new Site(0,0,0,0));
            que.add(new Site(0,0,0,1));
            weight[0][0][0] = 0;
            weight[0][0][1] = 0;
            while(!que.isEmpty()) {
                Site site = que.poll();
                if(visited[site.r][site.c][site.d]) continue;
                visited[site.r][site.c][site.d] = true;
                for(int i = 0; i<4; i++) {
                    int nr = site.r + moves[i][0];
                    int nc = site.c + moves[i][1];
                    int nd = i%2;
                    if(nr < 0 || nr >= size || nc < 0 || nc >= size || board[nr][nc] == 1 || visited[nr][nc][nd]) {
                        continue;
                    }

                    int nw = site.w + 100;
                    if(site.d != nd) nw += 500;

                    if(nw > weight[nr][nc][nd]) continue;

                    weight[nr][nc][nd] = nw;
                    que.add(new Site(nr,nc,nw,nd));
                }
            }


            return Math.min(weight[size-1][size-1][0],weight[size-1][size-1][1]);
        }

        private void printW(int[][][] weight) {
            int size = weight.length;
            for(int r = 0 ; r < size; r++) {
                for(int c = 0 ; c < size; c++) {
                    System.out.print("( " + weight[r][c][0] + " , " + weight[r][c][1] + " )");
                }
                System.out.println();
            }
        }
    }

    static class Site {
        int r;
        int c;
        int w;
        int d;

        Site(int r, int c, int w, int d) {
            this.r = r;
            this.c = c;
            this.w = w;
            this.d = d;
        }
    }

}
