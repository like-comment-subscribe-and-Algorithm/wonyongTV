package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ2309_BRONZE1_일곱난쟁이 {
    /*
     * 시간 제한 2초 , 2*10^8 까지 가능
     * N = 9
     * 시간 복잡도 2^N도 가능
     *
     * 1. 난쟁이 키 9개를 입력 받는다.
     * 2. 정렬한다.
     * 3. 재귀를 돌린다.
     *
     * 재귀
     *   0. 답이 나왔는 지 확인하고
     *      0-1. 답이 있으면 return
     *   1. 현재 인덱스가 7인지 확인하다.
     *       1-1. 7일 경우 stack의 모든 수를 합하여 100인지 확인한다.
     *           1-1-1. 만약 합이 100이 아니라면 retuen
     *           1-1-2. 100이라면 해당 값들을 string builder 내에 넣는다.
     *       1-2. 아닐 경우 현재 index의 nums 값을 temp에 넣은 경우를 재귀에 넣는다.
     *       1-3. 아닐 경우 현재 index의 nums 값을 temp에 넣지 않고 재귀에 넣는다.
     * */

    private static int[] nums;
    private static int[] temp = new int[7];
    private static boolean[] visited = new boolean[9];
    private static StringBuilder sb = new StringBuilder();
    private static boolean isAns = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nums = new int[9];
        for (int i = 0; i < 9; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums);
        dfs(0, 0);
        System.out.println(sb);
    }

    private static void dfs(int start, int index) {
        if (isAns) return;
        if (index == 7) {
            int sum = 0;
            for (int t : temp) {
                sum += t;
            }
            if (sum != 100) return;

            isAns = true;
            for (int t : temp) {
                sb.append(t).append("\n");
            }
            return;
        }
        for (int i = start; i < 9; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp[index] = nums[i];
                dfs(start + 1, index + 1);
                dfs(start + 1, index);
                visited[i] = false;
            }
        }
    }
}
