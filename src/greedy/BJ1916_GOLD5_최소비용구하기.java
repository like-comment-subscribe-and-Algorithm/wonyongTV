package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1916_GOLD5_최소비용구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<List<Load>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Load(e, w));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        PriorityQueue<Load> que = new PriorityQueue<>();
        int[] dist = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        que.add(new Load(start, 0));
        dist[start] = 0;

        while (!que.isEmpty()) {
            Load curr = que.poll();
            if (curr.next == end) {
                break;
            }
            for (Load load : graph.get(curr.next)) {
                int temp = curr.money + load.money;
                if (dist[load.next] > temp) {
                    dist[load.next] = temp;
                    que.add(new Load(load.next, temp));
                }
            }
        }

        System.out.println(dist[end]);
    }
}

class Load implements Comparable<Load> {
    int next;
    int money;

    public Load(int next, int money) {
        this.next = next;
        this.money = money;
    }

    @Override
    public int compareTo(Load o) {
        return this.money - o.money;
    }
}
