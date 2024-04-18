package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2138_GOLD5_전기와스위치 {
    private static int answer = Integer.MAX_VALUE;

    /*
     * 0 1 2 3 이 있을 때, 0번째를 고정한다면 0을 변경할 수 있는 경우는 1밖에 없다.
     * 따라서 첫 0을 고정했을 때, 안했을 때를 고정한 다음
     * 1부터 n까지 반복하면서 이전의 값이 정답과 다를 경우 현재 위치에서 스위치를 누를지 안누를지 결정한다.
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String temp = br.readLine();
        String ans = br.readLine();

        boolean[] t1 = new boolean[temp.length()];
        boolean[] t2 = new boolean[temp.length()];
        boolean[] a = new boolean[ans.length()];
        for (int i = 0; i < n; i++) {
            if (temp.charAt(i) == '1') t1[i] = true;
            if (temp.charAt(i) == '1') t2[i] = true;
            if (ans.charAt(i) == '1') a[i] = true;
        }

        solve(n, a, t1, 0);


        t2[0] = !t2[0];
        t2[1] = !t2[1];
        solve(n, a, t2, 1);

        if (answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }

    private static void solve(int n, boolean[] ans, boolean[] temp, int count) {
        for (int i = 1; i < n; i++) {
            if (ans[i - 1] == temp[i - 1]) continue;
            temp[i - 1] = !temp[i - 1];
            temp[i] = !temp[i];
            if (i + 1 < n) temp[i + 1] = !temp[i + 1];
            count += 1;
        }

        boolean isAns = true;
        for (int i = 0; i < n; i++) {
            if (ans[i] == temp[i]) continue;
            isAns = false;
            break;
        }
        if (isAns) answer = Math.min(answer, count);
    }
}
