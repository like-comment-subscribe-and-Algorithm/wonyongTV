package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ21610_GOLD5_마법사상어와비바라기 {
    private static int[][] commands = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] maps = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] commands = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                commands[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<Site> que = new LinkedList<>();
        que.add(new Site(n - 1, 0));
        que.add(new Site(n - 1, 1));
        que.add(new Site(n - 2, 0));
        que.add(new Site(n - 2, 1));

        for (int i = 0; i < m; i++) {
            move(commands[i][0] - 1, commands[i][1], que, n);
            rain(maps, que);
            copy(maps, que, n);
            nextRain(maps, que, n);
        }

        System.out.println(sum(maps));
    }

    private static void move(int d, int s, Queue<Site> que, int n) {
        for (int i = 0; i < que.size(); i++) {
            Site site = que.poll();
            site.move(commands[d], s, n);
            que.add(site);
        }
    }

    private static void rain(int[][] maps, Queue<Site> que) {
        for (Site site : que) {
            maps[site.r][site.c] += 1;
        }
    }

    private static void copy(int[][] maps, Queue<Site> que, int n) {
        // 1, 3, 5, 7
        for (Site site : que) {
            int count = 0;
            for (int i = 1; i < 8; i += 2) {
                int row = site.r + commands[i][0];
                int col = site.c + commands[i][1];

                if (row < 0 || row >= n || col < 0 || col >= n || maps[row][col] == 0) continue;
                count++;
            }
            maps[site.r][site.c] += count;
        }
    }

    private static void nextRain(int[][] maps, Queue<Site> que, int n) {
        boolean[][] visited = new boolean[n][n];
        while (!que.isEmpty()) {
            Site site = que.poll();
            visited[site.r][site.c] = true;
        }
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (visited[r][c] || maps[r][c] < 2) continue;
                maps[r][c] -= 2;
                que.add(new Site(r, c));
            }
        }
    }

    private static int sum(int[][] maps) {
        int count = 0;
        for (int[] map : maps) {
            for (int m : map) {
                count += m;
            }
        }
        return count;
    }
}

class Site {
    int r;
    int c;

    public Site(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public void move(int[] move, int s, int n) {
        this.r = (this.r + s * move[0] + n * s) % n;
        this.c = (this.c + s * move[1] + n * s) % n;
    }
}
