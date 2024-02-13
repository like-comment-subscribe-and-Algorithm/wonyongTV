package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ18310_SILVER3_안테나 {
    /*
     * 시간 제한 : 1초 , 10^8
     * n = 200,000 , 2*10^5
     * 시간 복잡도 : 최소 nLog(n)으로 풀어야함
     *
     * 1. 값을 입력 받는다.
     * 2. n==1 일 때, index가 0인 값을 출력한다.
     * 3. 아니라면, 배열을 정렬한다.
     * 4. 중앙 값이 곧 최적이므로 중앙 값을 출력한다.
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        System.out.println(nums[(n - 1) / 2]);
    }
}
