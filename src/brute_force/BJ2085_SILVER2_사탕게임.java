package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2085_SILVER2_사탕게임 {
    private static final String[] candies = {"C", "P", "Z", "Y"};
    private static String[][] maps;
    private static int n;

    /*
     * 시간 제한 : 1초 , 10^8
     * n = 50
     * 시간 복잡도 상관 없이 풀어도 된다.
     *
     * 1. 값을 입력 받고, 사탕들을 조사해서 최대 값을 구한다.
     * 2. 만약 최대 값이 n이 아니라면 사탕들을 순회한다.
     *   2-1. 순회하며 만약 본인의 사탕과 오른쪽 사탕이 다르다면 두 사탕을 교환한 뒤 사탕들을 조사하여 최대 값을 구한다.
     *   2-2. 순회하며 만약 본인의 사탕과 아래 사탕이 다르다면 두 사탕을 교환한 뒤 사탕들을 조사하여 최대 값을 구한다.
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        maps = new String[n][];
        for (int i = 0; i < n; i++) {
            maps[i] = br.readLine().split("");
        }
        int answer = read();
        if (answer == n) System.out.println(answer);
        else {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n - 1; c++) {
                    if (maps[r][c].equals(maps[r][c + 1])) continue;
                    String temp = maps[r][c + 1];
                    maps[r][c + 1] = maps[r][c];
                    maps[r][c] = temp;
                    answer = Math.max(answer, read());
                    maps[r][c] = maps[r][c + 1];
                    maps[r][c + 1] = temp;
                }
            }


            for (int c = 0; c < n; c++) {
                for (int r = 0; r < n - 1; r++) {
                    if (maps[r][c].equals(maps[r + 1][c])) continue;
                    String temp = maps[r + 1][c];
                    maps[r + 1][c] = maps[r][c];
                    maps[r][c] = temp;
                    answer = Math.max(answer, read());
                    maps[r][c] = maps[r + 1][c];
                    maps[r + 1][c] = temp;
                }
            }
            System.out.println(answer);
        }
    }

    private static int read() {
        int answer = 0;
        for (String candy : candies) {
            for (String[] map : maps) {
                int temp = 0;
                for (String m : map) {
                    if (m.equals(candy)) temp++;
                    else {
                        answer = Math.max(answer, temp);
                        temp = 0;
                    }
                }
                answer = Math.max(answer, temp);
            }

            for (int c = 0; c < n; c++) {
                int temp = 0;
                for (int r = 0; r < n; r++) {
                    if (maps[r][c].equals(candy)) temp++;
                    else {
                        answer = Math.max(answer, temp);
                        temp = 0;
                    }
                }
                answer = Math.max(answer, temp);
            }
        }
        return answer;
    }
}
