public class leetcode28 {
    public static void main(String[] args) {

    }

    public static int uniquePaths(int m, int n) {
        int[][] grid = new int[m + 1][n + 1];
        grid[1][1] = 1;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
            }
        }
        return grid[m][n];
    }


}
