package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ12865_GOLD_평범한배낭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Dummy[] arr = new Dummy[n + 1];
        arr[0] = new Dummy(0, 0);
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Dummy(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr);

        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                if (i < arr[j].w) {
                    dp[j][i] = dp[j - 1][i];
                    continue;
                }
                dp[j][i] = Math.max(dp[j - 1][i], dp[j - 1][i - arr[j].w] + arr[j].v);
            }
        }
        System.out.println(dp[n][k]);
    }
}

class Dummy implements Comparable<Dummy> {
    int w;
    int v;

    public Dummy(int w, int v) {
        this.w = w;
        this.v = v;
    }

    @Override
    public int compareTo(Dummy o) {
        if (this.w == o.w) return this.v - o.v;
        return this.w - o.w;
    }
}
