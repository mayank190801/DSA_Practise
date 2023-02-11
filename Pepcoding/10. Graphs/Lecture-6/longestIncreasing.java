import java.util.Arrays;

public class longestIncreasing {
    public static void main(String[] args) {
        int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
        int ans = longestIncreasingPath(matrix);
        System.out.println(ans);
     }

    //TWO WAYS TO SOLVE THIS PROBEM
    //DP WITH GRAPH simple logix which i did
    //OR Khan's Algo concept could also be used for this bad boi
    
    //this is simple logix
    //It works pretty smooth for sure!! 
    //But only better than 25% percent of coder dude!!
    public static int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        for(int i= 0; i < rows; i++){
            Arrays.fill(dp[i], -1);
        }

        //now after this put int visited or not
        
        
        for(int i= 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(dp[i][j] != -1) continue;
                //otherwise what
                dfsSolve(i, j, rows, cols, matrix, dp);       
            }
        }

        int answer = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                answer = Math.max(answer, dp[i][j]);
            }
        }

        //then find the maximum of them all for sure
        return answer;
    }

    public static int dfsSolve(int x, int y, int rows, int cols, int[][] matrix, int[][] dp){
        
        int[][] dir = {{0,-1},{0,1},{1,0},{-1,0}};
        int max = 0;

        for(int[] d : dir){
            int cx = x + d[0];
            int cy = y + d[1];

            if(cx >= 0 && cx < rows && cy >= 0 && cy < cols && (matrix[x][y] < matrix[cx][cy])){
                if(dp[cx][cy] != -1){
                    max = Math.max(max, dp[cx][cy]);
                }else{
                    max = Math.max(max,dfsSolve(cx, cy, rows, cols, matrix, dp));
                }
            }
        }

        return dp[x][y] = max + 1;
    }

}
