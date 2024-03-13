package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11055_SILVER2_가장큰증가하는부분수열 {
    /*
     * LIS 활용
     *
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n + 1];
        dp[1] = nums[1];
        for (int i = 2; i <= n; i++) {
            dp[i] = nums[i];
            for (int j = 1; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(nums[i] + dp[j], dp[i]);
                }
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (dp[i] > answer) answer = dp[i];
        }
        System.out.println(answer);
    }
}
