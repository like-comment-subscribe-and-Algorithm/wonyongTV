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

    public static void main2(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int n = Integer.parseInt(br.readLine());

        int[][] nums = new int[s.length() + 1][26];

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < 26; j++) {
                nums[i][j] = nums[i - 1][j];
            }
            char c = s.charAt(i - 1);
            nums[i][c - 97] += 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char target = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(nums[end + 1][target - 97] - nums[start][target - 97]).append("\n");
        }

        System.out.println(sb);
    }
}
