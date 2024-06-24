package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ13549_GOLD5_숨바꼭질3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        PriorityQueue<Spot> que = new PriorityQueue<>();
        boolean[] visited = new boolean[100_001];
        que.add(new Spot(n, 0));
        visited[n] = true;
        while (!que.isEmpty()) {
            Spot spot = que.poll();
            visited[spot.loc] = true;
            if (spot.loc == k) {
                System.out.println(spot.sec);
                return;
            }
            if (spot.loc * 2 <= 100_000 && !visited[2 * spot.loc]) {
                que.add(new Spot(spot.loc * 2, spot.sec));
            }
            if (spot.loc - 1 >= 0 && !visited[spot.loc - 1]) {
                que.add(new Spot(spot.loc - 1, spot.sec + 1));
            }
            if (spot.loc + 1 <= 100_000 && !visited[spot.loc + 1]) {
                que.add(new Spot(spot.loc + 1, spot.sec + 1));
            }
        }
    }
}

class Spot implements Comparable<Spot> {
    int loc;
    int sec;

    public Spot(int loc, int sec) {
        this.loc = loc;
        this.sec = sec;
    }

    @Override
    public int compareTo(Spot o) {
        return this.sec - o.sec;
    }
}
