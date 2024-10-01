package greedy;

public class PG_LEVEL2_캐시 {
    class Solution {
        int cs;
        Cache[] caches;
        public int solution(int cacheSize, String[] cities) {
            int answer = 0;
            caches = new Cache[cacheSize];
            cs = 0;

            for(int i = 0 ; i < cities.length ; i++) {
                //print(caches);
                //System.out.println(" answer " + answer);
                String city = cities[i].toLowerCase();
                if(isCache(city, i)) {
                    answer += 1;
                    continue;
                }
                answer += 5;
                if(cacheSize == 0) continue;

                if(cs != cacheSize) {
                    caches[cs++] = new Cache(city, i);
                    continue;
                }
                int last = Integer.MIN_VALUE;
                int idx = Integer.MIN_VALUE;
                for(int j = 0 ; j< cs ; j++) {
                    int value = i - caches[j].used;
                    if(last < value) {
                        last = value;
                        idx = j;
                    }
                }
                caches[idx] = new Cache(city, i);

            }
            return answer;
        }

        public boolean isCache(String city, int idx) {
            for(int i = 0 ; i< cs ; i++) {
                if(caches[i] == null) return false;
                if(caches[i].city.equals(city)) {
                    caches[i].used = idx;
                    return true;
                }
            }
            return false;
        }

        public void print(Cache[] caches) {
            for(Cache cache: caches) {
                if(cache == null) break;
                System.out.print(cache.city + " " + cache.used + ", ");
            }
        }
    }

    class Cache {
        String city;
        int used;

        Cache(String city, int used) {
            this.city = city;
            this.used = used;
        }
    }

}
