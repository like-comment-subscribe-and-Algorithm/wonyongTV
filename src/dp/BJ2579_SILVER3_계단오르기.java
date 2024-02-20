package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2579_SILVER3_계단오르기 {
    /*
    * 0부터 N 까지 순회를 하며 인덱스가 i 일 때
    * 1. 2칸 아래서 바로 온 경우
    * 2. 1칸에서 바로 온 경우
    * 2가지 경우를 고려한다.
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) System.out.println(nums[1]);
        else if (n == 2) System.out.println(nums[1] + nums[2]);
        else {
            int[] dp = new int[n + 1];
            dp[1] = nums[1];
            dp[2] = nums[1] + nums[2];
            for (int i = 3; i <= n; i++) {
                int temp = Math.max(dp[i - 2], dp[i - 3] + nums[i - 1]);
                dp[i] = temp + nums[i];
            }
            System.out.println(dp[n]);
        }
    }
}
