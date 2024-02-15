package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1463_SILVER3_1로만들기 {
    /*
     * 시간 제한 : 0.15
     * n : 10^6
     * 1부터 N까지를 순회할 때 i에 최소 값을 저장하며 순회를 진행한다.
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 1) System.out.println(0);
        else if (n == 2 || n == 3) System.out.println(1);
        else {
            int[] nums = new int[n + 1];
            nums[2] = 1;
            nums[3] = 1;

            for (int i = 4; i <= n; i++) {
                int min = Integer.MAX_VALUE;
                if (i % 3 == 0 && i % 2 == 0) {
                    min = Math.min(min, nums[i / 3]);
                    min = Math.min(min, nums[i / 2]);
                } else if (i % 3 == 0) min = Math.min(min, nums[i / 3]);
                else if (i % 2 == 0) min = Math.min(min, nums[i / 2]);
                min = Math.min(min, nums[i - 1]);
                nums[i] = min + 1;
            }
            System.out.println(nums[n]);
        }
    }
}
