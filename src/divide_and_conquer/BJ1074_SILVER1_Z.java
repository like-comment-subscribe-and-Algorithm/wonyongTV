package divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1074_SILVER1_Z {
    /*
    * 시간 제한 : 0.5초 , 10^4?
    *
    * 재귀를 통해서 r,c 에 해당하는 사분면을 찾아서 값을 출력한다.
    * */
    private static int r;
    private static int c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int max = (int) Math.pow(2, n);
        divide(0, max, 0, max, n, 0);
    }

    private static void divide(int sr, int er, int sc, int ec, int n, int answer) {
        if (n == 0) {
            System.out.println(answer);
            return;
        }
        int max = (int) Math.pow(2, n);
        int num = (max * max) / 4;
        int midRow = (sr + er) / 2;
        int midCol = (sc + ec) / 2;
        if (r >= sr && r < midRow && c >= sc && c < midCol) divide(sr, midRow, sc, midCol, n - 1, answer);
        else if (r >= sr && r < midRow && c >= midCol && c < ec) divide(sr, midRow, midCol, ec, n - 1, answer + num);
        else if (r >= midRow && r < er && c >= sc && c < midCol) divide(midRow, er, sc, midCol, n - 1, answer + num * 2);
        else if (r >= midRow && r < er && c >= midCol && c < ec) divide(midRow, er, midCol, ec, n - 1, answer + num * 3);
    }
}
