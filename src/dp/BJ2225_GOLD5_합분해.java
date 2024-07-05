package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2225_GOLD5_합분해 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[][] nums = new long[k + 1][n + 1];
        for (int i = 1; i <= k; i++) {
            nums[i][1] = i;
        }
        int DIV = 1_000_000_000;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                nums[j][i] = ((nums[j - 1][i]) % DIV + (nums[j][i - 1]) % DIV) % DIV;
            }
        }
        System.out.println(nums[k][n]);
    }
}
