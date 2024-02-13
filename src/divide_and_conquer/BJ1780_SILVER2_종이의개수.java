package divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1780_SILVER2_종이의개수 {
    /*
     * 시간 제한 : 2초 , 2*10^8
     * n : 3^7
     *
     * 1. 범위 내에 원소들이 전부 -1, 0, 1 을 만족하는 지 읽는다.
     * 2. 아니라면 행과 열을 1/3씩 잘라서 재귀를 돌린다.
     * */
    private static final int[] papers = {-1, 0, 1};
    private static int[][] nums;
    private static int[] answer = {0, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, n, 0, n);
        StringBuilder sb = new StringBuilder();
        for (int i : answer) {
            sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

    private static void divide(int sr, int er, int sc, int ec) {
        for (int i = 0; i < 3; i++) {
            if (!read(sr, er, sc, ec, papers[i])) continue;
            answer[i]++;
            return;
        }

        int term = (er - sr) / 3;
        int midRow = sr + term;
        int midRow2 = midRow + term;
        int midCol = sc + term;
        int midCol2 = midCol + term;

        divide(sr, midRow, sc, midCol);
        divide(midRow, midRow2, sc, midCol);
        divide(midRow2, er, sc, midCol);

        divide(sr, midRow, midCol, midCol2);
        divide(midRow, midRow2, midCol, midCol2);
        divide(midRow2, er, midCol, midCol2);

        divide(sr, midRow, midCol2, ec);
        divide(midRow, midRow2, midCol2, ec);
        divide(midRow2, er, midCol2, ec);
    }

    private static boolean read(int sr, int er, int sc, int ec, int target) {
        int temp = 0;
        for (int r = sr; r < er; r++) {
            for (int c = sc; c < ec; c++) {
                if (nums[r][c] == target) temp++;
            }
        }
        int comp = (er - sr) * (er - sr);
        return temp == comp;
    }
}
