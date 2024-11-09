package string;
import java.util.*;

public class PG_LEVEL2_순위검색 {


    class Solution {
        public int[] solution(String[] info, String[] query) {
            int[] answer = {};
            HashMap<String, List<Integer>> db = new HashMap<>();
            for(String row: info) {
                set(row.split(" "), "", 0, db);
            }

            for(List<Integer> value: db.values()) {
                Collections.sort(value);
            }

            int[] result = new int[query.length];
            for(int i = 0 ; i < query.length ; i++) {
                String[] cols = query[i].split(" ");

                String key = getKey(cols);
                int score = Integer.valueOf(cols[7]);

                int temp = 0;
                if(db.containsKey(key)) {
                    List<Integer> arr = db.get(key);
                    int min = min(arr, score);
                    temp = arr.size() - min;
                }

                result[i] = temp;
            }
            return result;
        }

        public int min(List<Integer> arr, int target) {
            int start = 0;
            int end = arr.size() - 1;

            while(start <= end) {
                int mid = (start + end)/2;

                if(arr.get(mid) < target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            return start;
        }

        public String getKey(String[] cols) {
            return cols[0] + cols[2] + cols[4] + cols[6];
        }

        public void set(String[] cols, String temp, int dep, HashMap<String, List<Integer>> db) {
            if(dep == 4) {
                int score = Integer.parseInt(cols[4]);
                if(db.containsKey(temp)) {
                    var arr = db.get(temp);
                    arr.add(score);
                } else {
                    List<Integer> arr = new ArrayList<>();
                    arr.add(score);
                    db.put(temp, arr);
                }
                return;
            }

            for(int j = 0 ; j< 2 ; j++) {
                if(j == 0) {
                    set(cols, temp + "-", dep + 1, db);
                } else {
                    set(cols, temp + cols[dep], dep + 1, db);
                }
            }
        }
    }
}
