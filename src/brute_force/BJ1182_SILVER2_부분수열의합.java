package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1182_SILVER2_부분수열의합 {
    /*
     * 시간 제한 : 2초 , 2*10^8
     * n : 20
     * 시간 복잡도 : 자유롭게
     *
     * 부분 수열이기 때문에 재귀를 사용하여
     * 1. 현재 index 값을 더할 때
     * 2. 현재 index 값을 더하지 않을 때
     * 를 구분하여 s와 같은지 확인한다.
     *
     * 이 때 s == 0 일 땐, 공집합도 포함될 수 있지만 부분 수열의 길이가 양수이기 때문에
     * s == 0 일 땐 -1을 한 값을 출력한다.
     * */
    private static int n;
    private static int s;
    private static int answer = 0;
    private static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        nums = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        System.out.println(s == 0 ? answer - 1 : answer);
    }

    private static void dfs(int index, int curr) {
        if (index == n) {
            if (curr == s) answer++;
            return;
        }
        dfs(index + 1, curr + nums[index]);
        dfs(index + 1, curr);
    }
}
