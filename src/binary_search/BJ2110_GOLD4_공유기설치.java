package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2110_GOLD4_공유기설치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums);

        int start = 1;
        int end = nums[n - 1] - nums[0];

        int answer = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int temp = 1;
            int before = nums[0];
            for (int num : nums) {
                if (num - before < mid) {
                    continue;
                }
                temp++;
                before = num;
            }
            if (temp >= c) {
                answer = Math.max(answer, mid);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
