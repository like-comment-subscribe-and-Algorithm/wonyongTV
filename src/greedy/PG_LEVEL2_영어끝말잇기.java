package greedy;

import java.util.HashSet;
import java.util.Set;

public class PG_LEVEL2_영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        char[] last = new char[n];
        Set<String> dup = new HashSet<>();

        last[0] = words[0].charAt(words[0].length() - 1);
        int idx = 1;
        dup.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            String word = words[i];

            int before = dup.size();
            dup.add(word);
            int after = dup.size();
            if (before + 1 != after) {
                return new int[]{idx + 1, i / n + 1};
            }

            if (last[(idx + n - 1) % n] == word.charAt(0)) {
                last[idx] = word.charAt(word.length() - 1);
            } else {
                return new int[]{idx + 1, i / n + 1};
            }
            idx = (idx + 1) % n;
        }

        return new int[]{0, 0};
    }
}
