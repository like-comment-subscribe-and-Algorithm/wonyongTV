package stack_que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ2493_GOLD5_탑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        Stack<Top> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && stack.peek().value < num) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                sb.append("0").append(" ");
            } else {
                sb.append(stack.peek().i + 1).append(" ");
            }

            stack.add(new Top(num, i));
        }

        System.out.println(sb);
    }

    static class Top {
        int value;
        int i;

        public Top(int value, int i) {
            this.value = value;
            this.i = i;
        }
    }
}
