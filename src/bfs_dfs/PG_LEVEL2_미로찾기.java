package bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;

public class PG_LEVEL2_미로찾기 {
    public int solution(String[] maps) {
        Site start = null;
        Site l = null;
        Site end = null;
        int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for (int r = 0; r < maps.length; r++) {
            char[] m = maps[r].toCharArray();
            for (int c = 0; c < m.length; c++) {
                if (m[c] == 'S') {
                    start = new Site(r, c);
                } else if (m[c] == 'L') {
                    l = new Site(r, c);
                } else if (m[c] == 'E') {
                    end = new Site(r, c);
                }
            }
        }

        Queue<Site> que = new LinkedList<>();
        que.add(start);
        int[][] count = new int[maps.length][maps[0].length()];
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        visited[start.r][start.c] = true;
        while (!que.isEmpty()) {
            Site curr = que.poll();
            if (curr.r == l.r && curr.c == l.c) {
                break;
            }
            for (int[] move : moves) {
                int nr = curr.r + move[0];
                int nc = curr.c + move[1];
                if (nr < 0 || nr >= maps.length || nc < 0 || nc >= maps[0].length() || visited[nr][nc]
                        || maps[nr].charAt(nc) == 'X') {
                    continue;
                }
                count[nr][nc] = count[curr.r][curr.c] + 1;
                visited[nr][nc] = true;
                que.add(new Site(nr, nc));
            }
        }
        if (!visited[l.r][l.c]) {
            return -1;
        }

        que = new LinkedList<>();
        que.add(l);
        visited = new boolean[maps.length][maps[0].length()];
        visited[l.r][l.c] = true;
        while (!que.isEmpty()) {
            Site curr = que.poll();
            if (curr.r == end.r && curr.c == end.c) {
                break;
            }
            for (int[] move : moves) {
                int nr = curr.r + move[0];
                int nc = curr.c + move[1];
                if (nr < 0 || nr >= maps.length || nc < 0 || nc >= maps[0].length() || visited[nr][nc]
                        || maps[nr].charAt(nc) == 'X') {
                    continue;
                }
                count[nr][nc] = count[curr.r][curr.c] + 1;
                visited[nr][nc] = true;
                que.add(new Site(nr, nc));
            }
        }

        if (!visited[end.r][end.c]) {
            return -1;
        }
        return count[end.r][end.c];
    }

    class Site {
        int r;
        int c;

        public Site(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}

