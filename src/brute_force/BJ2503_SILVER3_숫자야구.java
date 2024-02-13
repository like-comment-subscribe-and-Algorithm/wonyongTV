package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ2503_SILVER3_숫자야구 {
    /*
     * 1초 : 10^8 ,
     * n = 100
     * n^3 = 10^6
     *
     * 시간 복잡도 n^3까지도 가능하다.
     *
     * 123 ~ 987까지의 수를 순회하면서
     * 입력한 값을 모두 만족할 때 마다 카운트 한다.
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<BaseBall> baseBalls = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            baseBalls.add(new BaseBall(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int answer = 0;
        for (int i = 123; i <= 987; i++) {
            if (!isValidNum(i)) continue;

            boolean isAns = true;
            for (BaseBall baseBall : baseBalls) {
                if (!baseBall.isAns(i)) {
                    isAns = false;
                    break;
                }
            }
            if (isAns) answer++;

        }

        System.out.println(answer);
    }

    private static boolean isValidNum(int num) {
        int first = num / 100;
        int mid = (num % 100) / 10;
        int third = num % 10;
        return !((first == mid) || (mid == third) || (third == first) || (first == 0) || (mid == 0) || (third == 0));
    }
}

class BaseBall {
    int[] nums;
    int strike;
    int ball;

    public BaseBall(int num, int strike, int ball) {
        this.nums = new int[]{num / 100, (num % 100) / 10, num % 10};
        this.strike = strike;
        this.ball = ball;
    }

    public boolean isAns(int num) {
        int first = num / 100;
        int mid = (num % 100) / 10;
        int third = num % 10;

        int ballCount = calBall(first, mid, third);
        int strikeCount = calStrike(first, mid, third);
        return this.ball == ballCount && this.strike == strikeCount;
    }

    private int calStrike(int first, int mid, int third) {
        int strikeCount = 0;
        if (first == nums[0]) strikeCount++;
        if (mid == nums[1]) strikeCount++;
        if (third == nums[2]) strikeCount++;
        return strikeCount;
    }

    private int calBall(int first, int mid, int third) {
        int ballCount = 0;
        if (nums[0] != first && (nums[0] == mid || nums[0] == third)) ballCount++;
        if (nums[1] != mid && (nums[1] == first || nums[1] == third)) ballCount++;
        if (nums[2] != third && (nums[2] == first || nums[2] == mid)) ballCount++;
        return ballCount;
    }
}
