package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ4485_GOLD4_녹색입은애가젤다지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            // 동굴 값 입력
            int[][] map = new int[n][];
            for (int i = 0; i < n; i++) {
                int[] temp = new int[n];
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    temp[j] = Integer.parseInt(st.nextToken());
                }
                map[i] = temp;
            }

            // 최소값 배열 초기화
            int[][] min = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    min[i][j] = Integer.MAX_VALUE;
                }
            }

            // 초기값 세팅
            PriorityQueue<SiteG> que = new PriorityQueue<>();
            boolean[][] visited = new boolean[n][n];
            min[0][0] = map[0][0];
            que.add(new SiteG(0, 0, map[0][0]));

            // 이동
            while (!que.isEmpty()) {
                SiteG site = que.poll();
                if (visited[site.r][site.c]) continue;
                visited[site.r][site.c] = true;

                for (int[] move : moves) {
                    int row = site.r + move[0];
                    int col = site.c + move[1];

                    if (row < 0 || row >= n || col < 0 || col >= n) continue;
                    int w = site.w + map[row][col];
                    if (w < min[row][col]) {
                        min[row][col] = w;
                        que.add(new SiteG(row, col, w));
                    }
                }
            }

            sb.append("Problem ").append(cnt++).append(": ").append(min[n - 1][n - 1]).append("\n");
        }
        System.out.println(sb);
    }
}

class SiteG implements Comparable<SiteG> {
    int r;
    int c;
    int w;

    public SiteG(int r, int c, int w) {
        this.r = r;
        this.c = c;
        this.w = w;
    }

    @Override
    public int compareTo(SiteG o) {
        return this.w - o.w;
    }
}