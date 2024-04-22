package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2206_GOLD3_벽부수고이동하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[][] maps = new String[n][m];
        for (int i = 0; i < n; i++) {
            maps[i] = br.readLine().split("");
        }

        int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][][] visited = new boolean[n][m][2];
        Queue<S> que = new LinkedList<>();
        visited[0][0][0] = true;
        que.add(new S(0, 0, 1, false));

        while (!que.isEmpty()) {
            S site = que.poll();
            if (site.r == n - 1 && site.c == m - 1) {
                System.out.println(site.cnt);
                return;
            }
            for (int[] move : moves) {
                int row = site.r + move[0];
                int col = site.c + move[1];

                int next = site.cnt + 1;

                if (row < 0 || row >= n || col < 0 || col >= m) continue;
                if (site.isBreak && maps[row][col].equals("1")) continue;

                if (maps[row][col].equals("1")) {
                    visited[row][col][1] = true;
                    que.add(new S(row, col, next, true));
                } else {
                    if (site.isBreak && !visited[row][col][1]) {
                        visited[row][col][1] = true;
                        que.add(new S(row, col, next, site.isBreak));
                    } else if (!site.isBreak && !visited[row][col][0]) {
                        visited[row][col][0] = true;
                        que.add(new S(row, col, next, site.isBreak));
                    }
                }
            }
        }

        System.out.println(-1);
    }
}

class S {
    int r;
    int c;
    int cnt;
    boolean isBreak;

    public S(int r, int c, int cnt, boolean isBreak) {
        this.r = r;
        this.c = c;
        this.cnt = cnt;
        this.isBreak = isBreak;
    }
}
