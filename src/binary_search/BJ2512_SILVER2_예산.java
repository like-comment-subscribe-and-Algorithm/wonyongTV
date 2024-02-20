package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2512_SILVER2_예산 {
    /*
     * 시간 제한 : 1초 , 10^8
     * n = 10,000 , 10^4
     * 시간복잡도 nLog(N)이 안전
     *
     * 1. nums 정렬
     * 2. 최소 값은 0, 최대 값은 nums의 마지막 원소로 설정한다.
     * 3. 최소, 최대 값의 중앙 값을 구한 뒤 연산을 진행한다.
     * 4. 연산 결과가 m 보다 작거나 같으면 최소 값을 중앙 값 + 1 로 갱신한다.
     * 5. 그렇지 않으면 최대 값을 중앙 값 - 1 로 갱신한다.
     * 6. 최대 값을 출력한다.
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());

        Arrays.sort(nums);
        int min = 0;
        int max = nums[n - 1];

        while (min <= max) {
            int mid = (min + max) / 2;

            int temp = 0;
            for (int num : nums) {
                temp += Math.min(mid, num);
            }

            if (temp <= m) min = mid + 1;
            else max = mid - 1;
        }
        System.out.println(max);
    }
}
