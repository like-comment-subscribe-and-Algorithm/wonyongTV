package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ2012_SILVER3_등수메기기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);

        long answer = 0;
        for (int i = 1; i <= n; i++) {
            answer += Math.abs(i - nums[i]);
        }
        System.out.println(answer);
    }
}
