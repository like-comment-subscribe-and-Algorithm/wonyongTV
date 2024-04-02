package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ16234_GOLD4_인구이동 {
    private static int n;
    private static int l;
    private static int r;
    private static int[][] nums;
    private static boolean[][] visited;
    private static int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        // 1. 탐색
        // 2. 연합 의 합 구하기
        // 3. 해당 연합 분배
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        while (true) {
            Queue<Queue<Site>> list = new LinkedList<>();
            bfs(list);
            if (list.isEmpty()) break;
            solve(list);
            answer++;
        }
        System.out.println(answer);
    }

    private static boolean isValid(int r1, int c1, int r2, int c2) {
        int temp = Math.abs(nums[r1][c1] - nums[r2][c2]);
        return temp >= l && temp <= r;
    }

    private static void bfs(Queue<Queue<Site>> list) {
        visited = new boolean[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (visited[r][c]) continue;
                Queue<Site> que = new LinkedList<>();
                Queue<Site> temp = new LinkedList<>();
                que.add(new Site(r, c));
                temp.add(new Site(r, c));
                visited[r][c] = true;
                while (!que.isEmpty()) {
                    Site site = que.poll();
                    for (int[] move : moves) {
                        int row = site.r + move[0];
                        int col = site.c + move[1];
                        if (row < 0 || row >= n || col < 0 || col >= n || visited[row][col] || !isValid(site.r, site.c, row, col))
                            continue;
                        visited[row][col] = true;
                        que.add(new Site(row, col));
                        temp.add(new Site(row, col));
                    }
                }
                if (temp.size() != 1) list.add(temp);
            }
        }
    }

    private static void solve(Queue<Queue<Site>> list) {
        for (Queue<Site> que : list) {
            int temp = 0;
            for (Site q : que) {
                temp += nums[q.r][q.c];
            }

            temp /= que.size();
            while (!que.isEmpty()) {
                Site site = que.poll();
                nums[site.r][site.c] = temp;
            }
        }
    }
}
