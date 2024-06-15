package greedy;

public class LC_42_Hard_TrappingRainWater {
    class Solution {
        public int trap(int[] height) {
            int lhIdx = 0;
            int answer = 0;

            for(int i = 1 ; i < height.length ; i++) {
                if(height[lhIdx] <= height[i]) {
                    answer += calculate(lhIdx, i, height);
                    lhIdx = i;
                }
            }

            while(lhIdx < height.length-1) {
                int temp = 0;
                int rhIdx = 0;
                for(int j = lhIdx+1; j<height.length ; j++) {
                    if(temp <= height[j]) {
                        temp = height[j];
                        rhIdx = j;
                    }
                }
                answer += calculate(lhIdx, rhIdx, height);
                lhIdx = rhIdx;
            }
            return answer;
        }

        private int calculate(int lhIdx, int rhIdx, int[] height) {
            if(height[lhIdx] == 0) return 0;
            if(lhIdx == rhIdx-1) return 0;
            int h = Math.min(height[rhIdx], height[lhIdx]);
            int w = rhIdx - lhIdx - 1;
            int temp = w*h;

            while(++lhIdx <= --rhIdx) {
                if(lhIdx == rhIdx) temp -= height[lhIdx];
                else temp = temp - height[lhIdx] - height[rhIdx];
            }
            return temp;
        }
    }
}
