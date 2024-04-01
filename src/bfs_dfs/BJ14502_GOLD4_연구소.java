package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


// 시간 복잡도 2배임...
public class BJ14502_GOLD4_연구소 {
    private static int n;
    private static int m;
    private static int[][] nums;
    private static List<Site3> virus;
    private static int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int wallCount = 0;
    private static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[n][m];
        virus = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
                if (nums[i][j] == 2) virus.add(new Site3(i, j));
                if (nums[i][j] == 1) wallCount++;
            }
        }

        play(0);
        System.out.println(answer);
    }

    private static void play(int wall) {
        if (wall == 3) {
            int spreadCount = spread();
            answer = Math.max(answer, count(spreadCount));
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (nums[i][j] != 0) continue;
                nums[i][j] = 1;
                play(wall + 1);
                nums[i][j] = 0;
            }
        }
    }

    private static int spread() {
        Queue<Site3> que = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        for (Site3 site : virus) {
            que.add(site);
            visited[site.r][site.c] = true;
        }
        int count = 0;
        while (!que.isEmpty()) {
            Site3 site = que.poll();
            count++;
            for (int[] move : moves) {
                int row = site.r + move[0];
                int col = site.c + move[1];
                if (row < 0 || row >= n || col < 0 || col >= m || visited[row][col] || nums[row][col] == 2 || nums[row][col] == 1)
                    continue;
                que.add(new Site3(row, col));
                visited[row][col] = true;
            }
        }
        return count;
    }

    // +3은 추가된 벽의 개수
    private static int count(int spreadCount) {
        return n * m - (spreadCount + wallCount + 3);
    }
}

class Site3 {
    int r;
    int c;

    public Site3(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
