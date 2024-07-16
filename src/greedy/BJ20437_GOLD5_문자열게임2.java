package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BJ20437_GOLD5_문자열게임2 {
    /*
    * 문제 : 3번과정과 4번 과정의 답을 출력하는 것
    * 어떤 문자를 정확히 K개를 포함하는 가장 짧은 연속 문자열의 길이를 구한다. <- K개를 포함하며 양끝이 해당 단어인 길이
    * 어떤 문자를 정확히 K개를 포함하고, 문자열의 첫 번째와 마지막 글자가 해당 문자로 같은 가장 긴 연속 문자열의 길이를 구한다. <- 최대값
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String str = br.readLine();
            int size = Integer.parseInt(br.readLine());
            solve(str, size, sb);
        }
        System.out.println(sb);
    }

    /*
    * a~z 까지 리스트를 만들어서 str을 순회한다.
    * 순회하며 문자열의 index를 list에 add한다
    *
    * 다시 순회하며 해당 문자가 k개 있는지 확인하고, 없다면 continue
    * 있다면 마지막 값을 구하고, 첫번째 값을 poll 해서 길이를 구한다.
    * */
    public static void solve(String str, int size, StringBuilder sb) {
        List<Queue<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add(new LinkedList<>());
        }
        for (int i = 0; i < str.length(); i++) {
            list.get(str.charAt(i) - 'a').add(i);
        }
        int max = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            if (list.get(index).size() < size) {
                continue;
            }

            int idx = 0;
            int last = 0;
            for (int num : list.get(index)) {
                if (idx == size) {
                    break;
                }
                last = num;
                idx++;
            }
            int first = list.get(index).poll();
            max = Math.max(max, last - first + 1);
            min = Math.min(min, last - first + 1);
        }
        if (max != -1) {
            sb.append(min).append(" ").append(max).append("\n");
        } else {
            sb.append(max).append("\n");
        }
    }
}
