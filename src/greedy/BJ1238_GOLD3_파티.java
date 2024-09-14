package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1238_GOLD3_파티 {
    static int n;
    static List<List<Site>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Site(e, t));
        }

        int answer = -1;
        for (int i = 1; i <= n; i++) {
            if (i == x) {
                continue;
            }
            int temp = calDist(i, x) + calDist(x, i);
            answer = Math.max(answer, temp);
        }
        System.out.println(answer);
    }

    public static int calDist(int start, int end) {
        PriorityQueue<Site> node = new PriorityQueue<>((n1, n2) -> n1.w - n2.w);
        node.add(new Site(start, 0));
        int[] max = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            max[i] = Integer.MAX_VALUE;
        }

        while (!node.isEmpty()) {
            Site s = node.poll();

            for (Site site : graph.get(s.next)) {
                int curr = s.w + site.w;
                if (max[site.next] > curr) {
                    max[site.next] = curr;
                    node.add(new Site(site.next, curr));
                }
            }
        }
        return max[end];
    }

    static class Site {
        int next;
        int w;

        public Site(int next, int w) {
            this.next = next;
            this.w = w;
        }
    }
}
