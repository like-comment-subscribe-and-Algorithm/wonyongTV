package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1931_SILVER1_회의실배정 {
    /*
     * 2초 : 2*10^8
     * n = 100,000 = 10^5
     * 시간 복잡도 nLog(n) 이내
     *
     * 1. 회의 시간을 입력 받는다.
     * 2. 회의 종료 시간을 기준으로 정렬을 한다.
     * 3. 입력 받은 회의 시간을 순회하며 회의 종료 시간과 다음 회의 시작 시간을 비교한다.
     * 4. 만약 회의 종료 시간이 다음 회의 시작 시간 보다 작다면 회의 종료 시간을 갱신하며 카운팅한다.
     * */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Meeting[] meetings = new Meeting[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(meetings);
        int answer = 1;
        int endTime = meetings[0].end;
        for (int i = 1; i < meetings.length; i++) {
            if (endTime > meetings[i].start) continue;
            endTime = meetings[i].end;
            answer++;
        }

        System.out.println(answer);
    }
}

class Meeting implements Comparable<Meeting> {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting other) {
        if (this.end == other.end) return this.start - other.start;
        return this.end - other.end;
    }
}
