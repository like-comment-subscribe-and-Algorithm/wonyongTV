package linear_data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1966_SILVER3_프린터큐 {
    /*
    *
    * 1. 값을 입력 받을 때, <index, weight> 쌍을 que에 넣고, 동시에 weight 를 우선순위 큐에 넣는다.
    * 2. m 값이 나올 때까지 반복한다.
    *   1. 우선 순위 큐의 peek 값이 que 의 peek 값이 아니라면 해당 값을 뒤로 보낸다.
    *   2. 맞다면 우선 순위 큐, 큐의 값을 poll 한 뒤, 현재 값의 index 가 m 값과 비교한다.
    *   3. m 값과 같다면 break 후 값을 저장하고, 아니라면 다시 1-2 과정을 반복한다.
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Queue<Docs> docs = new LinkedList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int w = Integer.parseInt(st.nextToken());
                pq.add(w);
                docs.add(new Docs(j, w));
            }

            int answer = 1;
            while (!pq.isEmpty()) {
                while (pq.peek() != docs.peek().weight) {
                    docs.add(docs.poll());
                }
                if (docs.peek().index == m) break;
                pq.poll();
                docs.poll();
                answer++;
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}

class Docs {
    int index;
    int weight;

    public Docs(int index, int weight) {
        this.index = index;
        this.weight = weight;
    }
}
