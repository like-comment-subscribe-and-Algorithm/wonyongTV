package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2170_GOLD5_선긋기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] pos = new int[n][];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int[] temp = new int[2];
            temp[0] = s;
            temp[1] = e;
            pos[i] = temp;
        }
        Arrays.sort(pos, (a1, a2) -> {
            if (a1[0] == a2[0]) return a1[1] - a2[1];
            return a1[0] - a2[0];
        });

        int start = pos[0][0];
        int end = pos[0][1];
        int answer = Math.abs(end - start);
        for (int i = 1; i < n; i++) {
            int s = pos[i][0];
            int e = pos[i][1];
            if (start <= s && end >= e) continue;
            else if (s > end) answer += Math.abs(e - s);
            else {
                answer += Math.abs(e - end);
            }

            start = s;
            end = e;
        }
        System.out.println(answer);
    }
}
