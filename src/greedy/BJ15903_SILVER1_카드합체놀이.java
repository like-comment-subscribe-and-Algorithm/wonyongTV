package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ15903_SILVER1_카드합체놀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] nums = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < m; i++) {
            Arrays.sort(nums);
            long temp = nums[0] + nums[1];
            nums[0] = temp;
            nums[1] = temp;
        }
        long answer = 0;
        for (long num : nums) {
            answer += num;
        }

        System.out.println(answer);
    }
}
