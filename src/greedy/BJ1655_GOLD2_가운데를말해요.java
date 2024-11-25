package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ1655_GOLD2_가운데를말해요 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>((n1, n2) -> n2 - n1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (max.isEmpty()) {
                max.add(num);
            } else if (max.peek() > num) {
                max.add(num);
            } else if (!min.isEmpty() && num <= min.peek()) {
                max.add(num);
            } else {
                min.add(num);
            }
            while (max.size() - min.size() >= 1) {
                min.add(max.poll());
            }
            while (min.size() - max.size() >= 1) {
                max.add(min.poll());
            }

            sb.append(max.peek()).append("\n");
        }
        System.out.println(sb);
    }
}
