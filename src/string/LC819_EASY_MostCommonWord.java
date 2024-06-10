package string;

import java.util.TreeMap;

public class LC819_EASY_MostCommonWord {
    class Solution {
        public String mostCommonWord(String paragraph, String[] banned) {
            String[] words = paragraph.toLowerCase().split("\\W+");

            TreeMap<String, Integer> ban = new TreeMap<>();
            for (String b : banned) {
                ban.put(b, 1);
            }

            TreeMap<String, Integer> map = new TreeMap<>();
            for (String word : words) {
                if (ban.containsKey(word)) {
                    continue;
                }
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
            }

            int temp = -1;
            String answer = "";
            for (String word : map.keySet()) {
                if (map.get(word) <= temp) {
                    continue;
                }
                temp = map.get(word);
                answer = word;
            }
            return answer;
        }
    }
}
