package lis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2565_GOLD5_전깃줄 {
    /*
가장 많이 꼬인 선부터 제거하는 방식으로 푸는 분들은 전부 다 이 반례에서 막히실 겁니다.
5
1 3
3 1
2 5
4 6
6 4

답: 2
(3 1), (6 4)를 잘라야 합니다.

(전체 전선 개수 - 설치 가능 개수) = 철거 개수
따라서 최대로 설치 가능한 개수를 구한다.
    * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            nums[i] = new int[]{a, b};
        }

        Arrays.sort(nums, (n1, n2) -> n1[0] - n2[0]);
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i][1] > nums[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = -1;
        for (int num : dp) {
            max = Math.max(max, num);
        }
        System.out.println(n - max);
    }
}
