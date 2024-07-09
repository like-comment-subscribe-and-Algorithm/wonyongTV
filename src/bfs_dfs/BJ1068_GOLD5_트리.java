package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1068_GOLD5_트리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        int root = -1;
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            if (nums[i] == -1) {
                root = i;
            }
        }
        int remove = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] == -1) {
                continue;
            }
            graph.get(nums[i]).add(i);
        }

        Queue<Integer> que = new LinkedList<>();

        que.add(root);
        int answer = 0;
        while (!que.isEmpty()) {
            int node = que.poll();
            if (node == remove) {
                continue;
            }
            if (graph.get(node).isEmpty() || (graph.get(node).size() == 1 && graph.get(node).get(0) == remove)) {
                answer++;
                continue;
            }
            que.addAll(graph.get(node));
        }

        System.out.println(answer);
    }
}
