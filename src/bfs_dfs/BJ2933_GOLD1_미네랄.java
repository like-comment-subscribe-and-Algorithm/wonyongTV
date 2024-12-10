package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2933_GOLD1_미네랄 {
    static int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        String[][] sky = new String[row + 1][col];
        for (int i = row; i >= 1; i--) {
            sky[i] = br.readLine().split("");
        }
        int n = Integer.parseInt(br.readLine());
        String[] commends = br.readLine().split(" ");
        boolean isLeft = true;
        for (int i = 0; i < n; i++) {
            int cr = Integer.parseInt(commends[i]);
            int delCol = -1;
            // 돌을 던져서 미네랄을 부신다.
            if (isLeft) {
                for (int c = 0; c < col; c++) {
                    if (sky[cr][c].equals(".")) {
                        continue;
                    }
                    delCol = c;
                    break;
                }
            } else {
                for (int c = col - 1; c >= 0; c--) {
                    if (sky[cr][c].equals(".")) {
                        continue;
                    }
                    delCol = c;
                    break;
                }
            }
            isLeft = !isLeft;

            // 미네랄을 안부셨으면 스킵한다.
            if (delCol == -1) {
                continue;
            }
            sky[cr][delCol] = ".";

            // 미네랄을 부순 뒤 클러스터를 조회한다. 공중에 떠있는 클러스터가 발견되면 해당 클러스터를 내린다.
            boolean[][] visited = new boolean[row + 1][col];
            for (int r = 1; r <= row; r++) {
                for (int c = 0; c < col; c++) {
                    if (sky[r][c].equals(".") || visited[r][c]) {
                        continue;
                    }

                    // 클러스터를 구한다.
                    Queue<int[]> que = new ArrayDeque<>();
                    List<int[]> nodes = new ArrayList<>();
                    que.add(new int[]{r, c});
                    nodes.add(new int[]{r, c});
                    visited[r][c] = true;
                    while (!que.isEmpty()) {
                        int[] node = que.poll();
                        for (int[] move : moves) {
                            int nr = node[0] + move[0];
                            int nc = node[1] + move[1];
                            if (nr <= 0 || nr > row || nc < 0 || nc >= col || sky[nr][nc].equals(".")
                                    || visited[nr][nc]) {
                                continue;
                            }

                            visited[nr][nc] = true;
                            que.add(new int[]{nr, nc});
                            nodes.add(new int[]{nr, nc});
                        }
                    }

                    // 해당 클러스터가 땅에 있다면 (r == 1) 공중에 없다는 의미이므로 스킵한다.
                    Collections.sort(nodes, (n1, n2) -> n1[0] - n2[0]);
                    if (nodes.get(0)[0] == 1) {
                        continue;
                    }

                    // 공중에 떠있는 클러스터를 얼만큼 떨어뜨릴지 계산한다. , 클러스터의 맨 하단에 있는 값을 기준으로 계산한다.
                    int diff = Integer.MAX_VALUE;
                    boolean[] colVisited = new boolean[col];
                    for (int[] node : nodes) {
                        if (colVisited[node[1]]) {
                            continue;
                        }

                        int temp = node[0];
                        for (int nr = node[0]-1; nr >= 1; nr--) {

                            if (sky[nr][node[1]].equals("x")) {
                                break;
                            }
                            temp--;
                        }
                        diff = Math.min(diff, node[0] - temp);
                        colVisited[node[1]] = true;
                    }

                    // 클러스터를 떨어뜨린다.
                    for (int[] node : nodes) {
                        sky[node[0]][node[1]] = ".";
                        sky[node[0] - diff][node[1]] = "x";

                        visited[node[0]][node[1]] = false;
                        visited[node[0] - diff][node[1]] = true;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int r = row; r >= 1; r--) {
            for (int c = 0; c < col; c++) {
                sb.append(sky[r][c]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void print(String[][] sky) {
        for (String[] cols : sky) {
            for (String c : cols) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println("-------");
    }

    static void printCluster(List<int[]> cluster) {
        for (int[] node : cluster) {
            System.out.println(node[0] + " " + node[1]);
        }
        System.out.println("-------");
    }
}

/*
에러 케이스

7 5
.....
.xxx.
.x...
xx.xx
x...x
x...x
x...x
1
4
* */