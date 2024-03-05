package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ5427_GOLD4_불 {
    /*
     * 1. @ 다음 경로 이동
     * 2. * 불 전파
     * 종료 조건
     *   1. 0 또는 행 도착 0 또는 열 도착
     *   2. que 에 더 이상 좌표가 안들어올 때
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            String[][] maps = new String[r][];
            for (int j = 0; j < r; j++) {
                maps[j] = br.readLine().split("");
            }

            Queue<Site2> que = new LinkedList<>();
            Queue<Site2> fires = new LinkedList<>();
            for (int y = 0; y < r; y++) {
                for (int x = 0; x < c; x++) {
                    if (maps[y][x].equals("@")) que.add(new Site2(y, x));
                    if (maps[y][x].equals("*")) fires.add(new Site2(y, x));
                }
            }
            boolean[][] visited = new boolean[r][c];
            int[][] moves = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            boolean isAns = false;
            int count = 0;
            while (!que.isEmpty()) {
                count++;

                // 불 전파 시키기
                Queue<Site2> temp = new LinkedList<>();
                while (!fires.isEmpty()) temp.add(fires.poll());
                while (!temp.isEmpty()) {
                    Site2 site = temp.poll();
                    for (int[] move : moves) {
                        int nextR = site.r + move[0];
                        int nextC = site.c + move[1];
                        if (nextC == c || nextC == -1 || nextR == r || nextR == -1) continue;
                        if (maps[nextR][nextC].equals("*") || maps[nextR][nextC].equals("#")) continue;
                        maps[nextR][nextC] = "*";
                        fires.add(new Site2(nextR, nextC));
                    }
                }

                // 다음 경로 이동
                temp = new LinkedList<>();
                while (!que.isEmpty()) temp.add(que.poll());
                while (!temp.isEmpty()) {
                    Site2 site = temp.poll();
                    for (int[] move : moves) {
                        int nextR = site.r + move[0];
                        int nextC = site.c + move[1];

                        if (nextC == c || nextC == -1 || nextR == r || nextR == -1) {
                            isAns = true;
                            break;
                        }
                        if (maps[nextR][nextC].equals("*") || maps[nextR][nextC].equals("#") || visited[nextR][nextC])
                            continue;
                        visited[nextR][nextC] = true;
                        que.add(new Site2(nextR, nextC));
                    }
                }

                if (isAns) break;
            }

            if (isAns) System.out.println(count);
            else System.out.println("IMPOSSIBLE");
        }
    }
}

class Site2 {
    int r;
    int c;

    public Site2(int r, int c) {
        this.r = r;
        this.c = c;
    }
}