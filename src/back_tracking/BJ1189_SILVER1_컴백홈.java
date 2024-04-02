package back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1189_SILVER1_컴백홈 {
    private static String[][] maps;
    private static int[][] moves = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    private static boolean[][] visited;
    private static int r;
    private static int c;
    private static int k;
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        maps = new String[r][c];
        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            maps[i] = br.readLine().split("");
        }
        visited[r - 1][0] = true;
        dfs(r - 1, 0, 1);
        System.out.println(answer);
    }

    private static void dfs(int row, int col, int m) {
        if (row == 0 && col == c - 1) {
            if (m == k) answer++;
            return;
        }

        for (int[] move : moves) {
            int r1 = row + move[0];
            int c1 = col + move[1];
            if (r1 < 0 || r1 >= r || c1 < 0 || c1 >= c || visited[r1][c1] || maps[r1][c1].equals("T")) continue;
            visited[r1][c1] = true;
            dfs(r1, c1, m + 1);
            visited[r1][c1] = false;
        }
    }
}
