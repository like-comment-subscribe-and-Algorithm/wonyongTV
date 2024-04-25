package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1911_GOLD5_흙길보수하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[][] nums = new int[n][];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int[] temp = new int[2];
            temp[0] = Integer.parseInt(st.nextToken());
            temp[1] = Integer.parseInt(st.nextToken());
            nums[i] = temp;
        }

        Arrays.sort(nums, (a, b) -> {
            return a[0] - b[0];
        });

        int startIdx = 0;
        int answer = 0;
        for (int[] num : nums) {
            if (startIdx > num[1]) continue;
            if (startIdx < num[0]) startIdx = num[0];

            int div = num[1] - startIdx;
            int cnt = div / l;
            answer += cnt;
            startIdx += cnt * l;
            if (div % l != 0) {
                answer++;
                startIdx += l;
            }
        }

        System.out.println(answer);
    }
}
