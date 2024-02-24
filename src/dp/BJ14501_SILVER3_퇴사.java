package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14501_SILVER3_퇴사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] ts = new int[n + 1];
        int[] ps = new int[n + 1];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            ts[i] = t;
            ps[i] = p;
        }

        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (i + ts[i] <= n) {
                dp[i + ts[i]] = Math.max(dp[i + ts[i]], ps[i] + dp[i]);
            }
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }
        System.out.println(dp[n]);
    }
}
