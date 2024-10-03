package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ11779_GOLD3_최소비용구하기2 {

    class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            int[] weight = new int[n + 1];
            List<List<Site>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
                weight[i] = Integer.MAX_VALUE;
            }

            int m = Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                graph.get(s).add(new Site(e, w, new ArrayList<>()));
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            boolean[] visited = new boolean[n + 1];
            weight[start] = 0;
            PriorityQueue<Site> que = new PriorityQueue<>((s1, s2) -> s1.w - s2.w);

            StringBuilder sb = new StringBuilder();
            List<Integer> vis = new ArrayList<>();
            vis.add(start);
            que.add(new Site(start, 0, vis));
            while (!que.isEmpty()) {
                Site site = que.poll();
                if (site.next == end) {
                    sb.append(weight[site.next]).append("\n").append(site.v.size()).append("\n");
                    for (int v : site.v) {
                        sb.append(v).append(" ");
                    }
                    break;
                }
                if (visited[site.next]) {
                    continue;
                }
                visited[site.next] = true;

                for (Site s : graph.get(site.next)) {
                    int nr = site.w + s.w;
                    if (weight[s.next] > nr) {
                        weight[s.next] = nr;
                        List<Integer> nv = new ArrayList<>(site.v);
                        nv.add(s.next);
                        que.add(new Site(s.next, nr, nv));
                    }
                }
            }
            System.out.println(sb);

        }

        static class Site {
            int next;
            int w;
            List<Integer> v;

            public Site(int next, int w, List<Integer> v) {
                this.next = next;
                this.w = w;
                this.v = v;
            }
        }
    }

}
