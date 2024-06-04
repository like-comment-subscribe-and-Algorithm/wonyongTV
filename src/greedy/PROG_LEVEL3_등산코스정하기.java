package greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PROG_LEVEL3_등산코스정하기 {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        List<List<Site4>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] path : paths) {
            graph.get(path[0]).add(new Site4(path[1], path[2]));
            graph.get(path[1]).add(new Site4(path[0], path[2]));
        }

        PriorityQueue<Site4> que = new PriorityQueue<>();
        boolean[] visited = new boolean[n + 1];
        for (int g : gates) {
            que.add(new Site4(g, 0));
        }

        boolean[] goals = new boolean[n + 1];
        for (int s : summits) {
            goals[s] = true;
        }

        PriorityQueue<Site4> answer = new PriorityQueue<>();
        while (!que.isEmpty()) {
            Site4 site = que.poll();
            if (visited[site.idx]) continue;
            visited[site.idx] = true;
            if (goals[site.idx]) {
                answer.add(new Site4(site.idx, site.w));
                continue;
            }
            for (Site4 s : graph.get(site.idx)) {
                int w = Math.max(s.w, site.w);
                que.add(new Site4(s.idx, w));
            }
        }

        Site4 ans = answer.poll();
        return new int[]{ans.idx, ans.w};
    }
}

class Site4 implements Comparable<Site4> {
    int idx;
    int w;

    Site4(int idx, int w) {
        this.idx = idx;
        this.w = w;
    }

    public int compareTo(Site4 o) {
        if (this.w == o.w) return this.idx - o.idx;
        return this.w - o.w;
    }
}