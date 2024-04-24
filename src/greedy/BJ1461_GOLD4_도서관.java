package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1461_GOLD4_도서관 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> minus = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> plus = new PriorityQueue<>(Comparator.reverseOrder());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num < 0) minus.add(Math.abs(num));
            else plus.add(num);
        }

        int mValue = 0;
        if (plus.isEmpty()) {
            mValue = minus.peek();
        } else if (minus.isEmpty()) {
            mValue = plus.peek();
        } else {
            mValue = Math.max(minus.peek(), plus.peek());
        }

        int answer = 0;
        while (!minus.isEmpty()) {
            answer += Math.abs(minus.poll()) * 2;
            int idx = 1;
            while (idx++ < m) {
                minus.poll();
            }
        }

        while (!plus.isEmpty()) {
            answer += Math.abs(plus.poll()) * 2;
            int idx = 1;
            while (idx++ < m) {
                plus.poll();
            }
        }

        System.out.println(answer - mValue);
    }
}
