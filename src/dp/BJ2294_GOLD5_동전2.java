package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2294_GOLD5_동전2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int MAX_VALUE = 100_001;
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] nums = new int[k + 1];
        int[] coin = new int[n];


        for (int i = 0; i < n; i++) {
            int c = Integer.parseInt(br.readLine());
            coin[i] = c;
        }
        Arrays.sort(coin);

        for (int i = 1; i <= k; i++) {
            nums[i] = MAX_VALUE;
        }
        for (int i = 1; i <= k; i++) {
            for (int c : coin) {
                if (c > i) {
                    break;
                }
                if (nums[i - c] == MAX_VALUE) {
                    continue;
                }
                nums[i] = Math.min(nums[i], nums[i - c] + 1);
            }
        }

        if (nums[k] == MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(nums[k]);
        }
    }
}
