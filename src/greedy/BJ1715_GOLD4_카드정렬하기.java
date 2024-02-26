package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ1715_GOLD4_카드정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        long answer = 0;
        PriorityQueue<Long> que = new PriorityQueue<>();
        for (long num : nums) {
            que.add(num);
        }

        while (que.size() != 1) {
            long a = que.poll();
            long b = que.poll();
            long temp = a + b;
            answer += temp;
            que.add(temp);
        }
        System.out.println(answer);
    }
}
