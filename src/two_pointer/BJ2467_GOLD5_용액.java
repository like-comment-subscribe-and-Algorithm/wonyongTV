package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2467_GOLD5_용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int r = n - 1;
        int l = 0;
        int temp = Integer.MAX_VALUE;
        int a1 = 0;
        int a2 = 0;
        while (l < r) {
            int num = nums[l] + nums[r];
            if (temp > Math.abs(num)) {
                temp = Math.abs(num);
                a1 = nums[l];
                a2 = nums[r];
            }
            if (num < 0) {
                l += 1;
            } else {
                r -= 1;
            }
        }
        System.out.println(a1 + " " + a2);
    }
}
