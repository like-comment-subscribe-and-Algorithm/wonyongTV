package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ2217_SILVER4_로프 {
    /*
     * 시간 제한 : 2초 , 2 * 10^8
     * n = 100,000 = 10^5
     * nLog(n) = 10^5 * 16
     * n^2 = 10^10
     *
     * 따라서 시간 복잡도는 nLog(n) 이내로 풀어야 한다.
     *
     * 모든 로프를 사용하지 않을 때 최대 값이 나올 수 있는 것을 주의 한다. (10, 40, 45)
     *
     * 1. 정렬을 해서 최소 값을 구한다.
     * 2. 0부터 i까지 반복문을 돌린다.
     *      현재 값 * (n-i) 의 값과 이전 값을 비교하며 최대 값을 구한다.
     * 3. 최대 값을 출력한다.
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(nums[i] * (n - i), max);
        }
        System.out.println(max);
    }
}
