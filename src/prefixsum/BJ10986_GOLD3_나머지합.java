package prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10986_GOLD3_나머지합 {
    /*
     * (S[j] - S[i-1]) % M = 0
     * S[j] % M = S[i-1] % M
     *
     * 구간합에서 동일한 나머지가 나오는 부분 중 2개를 선택하면 식이 성립된다.
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] nums = new long[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = nums[i - 1] + Integer.parseInt(st.nextToken());
        }

        long[] temp = new long[m];
        for (int i = 1; i <= n; i++) {
            temp[(int) (nums[i] % m)] += 1;
        }
        long answer = 0;

        for (int i = 0; i < m; i++) {
            answer += (temp[i] * (temp[i] - 1)) / 2;
        }

        System.out.println(answer + temp[0]);
    }
}
