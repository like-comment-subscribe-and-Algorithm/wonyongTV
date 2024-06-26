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

    class Sol2 {
        static HashMap<String, String> map;
        static int l;
        static int c;
        static StringBuilder sb = new StringBuilder();
        static String[] words;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            map = new HashMap<>();
            map.put("a", "");
            map.put("e", "");
            map.put("i", "");
            map.put("o", "");
            map.put("u", "");

            l = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            words = br.readLine().split(" ");
            Arrays.sort(words);
            dfs(new String[l], 0, 0, 0, 0);
            System.out.println(sb);
        }

        private static void dfs(String[] temp, int nextIdx, int idx, int jCnt, int mCnt) {
            if (idx == l) {
                if (jCnt < 2 || mCnt < 1) return;
                sb.append(String.join("", temp)).append("\n");
                return;
            }

            for (int i = nextIdx; i < words.length; i++) {
                String word = words[i];
                temp[idx] = word;
                if (map.containsKey(word)) dfs(temp, i + 1, idx + 1, jCnt, mCnt + 1);
                else dfs(temp, i + 1, idx + 1, jCnt + 1, mCnt);
            }
        }
    }
}
