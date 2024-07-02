package stack_que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ2504_GOLD5_괄호의값 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        int temp = 1;
        int answer = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '[' || c == '(') {
                if (c == '[') {
                    temp *= 3;
                } else {
                    temp *= 2;
                }
                stack.add(c);
                continue;
            }

            if (!stack.isEmpty() && ((c == ']' && stack.peek() == '[') || (c == ')' && stack.peek() == '('))) {
                if (str.charAt(i - 1) != ']' && str.charAt(i - 1) != ')') {
                    answer += temp;
                }
                if (c == ']') {
                    temp /= 3;
                } else {
                    temp /= 2;
                }
                stack.pop();
            } else {
                answer = 0;
                break;
            }
        }
        if (!stack.isEmpty()) {
            answer = 0;
        }
        System.out.println(answer);
    }
}
