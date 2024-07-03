package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2589_GOLD5_보물섬 {
    static int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int row;
    static int col;
    static String[] map;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        map = new String[row];
        for (int r = 0; r < row; r++) {
            map[r] = br.readLine();
        }

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (map[r].charAt(c) == 'L') {
                    bfs(new Site(r, c, 0));
                }
            }
        }

        System.out.println(answer);
    }

    static void bfs(Site site) {
        boolean[][] visited = new boolean[row][col];
        Queue<Site> que = new LinkedList<>();

        visited[site.r][site.c] = true;
        que.add(site);

        while (!que.isEmpty()) {
            Site s = que.poll();
            for (int[] move : moves) {
                int r = s.r + move[0];
                int c = s.c + move[1];
                if (r < 0 || r >= row || c < 0 || c >= col || visited[r][c] || map[r].charAt(c) == 'W') {
                    continue;
                }
                visited[r][c] = true;
                answer = Math.max(answer, s.dist + 1);
                que.add(new Site(r, c, s.dist + 1));
            }
        }
    }

    static class Site {
        int r;
        int c;
        int dist;

        public Site(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
}
