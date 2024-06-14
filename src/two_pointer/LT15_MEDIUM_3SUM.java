package two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LT15_MEDIUM_3SUM {

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> answer = new ArrayList<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                // 이전에 한번 한 기준은 스킵한다.
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                int start = i + 1;
                int end = nums.length - 1;
                while (start < end) {
                    if (nums[i] + nums[start] + nums[end] == 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[start]);
                        temp.add(nums[end]);
                        answer.add(temp);

                        while (start < end && nums[start] == nums[start + 1]) {
                            start++;
                        }
                        while (start < end && nums[end] == nums[end - 1]) {
                            end--;
                        }
                        start++;
                        end--;
                    } else if (nums[i] + nums[start] + nums[end] < 0) {
                        start++;
                    } else if (nums[i] + nums[start] + nums[end] > 0) {
                        end--;
                    }
                }
            }

            return answer;
        }
    }

}
