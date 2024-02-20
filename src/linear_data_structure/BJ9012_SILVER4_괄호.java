package linear_data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ9012_SILVER4_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");

            Stack<String> stack = new Stack<>();
            boolean isAns = true;
            for (String s : str) {
                if (s.equals("(")) stack.add(s);
                else {
                    if (stack.isEmpty()) {
                        isAns = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if (!isAns || !stack.isEmpty()) sb.append("NO").append("\n");
            else sb.append("YES").append("\n");
        }
        System.out.println(sb);
    }
}
