package back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2661_GOLD4_좋은수열 {
    private static int n;
    private static final int[] nums = {1, 2, 3};
    private static boolean isAns = false;

    /*
     * 1. index == n 까지 오는 제일 첫번째 수를 출력한다.
     * 2. temp 내에 index 에 1,2,3 순으로 값을 넣고, 유효한 값인지 확인한다.
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dfs(new int[n], 0);
    }

    private static void dfs(int[] temp, int index) {
        if (isAns) return;
        if (index == n) {
            StringBuilder answer = new StringBuilder();
            for (int t : temp) answer.append(t);
            System.out.println(answer);
            isAns = true;
            return;
        }

        for (int num : nums) {
            temp[index] = num;
            if (isValid2(temp, index)) dfs(temp, index + 1);
        }
    }

    private static boolean isValid2(int[] temp, int index) {
        int count = (index + 1) / 2;
        for (int i = 1; i <= count; i++) {
            String c1 = "";
            String c2 = "";

            for (int j = index; j > index - i; j--) {
                c1 += temp[j];
            }
            for (int j = index - i; j > index - i - i; j--) {
                c2 += temp[j];
            }
            if (c1.equals(c2)) return false;
        }
        return true;
    }
}
