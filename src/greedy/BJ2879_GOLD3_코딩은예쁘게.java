package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2879_GOLD3_코딩은예쁘게 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] curr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            curr[i] = Integer.parseInt(st.nextToken());
        }

        int[] col = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            col[i] = Integer.parseInt(st.nextToken());
        }

        int[] intent = new int[n];
        for (int i = 0; i < n; i++) {
            intent[i] = curr[i] - col[i];
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (intent[i] == 0) {
                continue;
            }

            boolean isDelete = intent[i] > 0;
            while (intent[i] != 0) {
                int next = i + 1;
                int minValue = Math.abs(intent[i]);

                while (next < n && intent[next] != 0 && isDelete == intent[next] > 0) {
                    minValue = Math.min(minValue, Math.abs(intent[next++]));
                }

                for (int j = i; j < next; j++) {
                    if (isDelete) {
                        intent[j] -= minValue;
                    } else {
                        intent[j] += minValue;
                    }
                }

                answer += minValue;
            }
        }
        System.out.println(answer);
    }
}
