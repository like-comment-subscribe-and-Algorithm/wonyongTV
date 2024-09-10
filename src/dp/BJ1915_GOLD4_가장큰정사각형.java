package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1915_GOLD4_가장큰정사각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] nums = new int[n][m];
        for (int r = 0; r < n; r++) {
            String str = br.readLine();
            for (int c = 0; c < m; c++) {
                nums[r][c] = str.charAt(c) - 48;
            }
        }

        /*
        * 0 1 1 1
        * 0 1 1 1
        * 1 1 1 1
        * 1 1 0 0
        *
        * 0 1 1 1
        * 0 1 2 2
        * 1 1 2 3
        * 1 2 0 0
        * */
        int answer = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (r - 1 >= 0 && c - 1 >= 0 && nums[r][c] == 1) {
                    int temp = Math.min(nums[r - 1][c], nums[r][c - 1]);
                    temp = Math.min(nums[r - 1][c - 1], temp);
                    nums[r][c] += temp;
                }
                answer = Math.max(answer, nums[r][c]);
            }
        }

        System.out.println(answer * answer);
    }
}
