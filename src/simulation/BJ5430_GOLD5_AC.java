package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BJ5430_GOLD5_AC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String[] commands = br.readLine().split("");
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            String[] nums = str.substring(1, str.length() - 1).split(",");
            Deque<Integer> que = new ArrayDeque<>();

            for (String num : nums) {
                if (num.isEmpty()) {
                    continue;
                }
                que.addLast(Integer.parseInt(num));
            }

            boolean isFail = false;
            boolean isR = false;
            for (int c = 0; c < commands.length; c++) {
                if (commands[c].equals("R") && c + 1 < commands.length && commands[c + 1].equals("R")) {
                    c++;
                    continue;
                }
                if (commands[c].equals("R")) {
                    isR = !isR;
                    continue;
                }

                if (!d(que, isR)) {
                    isFail = true;
                    break;
                }
            }

            if (isFail) {
                sb.append("error").append("\n");
            } else {
                addAnswer(sb, que, isR);
            }
        }
        System.out.println(sb);
    }

    public static void addAnswer(StringBuilder sb, Deque<Integer> que, boolean isR) {
        sb.append("[");
        while (!que.isEmpty()) {
            if (isR) {
                sb.append(que.pollLast());
            } else {
                sb.append(que.pollFirst());
            }
            if (!que.isEmpty()) {
                sb.append(",");
            }
        }
        sb.append("]").append("\n");
    }

    public static boolean d(Deque<Integer> que, boolean isR) {
        if (que.isEmpty()) {
            return false;
        }
        if (isR) {
            que.pollLast();
        } else {
            que.pollFirst();
        }
        return true;
    }
}
