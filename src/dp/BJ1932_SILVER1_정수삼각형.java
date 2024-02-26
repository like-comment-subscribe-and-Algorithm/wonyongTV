package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1932_SILVER1_정수삼각형 {
    private static int[][] arr;
    private static Integer[][] dp;
    private static int n;

    public static void main(String[] args) throws IOException {
        /*
        * 맨 하단에서 부터 왼쪽, 오른쪽 원소를 비교해서 둘 중 최대 값과 해당 arr 값을 더하면서 점진적으로 올라간다.
        * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new Integer[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = arr[n - 1][i];
        }

        System.out.println(dp(0, 0));
    }

    private static int dp(int dep, int wid) {
        if (dep == n - 1) return dp[dep][wid];

        if (dp[dep][wid] == null) {
            dp[dep][wid] = Math.max(dp(dep + 1, wid), dp(dep + 1, wid + 1)) + arr[dep][wid];
        }
        return dp[dep][wid];
    }
}
