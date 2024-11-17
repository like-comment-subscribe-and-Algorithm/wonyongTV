package simulation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class PG_LEVEL2_충돌위험찾기 {

    class Solution {
        Queue<int[]>[] records;

        public int solution(int[][] points, int[][] routes) {
            setUp(routes.length);
            int robot = 0;

            // 로봇 별 경로를 기록한다.
            for (int[] route : routes) {
                for (int i = 1; i < route.length; i++) {
                    int sr = points[route[i - 1] - 1][0];
                    int sc = points[route[i - 1] - 1][1];
                    int er = points[route[i] - 1][0];
                    int ec = points[route[i] - 1][1];
                    cal(sr, sc, er, ec, robot);
                }

                // cal 함수에는 종착지를 기록하지 않아서 따로 기록한다.
                int er = points[route[route.length - 1] - 1][0];
                int ec = points[route[route.length - 1] - 1][1];
                records[robot].add(new int[]{er, ec});
                robot++;
            }

            int answer = 0;
            while (true) {
                // record 별 경로를 map에 기록한다.
                Map<String, Integer> map = new HashMap<>();
                int cnt = 0;
                for (int i = 0; i < routes.length; i++) {
                    if (records[i].isEmpty()) {
                        continue;
                    }
                    var record = records[i].poll();
                    var key = record[0] + " " + record[1];
                    if (map.containsKey(key)) {
                        map.put(key, map.get(key) + 1);
                    } else {
                        map.put(key, 1);
                    }
                    cnt++;
                }

                // 모든 record를 봤다면 반복문을 종료한다.
                if (map.isEmpty()) {
                    break;
                }

                // 해당 시간대의 겹친 경로가 있다면 answer를 계산한다.
                if (map.size() != cnt) {
                    for (int v : map.values()) {
                        if (v == 1) {
                            continue;
                        }
                        answer += 1;
                    }
                }
            }

            return answer;
        }

        void setUp(int size) {
            records = new LinkedList[size];
            for (int i = 0; i < size; i++) {
                records[i] = new LinkedList<>();
            }
        }

        void cal(int sr, int sc, int er, int ec, int robot) {
            int nr = sr;
            while (nr != er) {
                records[robot].add(new int[]{nr, sc});
                if (nr > er) {
                    nr -= 1;
                } else {
                    nr += 1;
                }
            }

            int nc = sc;
            while (nc != ec) {
                records[robot].add(new int[]{nr, nc});
                if (nc > ec) {
                    nc -= 1;
                } else {
                    nc += 1;
                }
            }
        }
    }
}
