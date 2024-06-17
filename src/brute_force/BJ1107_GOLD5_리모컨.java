package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1107_GOLD5_리모컨 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        boolean[] isBreak = new boolean[10];

        if (n != 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < n ; i++) {
                String str = st.nextToken();
                isBreak[Integer.parseInt(str)] = true;
            }
        }

        int min = Math.abs(num - 100);
        for(int i = 0; i<=999999 ; i++){
            String temp = String.valueOf(i);
            boolean b = false;
            for(int idx = 0; idx < temp.length() ; idx++) {
                if(!isBreak[temp.charAt(idx) - '0']) continue;
                b = true;
                break;
            }

            if (b) continue;
            min = Math.min(min, temp.length()+Math.abs(num - i));
        }
        System.out.println(min);
    }
}
