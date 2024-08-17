package back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ6603_SILVER2_로또 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            if (k == 0) {
                break;
            }
            int s = st.countTokens();
            int[] nums = new int[s];
            for (int i = 0; i < s; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            comb(0, 0, s, sb, new int[6], nums);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void comb(int tempIdx, int nextIdx, int s, StringBuilder sb, int[] temp, int[] nums) {
        if (tempIdx == 6) {
            for (int n : temp) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = nextIdx; i < s; i++) {
            temp[tempIdx] = nums[i];
            comb(tempIdx + 1, i + 1, s, sb, temp, nums);
        }
    }
}
