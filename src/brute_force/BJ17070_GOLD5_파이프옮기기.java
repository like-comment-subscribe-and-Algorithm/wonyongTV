package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ17070_GOLD5_파이프옮기기 {
    /*
     * Pipe
     *   int[] start
     *   int[] end
     *   String type -> RIGHT, BOTTOM, RIGHT_BOTTOM
     *
     *  move
     *   RIGHT -> 오른쪽, 오른쪽 아래
     *   BOTTOM -> 아래, 오른쪽 아래
     *   RIGHT_BOTTOM -> 오른쪽, 아래, 오른쪽 아래
     *
     * */
    static int n;
    static int[][] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Stack<Pipe> que = new Stack<>();
        que.add(new Pipe(new int[]{0, 0}, new int[]{0, 1}, "RIGHT"));

        int answer = 0;
        while (!que.isEmpty()) {
            Pipe pipe = que.pop();
            if (pipe.end[0] == n - 1 && pipe.end[1] == n - 1) {
                answer++;
                continue;
            }
            move(pipe, que);
        }
        System.out.println(answer);
    }

    public static void move(Pipe pipe, Stack<Pipe> que) {
        if (pipe.type.equals("RIGHT")) {
            if (isRight(pipe)) {
                que.add(moveRight(pipe));
            }
            if (isBottomRight(pipe)) {
                que.add(moveRightBottom(pipe));
            }
        } else if (pipe.type.equals("BOTTOM")) {
            if (isBottom(pipe)) {
                que.add(moveBottom(pipe));
            }
            if (isBottomRight(pipe)) {
                que.add(moveRightBottom(pipe));
            }
        } else {
            if (isRight(pipe)) {
                que.add(moveRight(pipe));
            }
            if (isBottom(pipe)) {
                que.add(moveBottom(pipe));
            }
            if (isBottomRight(pipe)) {
                que.add(moveRightBottom(pipe));
            }
        }
    }

    public static boolean isRight(Pipe pipe) {
        return pipe.end[1] + 1 < n && nums[pipe.end[0]][pipe.end[1] + 1] != 1;
    }

    public static boolean isBottom(Pipe pipe) {
        return pipe.end[0] + 1 < n && nums[pipe.end[0] + 1][pipe.end[1]] != 1;
    }

    public static boolean isBottomRight(Pipe pipe) {
        return isRight(pipe) && isBottom(pipe) && pipe.end[0] + 1 < n && pipe.end[1] + 1 < n
                && nums[pipe.end[0] + 1][pipe.end[1] + 1] != 1;
    }

    public static Pipe moveRight(Pipe pipe) {
        return new Pipe(pipe.end, new int[]{pipe.end[0], pipe.end[1] + 1}, "RIGHT");
    }

    public static Pipe moveBottom(Pipe pipe) {
        return new Pipe(pipe.end, new int[]{pipe.end[0] + 1, pipe.end[1]}, "BOTTOM");
    }

    public static Pipe moveRightBottom(Pipe pipe) {
        return new Pipe(pipe.end, new int[]{pipe.end[0] + 1, pipe.end[1] + 1}, "RIGHT_BOTTOM");
    }

    static class Pipe {
        int[] start;
        int[] end;
        String type;

        public Pipe(int[] start, int[] end, String type) {
            this.start = start;
            this.end = end;
            this.type = type;
        }
    }
}
