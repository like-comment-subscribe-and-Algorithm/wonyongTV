package back_tracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ1759_GOLD5_암호만들기 {
    private static String[] strs;
    private static int l;
    private static int c;
    private static StringBuilder sb = new StringBuilder();
    private static HashMap<String, Boolean> map = new HashMap<>() {{
        put("a", true);
        put("e", true);
        put("i", true);
        put("o", true);
        put("u", true);
    }};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        strs = br.readLine().split(" ");
        Arrays.sort(strs);

        dfs(new String[l], 0, 0);
        System.out.println(sb);
    }

    private static void dfs(String[] str, int start, int index) {
        if (index == l) {
            if (!isValid(str)) return;
            for (String s : str) sb.append(s);
            sb.append("\n");
            return;
        }

        for (int i = start; i < c; i++) {
            str[index] = strs[i];
            dfs(str, i + 1, index + 1);
        }
    }

    private static boolean isValid(String[] str) {
        int c1 = 0;
        int c2 = 0;
        for (String s : str) {
            Boolean v = map.get(s);
            if (v == null) c1++;
            else c2++;
        }
        return c1 >= 2 && c2 >= 1;
    }
}
