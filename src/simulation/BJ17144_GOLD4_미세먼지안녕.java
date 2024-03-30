package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 남들 보다 시간 복잡도 2배 , 공간 복잡도 10배가 나는 풀이...
public class BJ17144_GOLD4_미세먼지안녕 {
    private static int r;
    private static int c;
    private static int t;
    private static Dust[][] nums;
    private static int[][] moves = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int[][] cleans = new int[2][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        nums = new Dust[r][c];
        int idx = 0;
        for (int row = 0; row < r; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < c; col++) {
                nums[row][col] = new Dust(Integer.parseInt(st.nextToken()));
                if (nums[row][col].value == -1) cleans[idx++] = new int[]{row, col};
            }
        }

        for (int time = 0; time < t; time++) {
            trash();
            clean();
        }
        System.out.println(sum());
    }

    private static int sum() {
        int temp = 0;
        for (Dust[] num : nums) {
            for (Dust n : num) {
                temp += n.value;
            }
        }
        return temp + 2;
    }

    private static void clean() {
        upClean(cleans[0][0], cleans[0][1]);
        downClean(cleans[1][0], cleans[1][1]);
    }

    private static void upClean(int row, int col) {
        nums[row - 1][col].clean();
        for (int curr = row - 1; curr > 0; curr--) {
            nums[curr][0].value = nums[curr - 1][0].value;
        }
        for (int curr = 0; curr < c - 1; curr++) {
            nums[0][curr].value = nums[0][curr + 1].value;
        }
        for (int curr = 0; curr < row; curr++) {
            nums[curr][c - 1].value = nums[curr + 1][c - 1].value;
        }
        for (int curr = c - 1; curr > 1; curr--) {
            nums[row][curr].value = nums[row][curr - 1].value;
        }
        nums[row][col + 1].clean();
    }

    // col == 0
    private static void downClean(int row, int col) {
        nums[row + 1][col].clean();
        for (int curr = row + 1; curr < r - 1; curr++) {
            nums[curr][col].value = nums[curr + 1][col].value;
        }
        for (int curr = col; curr < c - 1; curr++) {
            nums[r - 1][curr].value = nums[r - 1][curr + 1].value;
        }
        for (int curr = r - 1; curr > row; curr--) {
            nums[curr][c - 1].value = nums[curr - 1][c - 1].value;
        }
        for (int curr = c - 1; curr > 1; curr--) {
            nums[row][curr].value = nums[row][curr - 1].value;
        }
        nums[row][col + 1].clean();
    }

    private static void trash() {
        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                if (nums[row][col].value == -1 || nums[row][col].value == 0) continue;
                expand(row, col);
            }
        }

        for (int row = 0; row < r; row++) {
            for (int col = 0; col < c; col++) {
                nums[row][col].pollQue();
            }
        }
    }

    private static boolean isExpand(int row, int col) {
        return row >= 0 && row < r && col >= 0 && col < c && nums[row][col].value != -1;
    }

    private static void expand(int row, int col) {
        int trash = nums[row][col].value / 5;
        for (int[] move : moves) {
            int nextRow = row + move[0];
            int nextCol = col + move[1];
            if (!isExpand(nextRow, nextCol)) continue;
            nums[nextRow][nextCol].addValue(trash);
            nums[row][col].addValue(-trash);
        }
    }
}

class Dust {
    int value;
    Queue<Integer> que;

    public Dust(int value) {
        this.value = value;
        this.que = new LinkedList<>();
    }

    public void pollQue() {
        while (!que.isEmpty()) {
            value += que.poll();
        }
        if (value < 0 && value != -1) value = 0;
    }

    public void addValue(int v) {
        que.add(v);
    }

    public void clean() {
        this.value = 0;
    }
}
