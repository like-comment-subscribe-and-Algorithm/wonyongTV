package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class BJ14891_GOLD5_톱니바퀴 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Deque<Integer>> ques = new ArrayList<>();
        ques.add(new ArrayDeque<>());
        ques.add(new ArrayDeque<>());
        ques.add(new ArrayDeque<>());
        ques.add(new ArrayDeque<>());

        for (Deque<Integer> que : ques) {
            String[] arr = br.readLine().split("");
            for (String a : arr) {
                que.add(Integer.parseInt(a));
            }
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());

            int[] isRotate = new int[4];
            isRotate[idx] = d;

            int temp = d;
            for (int k = idx; k < 3; k++) {
                if (isEqual(ques.get(k), ques.get(k + 1))) break;
                temp = -temp;
                isRotate[k + 1] = temp;
            }
            temp = d;
            for (int k = idx; k > 0; k--) {
                if (isEqual(ques.get(k - 1), ques.get(k))) break;
                temp = -temp;
                isRotate[k-1] = temp;
            }

            for (int k = 0; k < 4; k++) {
                if (isRotate[k] == 1) turnRight(ques.get(k));
                else if (isRotate[k] == -1) turnLeft(ques.get(k));
            }
        }

        int answer = 0;
        if (ques.get(0).peek() == 1) answer += 1;
        if (ques.get(1).peek() == 1) answer += 2;
        if (ques.get(2).peek() == 1) answer += 4;
        if (ques.get(3).peek() == 1) answer += 8;
        System.out.println(answer);
    }

    private static boolean isEqual(Deque<Integer> twoIdxQue, Deque<Integer> sitIdxQue) {
        int i = 0;
        int twoIdxValue = -1;
        for (int t : twoIdxQue) {
            if (i++ == 2) {
                twoIdxValue = t;
                break;
            }
        }

        i = 0;
        int sixIdxValue = -1;
        for (int t : sitIdxQue) {
            if (i++ == 6) {
                sixIdxValue = t;
                break;
            }
        }

        return twoIdxValue == sixIdxValue;
    }

    private static void turnLeft(Deque<Integer> que) {
        que.addLast(que.pollFirst());
    }

    private static void turnRight(Deque<Integer> que) {
        que.addFirst(que.pollLast());
    }
}
