package greedy;

public class PG_LEVEL2_문자열압축 {
    class Solution {
        public int solution(String s) {
            int answer = Integer.MAX_VALUE;
            for (int i = 1; i <= s.length(); i++) {
                int temp = cal(i, s);

                answer = Math.min(answer, temp);
            }
            return answer;
        }

        public int cal(int size, String s) {
            if (size > s.length() - size) {
                return s.length();
            }

            StringBuilder sb = new StringBuilder();

            String target = s.substring(0, size);
            int count = 1;
            int idx = size;

            while (idx <= s.length() - size) {
                String next = s.substring(idx, idx + size);
                if (target.equals(next)) {
                    count += 1;
                } else {
                    if (count != 1) {
                        sb.append(count);
                    }
                    sb.append(target);
                    target = next;
                    count = 1;
                }

                idx += size;
            }

            if (idx < s.length()) {
                target += s.substring(idx, s.length());
            }

            if (count != 1) {
                sb.append(count);
            }
            sb.append(target);
            //System.out.println(size + " " + sb.toString() + " " + sb.length());
            return sb.length();
        }
    }
}
