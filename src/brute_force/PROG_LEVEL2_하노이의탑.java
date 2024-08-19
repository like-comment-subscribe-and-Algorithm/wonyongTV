package brute_force;

import java.util.ArrayList;
import java.util.List;

public class PROG_LEVEL2_하노이의탑 {
    static List<Temp> temp = new ArrayList<>();

    public int[][] solution(int n) {
        comb(1, 2, 3, n);
        int[][] answer = new int[temp.size()][];
        for (int i = 0; i < temp.size(); i++) {
            answer[i] = new int[]{temp.get(i).start, temp.get(i).end};
        }
        return answer;
    }

    public static void comb(int start, int mid, int end, int n) {
        if (n == 1) {
            temp.add(new Temp(start, end));
            return;
        }
        comb(start, end, mid, n - 1);
        comb(start, mid, end, 1);
        comb(mid, start, end, n - 1);
    }

    static class Temp {
        int start;
        int end;

        Temp(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
