package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1965_SILVER2_상자넣기_LIS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n + 1];
        int[] lens = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            lens[i] = 1;
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (nums[i] > nums[j]) lens[i] = Math.max(lens[j] + 1, lens[i]);
            }
            answer = Math.max(answer, lens[i]);
        }

        System.out.println(answer);
    }
}
