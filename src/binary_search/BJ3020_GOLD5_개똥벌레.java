package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ3020_GOLD5_개똥벌레 {
    /*
    * 시간 제한 : 1초 , 10^8
    * N = 200,000 : 2*10^4
    * M = 500,000 : 5*10^4
    * 시간복잡도 ; Nlog(M) or Mlog(N) 이내
    *
    * 1. 종유석과 석순을 따로 받고, 각각 정렬한다.
    * 2. 0~m 까지 순회를 한다.
    * 3. 높이가 i 일 때 부숴지는 종유석과 석순의 개수를 구한다.
    * 4. 개수를 구할 때 n번 순회하면 시간 초과이므로, 이분 탐색을 통해서 중앙 값을 구한 뒤 배열 길이를 뺀 값을 반환한다.
    * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] bot = new int[n / 2];
        int[] top = new int[n / 2];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) bot[i / 2] = Integer.parseInt(br.readLine());
            else top[i / 2] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bot);
        Arrays.sort(top);
        int min = Integer.MAX_VALUE;
        int minCount = 0;
        for (int i = 0; i < m; i++) {
            int topCount = binarySearch(0, n / 2, i, top);

            int botH = m - i;
            int botCount = botBinarySearch(0, n / 2, botH, bot);

            int temp = topCount + botCount;
            if (temp == min) minCount++;
            else if (temp < min) {
                min = temp;
                minCount = 1;
            }
        }
        System.out.println(min + " " + minCount);
    }

    private static int binarySearch(int left, int right, int h, int[] arr) {
        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] > h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return arr.length - right;
    }

    private static int botBinarySearch(int left, int right, int h, int[] arr) {
        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] >= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return arr.length - right;
    }
}
