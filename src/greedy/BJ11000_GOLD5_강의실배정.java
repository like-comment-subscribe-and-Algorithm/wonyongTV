package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ11000_GOLD5_강의실배정 {
    /*
     * 시간 제한 : 1초 , 10^8
     * n = 2*10^5
     * 시간 복잡도 nLog(n) 이내로 풀어야 함
     *
     * 1. 시작 시간 기준으로 정렬한다.
     * 2. 시작 시간과 우선 순위 큐의 peek를 비교한다.
     *   a. 시작 시간이 peek 보다 작으면 종료 시간을 add 한다.
     *   b. 시작 시간이 peek 보다 크거나 같으면 pop을 하고, add 한다.
     * 3. 우선 순위 큐에 길이를 출력한다.
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Room[] rooms = new Room[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            rooms[i] = new Room(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(rooms);
        PriorityQueue<Integer> count = new PriorityQueue<>();
        count.add(rooms[0].end);
        for (int i = 1; i < n; i++) {
            if (count.peek() <= rooms[i].start) count.poll();
            count.add(rooms[i].end);
        }
        System.out.println(count.size());
    }
}

class Room implements Comparable<Room> {
    int start;
    int end;

    public Room(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Room other) {
        if (this.start == other.start) return this.end - other.end;
        return this.start - other.start;
    }
}
