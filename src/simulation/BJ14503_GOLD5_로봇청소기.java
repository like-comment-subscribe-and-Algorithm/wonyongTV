package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
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
            if (maps[r][c] == 0) {
                clean(r, c);
            }
            if (isNotClean(r, c)) {
                div = nextClean();
                if (maps[r + moves[div][0]][c + moves[div][1]] == 0) {
                    r += moves[div][0];
                    c += moves[div][1];
                }
            } else {
                int back = (div + 2) % 4;
                if (maps[r + moves[back][0]][c + moves[back][1]] == 1) {
                    break;
                }

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
            if (row < 0 || row >= n || col < 0 || col >= m) {
                continue;
            }
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

    class Main {

        private static int[][] moves = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        private static int n;
        private static int m;
        private static int[][] maps;
        private static int answer = 0;
        private static int dir;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int sr = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());
            dir = Integer.parseInt(st.nextToken());
            Queue<Site5> que = new LinkedList<>();
            que.add(new Site5(sr, sc));

            maps = new int[n][];
            for (int i = 0; i < n; i++) {
                int[] temp = new int[m];
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    temp[j] = Integer.parseInt(st.nextToken());
                }
                maps[i] = temp;
            }

            while (!que.isEmpty()) {
                Site5 site = que.poll();
                clean(site.r, site.c);

                if (isNotCleanAround(site.r, site.c)) {
                    changeDir();
                    int row = site.r + moves[dir][0];
                    int col = site.c + moves[dir][1];
                    if (row >= 0 && row < n && col >= 0 && col < m && maps[row][col] == 0) {
                        que.add(new Site5(row, col));
                    } else {
                        que.add(site);
                    }
                } else {
                    int d = (dir + 2) % 4;
                    int row = site.r + moves[d][0];
                    int col = site.c + moves[d][1];
                    if (row < 0 || row >= n || col < 0 || col >= m || maps[row][col] == 1) {
                        break;
                    }
                    que.add(new Site5(row, col));
                }
            }

            System.out.println(answer);

        }

        private static void clean(int r, int c) {
            if (maps[r][c] == 0) {
                maps[r][c] = -1;
                answer++;
            }
        }

        private static boolean isNotCleanAround(int r, int c) {
            for (int[] move : moves) {
                int row = r + move[0];
                int col = c + move[1];
                if (row < 0 || row >= n || col < 0 || col >= m) {
                    continue;
                }
                if (maps[row][col] == 0) {
                    return true;
                }
            }
            return false;
        }

        private static void changeDir() {
            dir = (dir + 3) % 4;
        }

    }
}

class Site5 {
    int r;
    int c;

    public Site5(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
