package bfs_dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PG_LEVEL3_여행경로 {

    class Solution {
        private boolean[] visited;
        private List<String> temp = new ArrayList<>();

        public String[] solution(String[][] tickets) {
            visited = new boolean[tickets.length];
            String[] answer = {};

            dfs(tickets, 0, "ICN", "ICN");
            Collections.sort(temp);
            return temp.get(0).split(" ");
        }

        private void dfs(String[][] tickets, int dep, String curr, String str) {
            if (dep == tickets.length) {
                temp.add(str);
                return;
            }

            for (int i = 0; i < tickets.length; i++) {
                if (visited[i] || !tickets[i][0].equals(curr)) continue;
                visited[i] = true;
                dfs(tickets, dep + 1, tickets[i][1], str + " " + tickets[i][1]);
                visited[i] = false;
            }
        }
    }
}
