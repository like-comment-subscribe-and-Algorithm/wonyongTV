package dp;

public class PG_LEVEL3_등굣길 {
    class Solution {
        public int solution(int m, int n, int[][] puddles) {
            int[][] maps = new int[n+1][m+1];
            int DIV = 1_000_000_007;

            for(int[] puddle: puddles) {
                maps[puddle[1]][puddle[0]] = -1;
            }

            maps[1][1] = 1;

            for(int r = 1; r <= n ; r++) {
                for(int c = 1; c <= m ; c++) {
                    if(r == 1 && c== 1) continue;
                    if(maps[r][c] == -1) continue;
                    if(maps[r-1][c] == -1 && maps[r][c-1] == -1) continue;

                    if(maps[r-1][c] == -1) maps[r][c] = maps[r][c-1];
                    else if(maps[r][c-1] == -1) maps[r][c] = maps[r-1][c];
                    else maps[r][c] = (maps[r-1][c]%DIV + maps[r][c-1]%DIV)%DIV;
                }
            }

            return maps[n][m];
        }
    }
}
