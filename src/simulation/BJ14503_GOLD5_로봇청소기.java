package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14503_GOLD5_로봇청소기 {
    // 0 북 1 동 2 남 3 서
    // 벽과 청소한 곳은 다르다.
    //   북
    // 서   동   이렇게다. 주의하자
    //   남
    private static int[][] maps;
    private static int[][] moves = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static int n;
    private static int m;
    private static int div;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        div = Integer.parseInt(st.nextToken());

        maps = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int[] temp = new int[m];
            for (int j = 0; j < m; j++) {
                temp[j] = Integer.parseInt(st.nextToken());
            }
            maps[i] = temp;
        }

        while (r > -1 && r < n && c > -1 && c < m) {
            if (maps[r][c] == 0) clean(r, c);
            if (isNotClean(r, c)) {
                div = nextClean();
                if (maps[r + moves[div][0]][c + moves[div][1]] == 0) {
                    r += moves[div][0];
                    c += moves[div][1];
                }
            } else {
                int back = (div + 2) % 4;
                if (maps[r + moves[back][0]][c + moves[back][1]] == 1) break;

                r += moves[back][0];
                c += moves[back][1];

            }
        }

        System.out.println(answer);
    }

    private static void clean(int r, int c) {
        maps[r][c] = -1;
        answer++;
    }

    private static boolean isNotClean(int r, int c) {
        boolean temp = false;
        for (int[] move : moves) {
            int row = r + move[0];
            int col = c + move[1];
            if (row < 0 || row >= n || col < 0 || col >= m) continue;
            if (maps[row][col] == 0) {
                temp = true;
                break;
            }
        }
        return temp;
    }

    private static int nextClean() {
        return (div + 3) % 4;
    }
}
