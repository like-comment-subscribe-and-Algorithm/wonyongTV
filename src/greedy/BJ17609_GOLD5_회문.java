package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ17609_GOLD5_회문 {
    // ex) xyyyyxy
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            sb.append(isAns(word, false, 0, word.length() - 1)).append("\n");
        }
        System.out.println(sb);
    }

    private static int isAns(String word, boolean isDel, int start, int end) {
        while (start < end) {
            if (word.charAt(start) == word.charAt(end)) {
                start++;
                end--;
                continue;
            }
            if (isDel) return 2;
            int a1 = isAns(word, true, start + 1, end);
            if (a1 != 2) return a1;
            int a2 = isAns(word, true, start, end - 1);
            return a2;
        }
        if (isDel) return 1;
        else return 0;
    }
}
