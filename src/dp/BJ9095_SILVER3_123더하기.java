package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9095_SILVER3_123더하기 {
    /*
     * 1 : 1 [1]
     * 2 : 2 [1+1, 2]
     * 3 : 4 [1+1+1, 1+2, 2+1, 3]
     * 4 : 7 [1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2, 3+1, 1+3]
     * 5 : 13 [1+1+1+1+1, 1+1+1+2, 1+1+2+1, 1+2+1+1, 2+1+1+1, 1+2+2, 2+1+2, 2+2+1, 1+1+3, 1+3+1, 3+1+1, 3+2, 2+3]
     * 6 : 24
     * 7 : 44
     *
     * [i] == [i-3] + [i-2] + [i-1] 규칙 존재
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] nums = new int[12];
        nums[1] = 1;
        nums[2] = 2;
        nums[3] = 4;
        for (int i = 4; i < 12; i++) {
            nums[i] = nums[i - 3] + nums[i - 2] + nums[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(nums[n]).append("\n");
        }
        System.out.println(sb);
    }
}
