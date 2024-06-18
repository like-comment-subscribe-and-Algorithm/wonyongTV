package union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1916_GOLD5_집합의표현 {
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int c = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (c == 1) {
                if (parent(a) == parent(b)) {
                    sb.append("YES").append("\n");
                } else {
                    sb.append("NO").append("\n");
                }
            } else {
                union(a, b);
            }
        }
        System.out.println(sb);
    }

    private static void union(int a, int b) {
        int x = parent(a);
        int y = parent(b);

        if (x >= y) {
            nums[x] = y;
        } else {
            nums[y] = x;
        }
    }

    private static int parent(int num) {
        if (num != nums[num]) {
            return nums[num] = parent(nums[num]);
        }
        return num;
    }
}
