package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ17069_GOLD4_파이프옮기기2 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] maps = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][][] dp = new long[n + 1][n + 1][3];

        dp[1][2][0] = 1;
        for (int r = 1; r <= n; r++) {
            for (int c = 3; c <= n; c++) {
                if (maps[r][c] == 1) {
                    continue;
                }

                dp[r][c][0] = dp[r][c - 1][0] + dp[r][c - 1][2];
                if (r == 1) {
                    continue;
                }

                dp[r][c][1] = dp[r - 1][c][1] + dp[r - 1][c][2];

                if (maps[r - 1][c] == 1 || maps[r][c - 1] == 1) {
                    continue;
                }
                dp[r][c][2] = dp[r - 1][c - 1][0] + dp[r - 1][c - 1][1] + dp[r - 1][c - 1][2];
            }
        }
        long a = dp[n][n][0] + dp[n][n][1] + dp[n][n][2];
        System.out.println(a);
    }
}
