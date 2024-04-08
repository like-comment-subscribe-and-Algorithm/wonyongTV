package bit_masking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11723_SILVER5_집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        int m = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String com = st.nextToken();

            if (com.equals("add")) {
                /*
                 * num 위치에 1비트를 위치시킨다.
                 * m = 0000 0001 이고,
                 * num = 3 일 때
                 * 0000 0101
                 * */
                int num = Integer.parseInt(st.nextToken());
                m |= (1 << (num - 1));
            } else if (com.equals("remove")) {
                /*
                 * num 위치에 비트가 있으면 0으로, 없다면 해당 연산을 무시한다.
                 * m = 0000 0101 이고,
                 * num = 3 일 때
                 * 1111 1011 을 만들어서
                 * 0000 0101 (&) 하면
                 * 0000 0001 이 된다.
                 * */
                int num = Integer.parseInt(st.nextToken());
                m &= (~(1 << (num - 1)));
            } else if (com.equals("check")) {
                /*
                 * num 위치에 비트가 있으면 1, 없다면 0을 출력해야 한다.
                 * m = 0000 0101 이고,
                 * num = 3 일 때
                 * m 을 3만큼 >> 이동 시켜서 1과 & 연산자를 한 결과를 출력한다.
                 * */
                int num = Integer.parseInt(st.nextToken());
                sb.append((m >> (num - 1)) & 1).append("\n");
            } else if (com.equals("toggle")) {
                /*
                 * num 위치에 비트가 있으면 제거하고, 없다면 num 위치에 1 비트를 추가한다.
                 * num = 3 일 때
                 * 0000 0101     0000 0001
                 * 0000 0100 (^) 0000 0100
                 * 0000 0001     0000 0101
                 * */
                int num = Integer.parseInt(st.nextToken());
                m ^= (1 << (num - 1));
            } else if (com.equals("all")) {
                /*
                 * num 을 11111111111111111111 으로 만든다.
                 * 0xf   = 0000 0000 1111
                 * 0xff  = 0000 1111 1111
                 * 0xfff = 1111 1111 1111
                 * */
                m = 0xfffff;
            } else if (com.equals("empty")) {
                /*
                 * num 을 0으로 만든다.
                 * */
                m = 0;
            }

        }
        System.out.println(sb);
    }
}
