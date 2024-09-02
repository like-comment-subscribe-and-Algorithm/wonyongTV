package brute_force;

public class PG_LEVEL2_방문길이 {
    /*
    * 아래와 같이 생각하여 설계했다.
    *
    *             (4,5)
    *               |(5,5,0),(4,5,2)
    *   (5,5,0) ㅡ(5,5)ㅡ (5,5,1)
    *               |(5,5,2), (6,5,0)
    * 
    *
    * */
    int[][] moves = {{-1,0}, {0,1}, {1,0}, {0,-1}};

    public int solution(String dirs) {
        boolean[][][] visited = new boolean[11][11][4];
        int row = 5;
        int col = 5;

        int answer = 0;
        for(int i = 0 ; i< dirs.length() ; i++) {
            char commend = dirs.charAt(i);
            int next = move(commend);
            int nextCol = col + moves[next][0];
            int nextRow = row + moves[next][1];

            if(nextCol < 0 || nextCol > 10 || nextRow < 0 || nextRow > 10) continue;

            if(!visited[col][row][next]) {
                answer++;
                visited[col][row][next] = true;
                visited[nextCol][nextRow][(next+2)%4] = true;
            }

            col = nextCol;
            row = nextRow;
        }

        return answer;
    }

    public int move(char d) {
        if(d == 'U') return 0;
        if(d == 'D') return 2;
        if(d == 'R') return 1;
        return 3;
    }
}
