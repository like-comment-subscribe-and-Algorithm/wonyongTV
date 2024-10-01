package greedy;

public class PG_LEVEL2_택배배달과수거하기 {
    class Solution {
        public long solution(int cap, int n, int[] deliveries, int[] pickups) {
            long answer = 0;

            int last = n-1;
            while(true) {
                while(last >= 0) {
                    if(deliveries[last] != 0 || pickups[last] != 0) {
                        break;
                    }
                    last--;
                }

                if(last == -1) break;

                answer += 2*(last + 1);
                cal(deliveries, pickups, last, cap);
            }

            return answer;
        }


        void cal(int[] deliveries, int[] pickups, int last, int cap) {
            int cnt1 = cap;
            int cnt2 = cap;
            for(int i = last ; i > -1 ; i--) {
                if(cnt1 == 0 && cnt2 == 0) break;
                if(cnt1 != 0 && cnt1 >= deliveries[i]) {
                    cnt1 -= deliveries[i];
                    deliveries[i] = 0;
                } else if(cnt1 != 0 && cnt1 < deliveries[i]) {
                    deliveries[i] -= cnt1;
                    cnt1 = 0;
                }

                if(cnt2 != 0 && cnt2 >= pickups[i]) {
                    cnt2 -= pickups[i];
                    pickups[i] = 0;
                } else if(cnt2 != 0 && cnt2 < pickups[i]) {
                    pickups[i] -= cnt2;
                    cnt2 = 0;
                }
            }
        }
    }
}
