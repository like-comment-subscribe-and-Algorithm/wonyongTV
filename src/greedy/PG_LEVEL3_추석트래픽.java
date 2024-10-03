package greedy;

public class PG_LEVEL3_추석트래픽 {
    class Solution {
        public int solution(String[] lines) {
            if(lines.length == 1) return 1;

            int size = lines.length;
            int[] ends = new int[size];
            int[] starts = new int[size];

            for(int i = 0 ; i < size ; i++) {
                String[] split = lines[i].split(" ");
                String e = split[1];

                int hour = Integer.parseInt(e.substring(0,2)) * 3600 * 1000;
                int min = Integer.parseInt(e.substring(3,5)) * 60 * 1000;
                int sec = Integer.parseInt(e.substring(6,8)) * 1000;
                int milie = Integer.parseInt(e.substring(9,12));

                ends[i] = hour + min + sec + milie;

                String[] d = split[2].substring(0, split[2].length() - 1).split("\\.");
                int temp = Integer.parseInt(d[0]) * 1000;
                if(d.length > 1) temp += Integer.parseInt(d[1]);

                starts[i] = (ends[i] - temp) + 1;
            }

            /*
            * end time 은 정렬돼 있음을 보장한다.
            * */
            int answer = 0;
            for(int i = 0 ; i < size ; i++) {
                int et = ends[i];
                int cnt = 0;
                for(int j = i ; j < size ; j++) {
                    if(et + 1000 > starts[j]) cnt++;
                }
                answer = Math.max(answer , cnt);
            }

            return answer;
        }
    }


}
