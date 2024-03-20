package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ15686_GOLD5_치킨배달 {
    private static int m;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] maps = new int[n + 1][n + 1];
        List<Site> cities = new ArrayList<>();
        List<Site> chickens = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
                if (maps[i][j] == 1) cities.add(new Site(i, j));
                else if (maps[i][j] == 2) chickens.add(new Site(i, j));
            }
        }

        int[][] arr = new int[cities.size()][chickens.size()];
        for (int i = 0; i < cities.size(); i++) {
            for (int j = 0; j < chickens.size(); j++) {
                arr[i][j] = Math.abs(chickens.get(j).c - cities.get(i).c) + Math.abs(chickens.get(j).r - cities.get(i).r);
            }
        }

        dfs(chickens, new int[m], new boolean[chickens.size()], 0, 0, cities, arr);
        System.out.println(answer);
    }

    private static void dfs(List<Site> chickens, int[] temp, boolean[] visited, int index, int idx, List<Site> cities, int[][] arr) {
        if (idx == m) {
            int sum = 0;
            for (int i = 0; i < cities.size(); i++) {
                int min = Integer.MAX_VALUE;
                for (int t : temp) {
                    min = Math.min(arr[i][t], min);
                }
                sum += min;
            }
            answer = Math.min(sum, answer);
            return;
        }

        for (int i = index; i < chickens.size(); i++) {
            if (visited[i]) continue;
            visited[i] = true;
            temp[idx] = i;
            dfs(chickens, temp, visited, i + 1, idx + 1, cities, arr);
            visited[i] = false;
        }

    }
}

class Site {
    int r;
    int c;

    public Site(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
