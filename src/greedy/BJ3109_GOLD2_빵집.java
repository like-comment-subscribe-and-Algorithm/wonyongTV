package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ3109_GOLD2_빵집 {
    private static boolean[] goals;
    private static int row;
    private static int col;
    private static String[][] maps;
    private static boolean[][] visited;
    private static int[][] moves = {{-1, 1}, {0, 1}, {1, 1}};
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        goals = new boolean[row];
        maps = new String[row][];
        for (int i = 0; i < row; i++) {
            maps[i] = br.readLine().split("");
        }

        visited = new boolean[row][col];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (maps[r][c].equals("x")) visited[r][c] = true;
            }
        }

        for (int r = 0; r < row; r++) {
            visited[r][0] = true;
            dfs(r, 0, r);
        }

        System.out.println(answer);
    }

    private static void dfs(int r, int c, int start) {
        if (goals[start]) return;
        if (c == col - 1) {
            goals[start] = true;
            answer++;
            return;
        }
        for (int[] move : moves) {
            int nr = r + move[0];
            int nc = c + move[1];
            if (goals[start] || nr < 0 || nr >= row || nc < 0 || nc >= col || visited[nr][nc]) continue;
            visited[nr][nc] = true;
            dfs(nr, nc, start);
        }
    }
}
