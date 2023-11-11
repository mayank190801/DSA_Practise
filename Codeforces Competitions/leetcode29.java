public class leetcode29 {

    public static void main(String[] args) {

    }

    public static int minPathSum(int[][] grid) {
         int n = grid.length;
         int m = grid[0].length;
         int[][] dp = new int[n][m];
         for(int i = 0; i < n; i++){
             for(int j = 0; j < m; j++){
                 if(i == 0 && j == 0){
                     dp[i][j] = grid[0][0];
                     continue;
                 }
                 int left = i == 0 ? Integer.MAX_VALUE : grid[i-1][j];
                 int right = j == 0 ? Integer.MAX_VALUE : grid[i][j-1];
                 dp[i][j] = Math.min(left + grid[i][j], right + grid[i][j]);
             }
         }
        return dp[n - 1][m - 1];
    }

    //in all these question where, dp is in 2D, there is always scope for optimisation to convert it to 1D
    //that makes a lot more sense to be working with for sure - let's figure it out man! - work hard, work smart and never give up
    //get into google no matter what man! just get into a company like that

    public static int minPathSum2(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 && j == 0){
                    grid[j] = grid[0][0];
                    continue;
                }
                int left = i == 0 ? Integer.MAX_VALUE - 500 : grid[i-1][j];
                int right = j == 0 ? Integer.MAX_VALUE - 500: grid[i][j-1];
                grid[i][j] = Math.min(left + grid[i][j], right + grid[i][j]);
            }
        }
        return grid[n - 1][m - 1];
    }




}
