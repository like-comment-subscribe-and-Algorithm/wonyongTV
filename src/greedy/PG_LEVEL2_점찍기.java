package greedy;

public class PG_LEVEL2_점찍기 {

    /*
    *
        피타고라스의 정리
        각 x좌표에 대해 최대 y좌표값을 구한다. (O(N))
        [원의 방정식]
        x^2 + y^2 <= d^2 인 (x,y) 조합 찾기 (단, x>=0, y>=0)

        반지름이 d인 원의 1사분면에 포함할 수 있는 좌표를 구한다.

        k=2, d=4
        0 -> temp = 4
        2 -> temp = 3
        4 -> temp = 0

        1 ~ temp 까지 가능한 y 좌표이기 때문에, k 만큼 나눠준다.
        또한 0을 포함할 수 있기 때문에 +1을 해준다.
    * */
    class Solution {
        public long solution(int k, int d) {
            long answer = 0;
            for(int r = 0 ; r <= d ; r += k) {
                int temp = (int)Math.sqrt((long)d*d - (long)r*r);
                answer += (temp/k)+1;
            }
            return answer;
        }
    }
}
