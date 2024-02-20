package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1904_SILVER3_01타일 {
    /*
     * 시간 제한 : 0.75 , 10^6(?)
     * n : 1,000,000 , 10^6
     * 시간 복잡도 n 이내
     *
     * 1 : 1 (1)
     * 2 : 2 (00, 11)
     * 3 : 3 (100, 111, 001)
     * 4 : 5 (0000, 0011, 1100, 1001, 1111)
     * 5 : 8 (00001, 00100, 10000, 11100, 00111, 10011, 11001, 11111)
     *
     * n = [n-1] + [n-2] 인 규칙 발견
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            nums[i] = (nums[i - 1] + nums[i - 2]) % 15746;
        }
        System.out.println(nums[n]);
    }
}
