public class maxPath{
    public static void main(String[] args){
        int N =2 ;
        int[][] Matrix = {{348, 391},
          {618, 193}};

        int ans = maximumPath(N, Matrix);
        System.out.println(ans);
    }

    public static int maximumPath(int N, int Matrix[][])
    {

        int[][] dp = new int[N + 1][N + 1];
        for(int i= 0; i < N; i++){
            dp[0][i] = Matrix[0][i];
        }

        for(int i= 1; i < N; i++){
            for(int j = 0; j < N; j++){ 
                int top = Matrix[i][j] + dp[i-1][j];
                int topleft = j == 0 ? 0 : Matrix[i][j] + dp[i-1][j-1];
                int topright = j == N - 1 ? 0 : Matrix[i][j] + dp[i-1][j+1];
                dp[i][j] = Math.max(Math.max(top, topleft), topright);
            }
        }

        int ans = 0;
        for(int i = 0; i < N; i++){
            ans = Math.max(dp[N-1][i], ans);
        }

        return ans;
    }
}