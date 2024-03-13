package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ1743_SILVER1_음식물피하기 {
    /*
     * 1. true 일 때 dfs 시작
     * 2. 순회를 하면서 지나간 곳은 false 로 변경
     * 3. 본인의 최대 거리와 최대 값 비교하며 값 갱신
     *
     * 주의
     * false 처리를 move 하는 중에 해야한다.
     * x x x
     * x x o
     * x o o
     *
     * 상황일 때 pop 할 때 false 처리를 하면,
     * 1,1 을 아직 pop 하지 않았다면,
     * 0,1 에서 1,0 에서 1,1 stack 에 추가하게 되어 1,1 을 2번 방문하게 된다
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[n][m];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r - 1][c - 1] = true;
        }

        Stack<Site> stack = new Stack<>();
        int answer = 0;
        int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (!map[r][c]) continue;

                int temp = 0;
                stack.add(new Site(r, c));
                map[r][c] = false;
                while (!stack.isEmpty()) {
                    Site curr = stack.pop();
                    temp++;

                    for (int[] move : moves) {
                        int nextX = curr.x + move[0];
                        int nextY = curr.y + move[1];
                        if (nextX > -1 && nextX < n && nextY > -1 && nextY < m && map[nextX][nextY]) {
                            stack.add(new Site(nextX, nextY));
                            map[nextX][nextY] = false;
                        }
                    }
                }
                answer = Math.max(answer, temp);
            }
        }

        System.out.println(answer);
    }
}

class Site {
    int x;
    int y;

    public Site(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
