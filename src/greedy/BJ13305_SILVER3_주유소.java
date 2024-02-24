package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ13305_SILVER3_주유소 {
    /*
     * 1. 0~n-1 까지 순회하며 최소값 을 갱신한다.
     * 2. 갱신한 값과 현재 거리 값을 곱해서 더한다.
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] distances = new long[n - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            distances[i] = Long.parseLong(st.nextToken());
        }

        long[] prices = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            prices[i] = Long.parseLong(st.nextToken());
        }

        long money = 0;
        long temp = prices[0];
        for (int i = 0; i < n - 1; i++) {
            if (temp > prices[i]) temp = prices[i];
            money += (distances[i] * temp);
        }
        System.out.println(money);
    }
}
