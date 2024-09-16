package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ10282_GOLD4_해킹 {
    // 컴퓨터의 수 n * 최대 초 s = 10_000_000, 불안해서 0 하나 더 넣음
    static int MAX = 1_000_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            List<List<Computer>> graph = new ArrayList<>();
            int[] min = new int[n + 1];
            for (int j = 0; j <= n; j++) {
                graph.add(new ArrayList<>());
                min[j] = MAX;
            }

            for (int j = 0; j < d; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                graph.get(b).add(new Computer(a, s));
            }

            PriorityQueue<Computer> pq = new PriorityQueue<>((c1, c2) -> c1.time - c2.time);
            pq.add(new Computer(c, 0));
            min[c] = 0;
            /*
             * visited가 없으면 메모리 초과가 발생한다.
             * for 문 내에서 visited를 하지 않은 이유는 이후에 더 적은 값이 들어올 수 있기 때문이다.
             * 따라서 poll 한 다음에 visited를 검사하고, 갱신한다.
             *
             * */
            boolean[] visited = new boolean[n + 1];
            while (!pq.isEmpty()) {
                Computer computer = pq.poll();
                if (visited[computer.num]) {
                    continue;
                }
                visited[computer.num] = true;
                for (Computer com : graph.get(computer.num)) {
                    int curr = computer.time + com.time;
                    if (curr > min[com.num]) {
                        continue;
                    }
                    min[com.num] = curr;
                    pq.add(new Computer(com.num, curr));
                }
            }

            // 정답을 구한다.
            int a1 = 0;
            int a2 = 0;
            for (int j = 1; j <= n; j++) {
                if (min[j] == MAX) {
                    continue;
                }
                a1++;
                a2 = Math.max(a2, min[j]);
            }
            sb.append(a1).append(" ").append(a2).append("\n");
        }
        System.out.println(sb);
    }

    static class Computer {
        int num;
        int time;

        public Computer(int num, int time) {
            this.num = num;
            this.time = time;
        }
    }
}
