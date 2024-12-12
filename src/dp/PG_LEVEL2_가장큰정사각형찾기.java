package dp;

public class PG_LEVEL2_가장큰정사각형찾기 {
    class Solution {
        public int solution(int [][]board) {
            int row = board.length;
            int col = board[0].length;

            int[][] dp = new int[row][col];
            for(int c = 0; c < col; c++) {
                dp[0][c] = board[0][c];
            }
            for(int r = 0; r < row; r++) {
                dp[r][0] = board[r][0];
            }


            for(int r = 1; r < row; r++) {
                for(int c = 1; c < col; c++) {
                    int num1 = dp[r-1][c];
                    int num2 = dp[r][c-1];
                    int num3 = dp[r-1][c-1];

                    int min = Math.min(num1,num2);
                    min = Math.min(min, num3);

                    // 본인이 1일 때만 해당 내용을 적용해야 함
                    if(board[r][c] == 1) dp[r][c] = min + 1;
                    else dp[r][c] = 0;
                }
            }

            int answer = 0;
            for(int r = 0; r < row; r++) {
                for(int c = 0; c < col; c++) {
                    answer = Math.max(answer, dp[r][c]);
                }
            }

            return answer * answer;
        }
    }
}
