package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2805_SILVER2_나무자르기 {
    /*
     * 시간 제한 : 1초
     * n = 1,000,000 , m = 2,000,000,000
     * 시간 복잡도 최대 : nlog(n)
     *
     * 1. arr 을 받고, 정렬을 한다.
     * 2. 최대 값을 오른쪽 , 최소 값을 0으로 한다.
     * 3. 이 둘의 중앙 값을 기준으로 계산을 진행하며 반복한다.
     * 4. left 값을 출력한다.
     *
     * 이 때 최대 2,000,000,000 * 1,000,000 이니 long 타입이어야 한다.
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int right = arr[n - 1];
        int left = 0;
        while (left < right - 1) {
            int mid = (left + right) / 2;
            long temp = 0;
            for (int a : arr) {
                if (a <= mid) continue;
                temp += (a - mid);
            }
            if (temp >= m) left = mid;
            else right = mid;
        }
        System.out.println(left);
    }
}
