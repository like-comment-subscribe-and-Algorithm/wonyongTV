package union_find;

import java.util.HashSet;
import java.util.Set;

public class PG_LEVEL3_네트워크 {
    int[] parent;
    public int solution(int n, int[][] computers) {
        parent = new int[n+1];
        for(int i = 1 ; i <= n ; i++) {
            parent[i] = i;
        }
        for(int j = 0 ; j< n ; j++) {
            for(int i = 0 ; i < n ; i++) {
                if(computers[j][i] == 0 || i==j) continue;
                union(j+1, i+1);
            }
        }
        for(int i = 1 ; i <= n ; i++) {
            find(i);
        }
        Set<Integer> networks = new HashSet<>();
        for(int i = 1 ; i <= n ; i++) {
            networks.add(parent[i]);
        }

        return networks.size();
    }

    int find(int child) {
        if(parent[child] == child) {
            return child;
        }
        return parent[child] = find(parent[child]);
    }

    void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if(pa > pb) parent[pa] = pb;
        else if(pb > pa) parent[pb] = pa;
    }
}
