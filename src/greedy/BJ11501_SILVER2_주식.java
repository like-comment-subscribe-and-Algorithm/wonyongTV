package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11501_SILVER2_주식 {
    /*
     * 시간 제한 : 5초 = 5*10^8
     * n = 10^6
     * 시간 복잡도 nLog(n) 이내로 풀이
     *
     * 1. 마지막 값을 max 값으로 저장한다.
     * 2. n-1 부터 0까지 순회한다.
     *  2-1 현재 값이 max 값보다 크다면 max 값을 변경한다.
     *  2-2 작다면 (max - 현재 값) 값을 더한다.
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = Integer.parseInt(st.nextToken());
            }

            long answer = 0;
            int max = nums[n - 1];
            for (int m = n - 1; m > -1; m--) {
                if (nums[m] > max) max = nums[m];
                else answer += (max - nums[m]);
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
