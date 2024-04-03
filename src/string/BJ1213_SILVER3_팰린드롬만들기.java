package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1213_SILVER3_팰린드롬만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] nums = new int['Z' - 'A' + 1];

        for (int i = 0; i < str.length(); i++) {
            nums[str.charAt(i) - 'A']++;
        }

        int odd = 0;
        char mid = 'A';
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                odd++;
                mid = (char) ('A' + i);
            }
        }
        if (odd > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        StringBuilder start = new StringBuilder();
        StringBuilder end = new StringBuilder();

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i] / 2; j++) {
                start.append((char) ('A' + i));
                end.insert(0, (char) ('A' + i));
            }
        }
        StringBuilder answer = new StringBuilder();
        if (odd == 1) answer.append(start).append(mid).append(end);
        else answer.append(start).append(end);

        System.out.println(answer);
    }
}
