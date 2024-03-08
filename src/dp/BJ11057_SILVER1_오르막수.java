package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ11057_SILVER1_오르막수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] nums = new int[n + 1][10];
        nums[0] = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                int temp = 0;
                for (int k = 0; k <= j; k++) {
                    temp += nums[i - 1][k];
                }
                nums[i][j] = temp%10007;
            }
        }
        System.out.println(nums[n][9]);
    }
}
