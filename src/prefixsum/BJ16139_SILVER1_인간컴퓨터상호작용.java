package prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16139_SILVER1_인간컴퓨터상호작용 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String strings = br.readLine();
        int[][] arrs = new int[strings.length() + 1][26];

        for (int i = 1; i <= strings.length(); i++) {
            arrs[i][strings.charAt(i - 1) - 'a'] += 1;
            for (int j = 0; j < 26; j++) {
                arrs[i][j] += arrs[i - 1][j];
            }
        }

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken()) + 1;

            int x = arrs[l][a.charAt(0) - 'a'];
            int y = arrs[r][a.charAt(0) - 'a'];

            sb.append(y - x).append("\n");
        }
        System.out.println(sb);
    }
}
