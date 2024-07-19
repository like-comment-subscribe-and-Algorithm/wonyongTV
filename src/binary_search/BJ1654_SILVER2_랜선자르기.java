package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1654_SILVER2_랜선자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long[] nums = new long[k];
        for (int i = 0; i < k; i++) {
            nums[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(nums);
        long start = 1;
        long end = nums[k-1];
        while (start <= end) {
            long mid = (start + end) / 2;
            long temp = 0;
            for (long num : nums) {
                temp += (num / mid);
            }
            if (temp < n) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        System.out.println(end);
    }
}
