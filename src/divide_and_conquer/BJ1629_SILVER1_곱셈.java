package divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1629_SILVER1_곱셈 {
    /*
    * 시간 제한 : 0.5초
    *
    * A,B,C : 2,147,483,647
    *
    * 공식 1
    * a^10 = (a^5 * a^5)
    * a^5 = (a^2 * a^2 * a)
    *
    * 공식 2
    * (a*b)%c = (a%c*b%c)%c
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        System.out.println(div(a, b, c));
    }

    private static long div(long a, long b, long c) {
        if (b == 1) return a % c;

        long temp = div(a, b / 2, c);
        if (b % 2 == 0) return temp * temp % c;
        return (temp * temp % c) * a % c;
    }
}
