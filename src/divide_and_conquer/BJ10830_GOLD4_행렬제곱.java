package divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ10830_GOLD4_행렬제곱 {
    /*
     * 지수 법칙을 활용한다.
     * a^10 = a^5 * a^5
     * a^5 = a^2 * a^2 * a
     *
     * 1. 배열 arr 을 입력 받는다.
     * 2. n == 1일 땐 arr 을 반환한다.
     * 3.1 n == 짝수일 땐 a^(n/2) * a^(n/2) 계산을 한다.
     * 3.2 n == 홀 수 일 땐 a^(n/2) * a^(n/2) * arr 계산을 한다.
     *
     * 주의
     * 2 1
     * 1000 1000
     * 1000 1000
     * 일 때, 답은
     * 1000 1000
     * 1000 1000
     * 이 아닌
     * 0 0
     * 0 0
     * 이다. (%1000 을 해야되기 때문)
     * */
    private static int[][] arr;
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] answer = divide(b);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int[][] divide(long b) {
        if (b == 1) {
            int[][] temp = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    temp[i][j] = arr[i][j] % 1000;
                }
            }
            return temp;
        }

        int[][] temp = divide(b / 2);
        if (b % 2 == 0) return cal(temp, temp);
        else return cal(cal(temp, temp), arr);
    }

    private static int[][] cal(int[][] a, int[][] b) {
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int[] row = a[i];
                int[] col = new int[n];
                for (int m = 0; m < n; m++) {
                    col[m] = b[m][j];
                }
                int t = 0;
                for (int m = 0; m < n; m++) {
                    t += (row[m] * col[m]);
                }
                temp[i][j] = t % 1000;
            }
        }

        return temp;
    }
}
