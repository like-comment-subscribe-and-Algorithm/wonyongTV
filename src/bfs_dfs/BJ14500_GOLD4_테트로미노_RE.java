package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14500_GOLD4_테트로미노_RE {
    private static int answer = Integer.MIN_VALUE;
    private static int n;
    private static int m;
    private static int[][] nums;
    private static int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nums = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                visited[r][c] = true;
                dfs(r, c, 1, nums[r][c]);
                visited[r][c] = false;
            }
        }
        System.out.println(answer);
    }

    private static void dfs(int row, int col, int count, int temp) {
        if (count == 4) {
            answer = Math.max(temp, answer);
            return;
        }

        for (int[] move : moves) {
            int r = row + move[0];
            int c = col + move[1];
            if (r < 0 || r >= n || c < 0 || c >= m || visited[r][c]) continue;

            if (count == 2) {
                visited[r][c] = true;
                dfs(row, col, count + 1, temp + nums[r][c]);
                visited[r][c] = false;
            }
            visited[r][c] = true;
            dfs(r, c, count + 1, temp + nums[r][c]);
            visited[r][c] = false;
        }
    }
}
