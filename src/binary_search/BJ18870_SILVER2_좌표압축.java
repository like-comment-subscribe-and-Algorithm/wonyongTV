package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ18870_SILVER2_좌표압축 {
    /*
     * 시간 제한 : 2초 , 2*10^8
     * n : 1,000,000 , 10^6
     * 시간 복잡도 <= Nlog(N)
     *
     * 1. set 자료구조를 통해서 중복된 값이 없는 리스트를 하나 만든 후 정렬한다.
     * 2. nums를 순회하면서 이분 탐색을 통해 중복 값이 없는 정렬 된 리스트 내에 몇 번째 인덱스에 있는지 확인한다.
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        List<Integer> temp = new ArrayList<>(set);
        Collections.sort(temp);

        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            int min = 0;
            int max = temp.size();
            while (min <= max) {
                int mid = (min + max) / 2;
                int value = temp.get(mid);
                if (value == num) {
                    sb.append(mid).append(" ");
                    break;
                } else if (value < num) min = mid;
                else max = mid;
            }
        }
        System.out.println(sb);
    }
}
