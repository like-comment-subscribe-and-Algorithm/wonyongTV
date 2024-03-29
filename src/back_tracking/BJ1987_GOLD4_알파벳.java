package back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1987_GOLD4_알파벳 {
    private static int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int r;
    private static int c;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        String[][] maps = new String[r][];
        for (int i = 0; i < r; i++) {
            maps[i] = br.readLine().split("");
        }

        Queue<Site> que = new LinkedList<>();
        HashMap<String, Boolean> map = new HashMap<>();
        que.add(new Site(0, 0));
        map.put(maps[0][0], true);
        dfs(maps, que, map, 1);
        System.out.println(answer);
    }

    private static void dfs(String[][] maps, Queue<Site> que, HashMap<String, Boolean> map, int count) {
        Site site = que.poll();
        if (isValid(site, map, maps)) {
            answer = Math.max(answer, count);
            return;
        }

        for (int[] move : moves) {
            int row = site.r + move[0];
            int col = site.c + move[1];

            if (row < 0 || row >= r || col < 0 || col >= c || map.containsKey(maps[row][col])) continue;
            map.put(maps[row][col], true);
            que.add(new Site(row, col));
            dfs(maps, que, map, count + 1);
            map.remove(maps[row][col]);
        }
    }

    private static boolean isValid(Site site, HashMap<String, Boolean> map, String[][] maps) {
        int count = 0;
        for (int[] move : moves) {
            int row = site.r + move[0];
            int col = site.c + move[1];

            if (row < 0 || row >= r || col < 0 || col >= c || map.containsKey(maps[row][col])) continue;
            count++;
        }
        return count == 0;
    }
}

class Site {
    int r;
    int c;

    public Site(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

