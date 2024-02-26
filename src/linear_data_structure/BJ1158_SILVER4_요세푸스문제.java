package linear_data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1158_SILVER4_요세푸스문제 {
    /*
     * 시간 제한 : 2초 , 2*10^8
     * N = 5*10^3 ,
     * 최대 O(n^2)
     *
     * 1. 1부터 n까지 순열을 만든다.
     * 2-1. k번 째일 때 값을 리스트에 add 한다.
     * 2-2. k번 째가 아닐 땐 poll 한 값을 add 한다.
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            que.add(i);
        }

        List<Integer> answer = new ArrayList<>();
        int temp = 1;
        while (!que.isEmpty()) {
            if (temp != k) {
                que.add(que.poll());
                temp++;
                continue;
            }
            int t = que.poll();
            answer.add(t);
            temp = 1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < answer.size(); i++) {
            sb.append(answer.get(i));
            if (i != answer.size() - 1) sb.append(", ");
        }
        sb.append(">");
        System.out.println(sb);
    }
}
