package greedy;

public class PG_LEVEL2_마법의엘리베이터 {
    class Solution {
        public int solution(int storey) {
            int answer = 0;
            while(storey != 0) {
                int d = storey % 10;
                String command = div(d);
                if(command.equals("DEC")) {
                    answer += d;
                } else if(command.equals("INC")) {
                    answer += (10-d);
                    storey += 10;
                } else {
                    boolean isUp = isUp(storey);
                    if(isUp) {
                        answer += (10-d);
                        storey += 10;
                    } else {
                        answer += d;
                    }
                }

                storey /= 10;
            }
            return answer;
        }

        public boolean isUp(int v) {
            while(v != 0) {
                v/= 10;
                int d = v%10;
                if(d<5) return false;
                if(d>=5) return true;
            }
            return true;
        }

        public String div(int v) {
            if(v < 5) return "DEC";
            if(v > 5) return "INC";
            return "CAL";
        }
    }
}
