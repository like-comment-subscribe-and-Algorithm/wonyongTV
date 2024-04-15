package greedy;

import java.util.Arrays;

public class PG_LEVEL3_단속카메라 {

    class Solution {
        public int solution(int[][] routes) {
            Car[] cars = new Car[routes.length];
            for (int i = 0; i < routes.length; i++) {
                cars[i] = new Car(routes[i][0], routes[i][1]);
            }
            Arrays.sort(cars);

            int answer = 0;

            int max = Integer.MIN_VALUE;
            for (int i = 0; i < cars.length; i++) {
                if (max < cars[i].enter) {
                    answer++;
                    max = cars[i].exit;
                }
            }

            return answer;
        }
    }

    class Car implements Comparable<Car> {
        int enter;
        int exit;

        public Car(int enter, int exit) {
            this.enter = enter;
            this.exit = exit;
        }

        @Override
        public int compareTo(Car o) {
            return this.exit - o.exit;
        }
    }

}


