package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1543_SILVER5_문서검색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String docs = br.readLine();
        String word = br.readLine();

        int answer = 0;
        for (int i = 0; i < docs.length(); i++) {
            if (docs.charAt(i) != word.charAt(0)) continue;

            boolean isCount = true;
            int temp = i + 1;
            for (int n = 1; n < word.length(); n++) {
                if (temp >= docs.length()) {
                    isCount = false;
                    break;
                }
                if (docs.charAt(temp++) == word.charAt(n)) continue;
                isCount = false;
                break;
            }
            if (isCount) {
                answer++;
                i += word.length() - 1;
            }
        }
        System.out.println(answer);
    }
}
