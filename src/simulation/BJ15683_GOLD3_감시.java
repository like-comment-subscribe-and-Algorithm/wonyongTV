package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ15683_GOLD3_감시 {
    /*
     * 상 우 하 좌
     * 1 : {1,0,0,0} , {0,1,0,0} , {0,0,1,0} , {0,0,0,1}
     * 2 : {1,0,1,0} , {0,1,0,1}
     * 3 : {1, 1, 0, 0}, {0, 1, 1, 0}, {0, 0, 1, 1}, {1, 0, 0, 1}
     * 4 : {1,1,0,1} , {1,1,1,0} , {0,1,1,1} , {1,0,1,1}
     * 5 : {1,1,1,1}
     * */
    private static int n;
    private static int m;
    private static int[][][] dirs = {
            {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}},
            {{1, 0, 1, 0}, {0, 1, 0, 1}},
            {{1, 1, 0, 0}, {0, 1, 1, 0}, {0, 0, 1, 1}, {1, 0, 0, 1}},
            {{1, 1, 0, 1}, {1, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}},
            {{1, 1, 1, 1}}
    };

    private static int[][] nums;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        nums = new int[n][m];
        List<Integer> cctvs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
                if (nums[i][j] > 0 && nums[i][j] < 6) {
                    cctvs.add(nums[i][j]);
                }
            }
        }

        comb(cctvs, 0, new int[cctvs.size()]);
        System.out.println(answer);

    }

    private static void comb(List<Integer> cctvs, int idx, int[] com) {
        if (cctvs.size() == idx) {
            int[][] temp = new int[n][m];
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    temp[r][c] = nums[r][c];
                }
            }
            answer = Math.min(answer, solve(com, temp));
            return;
        }

        for (int j = 0; j < dirs[cctvs.get(idx) - 1].length; j++) {
            com[idx] = j;
            comb(cctvs, idx + 1, com);
        }
    }

    private static int solve(int[] com, int[][] temp) {
        int i = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (temp[r][c] == 0 || temp[r][c] == 6 || temp[r][c] == -1) {
                    continue;
                }

                int[] dir = dirs[temp[r][c] - 1][com[i++]];
                if (dir[0] == 1) {
                    up(r, c, temp);
                }
                if (dir[1] == 1) {
                    right(r, c, temp);
                }
                if (dir[2] == 1) {
                    down(r, c, temp);
                }
                if (dir[3] == 1) {
                    left(r, c, temp);
                }
            }
        }

        int cnt = 0;
        for (int[] tem : temp) {
            for (int t : tem) {
                if (t == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void left(int r, int c, int[][] temp) {
        for (int col = c - 1; col > -1; col--) {
            if (temp[r][col] == 6) {
                break;
            }
            if (temp[r][col] > 0 && temp[r][col] < 6) {
                continue;
            }
            temp[r][col] = -1;
        }
    }

    private static void right(int r, int c, int[][] temp) {
        for (int col = c + 1; col < m; col++) {
            if (temp[r][col] == 6) {
                break;
            }
            if (temp[r][col] > 0 && temp[r][col] < 6) {
                continue;
            }
            temp[r][col] = -1;
        }
    }

    private static void up(int r, int c, int[][] temp) {
        for (int row = r - 1; row > -1; row--) {
            if (temp[row][c] == 6) {
                break;
            }
            if (temp[row][c] > 0 && temp[row][c] < 6) {
                continue;
            }
            temp[row][c] = -1;
        }
    }

    private static void down(int r, int c, int[][] temp) {
        for (int row = r + 1; row < n; row++) {
            if (temp[row][c] == 6) {
                break;
            }
            if (temp[row][c] > 0 && temp[row][c] < 6) {
                continue;
            }
            temp[row][c] = -1;
        }
    }
}
