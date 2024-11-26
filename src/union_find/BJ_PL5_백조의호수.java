package union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_PL5_백조의호수 {
    static Site start;
    static Site end;
    static String[][] lake;
    static int r;
    static int c;
    static int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static Queue<Site> ice = new ArrayDeque<>();
    static boolean[][] iceVisited;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        init();
        int count = 0;
        while (find(start.r * c + start.c) != find(end.r * c + end.c)) {
            melt();
            count++;
        }
        System.out.println(count);
    }

    static void melt() {
        int size = ice.size();
        for (int i = 0; i < size; i++) {
            Site site = ice.poll();
            lake[site.r][site.c] = ".";
            for (int[] move : moves) {
                int nr = site.r + move[0];
                int nc = site.c + move[1];
                if (isInValid(nr, nc)) {
                    continue;
                }
                if (lake[nr][nc].equals("X") && !iceVisited[nr][nc]) {
                    ice.add(new Site(nr, nc));
                    iceVisited[nr][nc] = true;
                } else if (lake[nr][nc].equals(".") || lake[nr][nc].equals("L")) {
                    union(site.r * c + site.c, nr * c + nc);
                }
            }
        }
    }

    static boolean isInValid(int row, int col) {
        return row < 0 || row >= r || col < 0 || col >= c;
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        lake = new String[r][c];
        iceVisited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            lake[i] = br.readLine().split("");
        }

        // 백조 위치 구하기 , 집합 생성
        parent = new int[r * c];
        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                parent[row * c + col] = row * c + col;

                if (lake[row][col].equals("L")) {
                    if (start == null) {
                        start = new Site(row, col);
                    } else if (end == null) {
                        end = new Site(row, col);
                    }
                }
            }
        }

        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                if (lake[row][col].equals("X")) {
                    continue;
                }
                for (int[] move : moves) {
                    int nr = row + move[0];
                    int nc = col + move[1];
                    if (isInValid(nr, nc)) {
                        continue;
                    }
                    if (lake[nr][nc].equals("X") && !iceVisited[nr][nc]) {
                        ice.add(new Site(nr, nc));
                        iceVisited[nr][nc] = true;
                    } else if (lake[nr][nc].equals(".") || lake[nr][nc].equals("L")) {
                        union(row * c + col, nr * c + nc);
                    }
                }
            }
        }
    }

    static void union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);

        if (p1 != p2) {
            parent[p1] = p2;
        }
    }

    static int find(int num) {
        if (parent[num] != num) {
            return parent[num] = find(parent[num]);
        }
        return parent[num];
    }

    static class Site {
        int r;
        int c;

        public Site(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
