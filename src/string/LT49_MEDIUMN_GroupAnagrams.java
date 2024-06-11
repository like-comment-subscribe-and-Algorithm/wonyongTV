package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LT49_MEDIUMN_GroupAnagrams {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] ch = str.toCharArray();
                Arrays.sort(ch);
                String s = new String(ch);
                if (map.containsKey(s)) {
                    map.get(s).add(str);
                } else {
                    List<String> temp = new ArrayList<>();
                    temp.add(str);
                    map.put(s, temp);
                }
            }
            List<List<String>> answer = new ArrayList<>();
            for (List<String> values : map.values()) {
                answer.add(values);
            }
            return answer;
        }
    }
}
