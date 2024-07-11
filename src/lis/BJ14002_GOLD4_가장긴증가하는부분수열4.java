package lis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14002_GOLD4_가장긴증가하는부분수열4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = "" + nums[i];
        }
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        str[i] = str[j] + " " + nums[i];
                    }
                }
            }
        }
        int maxIdx = -1;
        int max = -1;
        for (int j = 0; j < n; j++) {
            if (max < dp[j]) {
                max = dp[j];
                maxIdx = j;
            }
        }
        System.out.println(max + "\n" + str[maxIdx]);
    }
}
