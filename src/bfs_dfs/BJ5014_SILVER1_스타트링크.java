package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ5014_SILVER1_스타트링크 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[f + 1];
        Queue<Floor> que = new LinkedList<>();
        que.add(new Floor(s, 0));
        visited[s] = true;
        int answer = -1;
        while (!que.isEmpty()) {
            Floor floor = que.poll();
            if (floor.curr == g) {
                answer = floor.count;
                break;
            }

            int up = floor.curr + u;
            int down = floor.curr - d;

            if (up >= 1 && up <= f && !visited[up]) {
                visited[up] = true;
                que.add(new Floor(up, floor.count + 1));
            }
            if (down >= 1 && down <= f && !visited[down]) {
                visited[down] = true;
                que.add(new Floor(down, floor.count + 1));
            }
        }
        if (answer == -1) System.out.println("use the stairs");
        else System.out.println(answer);
    }
}

class Floor {
    int curr;
    int count;

    public Floor(int curr, int count) {
        this.curr = curr;
        this.count = count;
    }
}
