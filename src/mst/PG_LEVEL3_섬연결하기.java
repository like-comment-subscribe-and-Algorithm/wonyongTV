package mst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PG_LEVEL3_섬연결하기 {
    public int solution(int n, int[][] costs) {
        List<Path> paths = new ArrayList<>();
        for (int[] cost : costs) {
            paths.add(new Path(cost[0], cost[1], cost[2]));
        }
        Collections.sort(paths);

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        int answer = 0;
        for (Path path : paths) {
            if (!isDiff(path.start, path.end, parent)) continue;
            answer += path.value;
        }
        return answer;
    }

    public boolean isDiff(int a, int b, int[] parent) {
        int pA = searchParent(a, parent);
        int pB = searchParent(b, parent);
        if (pA == pB) return false;
        parent[pA] = pB;
        return true;
    }

    public int searchParent(int a, int[] parent) {
        if (a == parent[a]) return a;
        return parent[a] = searchParent(parent[a], parent);
    }
}

class Path implements Comparable<Path> {
    int start;
    int end;
    int value;

    public Path(int start, int end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }

    @Override
    public int compareTo(Path o) {
        return this.value - o.value;
    }
}
