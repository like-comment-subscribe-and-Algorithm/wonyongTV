package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1018_SILVER4_체스판다시칠하기 {
    /*
     * 시간 제한 : 2초 , 2 * 10^8
     * 8<= n,m <= 50
     *
     * n^2 : 2500
     * n^3 : 125,000
     *
     * 시간 복잡도는 크게 고려하지 않아도 됌.
     *
     * 1. 가로 0~(m-8)만큼 반복한다.
     *   2. 세로 0~(n-8)만큼 반복한다.
     *       3-1. 시작이 W일 때 수정되는 체스판 개수를 구한다.
     *       3-2. 시작이 B일 때 수정되는 체스판 개수를 구한다.
     *       3-3. 3-1, 3-2 의 값과 현재 최소 값을 비교하여 저장한다.
     *
     * 함수
     *   1. 시작할 row, col과 시작할 타일의 boolean을 아규먼트로 받는다.
     *   2. map[r][c] 의 값이 미리 준비한 타일의 값과 일치한지 비교한다.
     *      2-1. 만약 일치하지 않으면 temp 변수의 값을 1 증가시킨다.
     * */
    private static String[][] maps;
    private static String[] rowB = {"B", "W", "B", "W", "B", "W", "B", "W"};
    private static String[] rowW = {"W", "B", "W", "B", "W", "B", "W", "B"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        maps = new String[m][n];
        for (int r = 0; r < m; r++) {
            maps[r] = br.readLine().split("");
        }

        int answer = Integer.MAX_VALUE;
        for (int r = 0; r <= m - 8; r++) {
            for (int c = 0; c <= n - 8; c++) {
                int temp = Math.min(search(r, c, true), search(r, c, false));
                answer = Math.min(temp, answer);
            }
        }

        System.out.println(answer);
    }

    private static int search(int row, int col, boolean isB) {
        int temp = 0;
        for (int r = row; r < row + 8; r++) {
            for (int c = col; c < col + 8; c++) {
                if (isB && maps[r][c].equals(rowB[c - col])) temp++;
                else if (!isB && maps[r][c].equals(rowW[c - col])) temp++;
            }
            isB = !isB;
        }
        return temp;
    }
}
