import java.util.Arrays;

public class MCM {

    //MY CODE 
    //MEMOIZED RECURSION MCM SOLUTION 
    //Basically all possibilities needs to be checked for this question
    public static void main(String[] args) {
        int[] arr = {40, 20, 30, 10, 30};
        int answer = matrixMultiplication(arr.length, arr);
        System.out.println(answer);
    }

    static int matrixMultiplication(int N, int arr[])
    {
        
        int[][] dp = new int[N+1][N+1];
        for(int i= 0; i <= N; i++){
            for(int j= 0; j <= N; j++){
                dp[i][j] = -1;
            }
        }

        return matrixMulti(N, arr, 0, N-1, dp);
    }

    public static int matrixMulti(int N, int arr[], int st, int end, int[][]dp){
        //simple logic
        if(st+1 == end){
            return 0;
        }

        if(dp[st][end] != -1){
            return dp[st][end];
        }

        int ans = Integer.MAX_VALUE;
        for(int i = st+1; i < end; i++){
            int left = matrixMulti(N, arr, st, i, dp);
            int right = matrixMulti(N, arr, i, end, dp);

            int cans = left + right + (arr[st] * arr[i] * arr[end]);
            ans = Math.min(ans, cans);
        }

        return dp[st][end] = ans;
    }

    //TABULATION FORM OF MCM (((((TABULATION FORM BABYYYY))))
    //(no idea how to do it vaise toh , but it could make sense if you think about it)

    //SEXY ITERATIVE DP APPROACHH TO SOLVE THIS BITCH!!!!!!
    //IMPORTANT AS IMPORTANT


    ///some improvement in below code 
    //no need of going from gap 0 - 1
    //just put dp[x][y] = Integer.MAX_VALUE before that freakin for loop
    //and you are good to go
    static int matrixMultiplicationIterative(int N, int arr[]){
        int[][] dp = new int[N][N];
        for(int i = 0; i < N; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        for(int gap = 0; gap < N; gap++){
            int x = 0;
            int y = gap;

            while(y < N){

                if(gap == 0 || gap == 1){
                    dp[x][y] = 0;
                }else{
                    for(int cut = x+1; cut < y; cut++){
                        int left = dp[x][cut];
                        int right = dp[cut][y];
            
                        int cans = left + right + (arr[x] * arr[cut] * arr[y]);
                        dp[x][y] = Math.min(cans, dp[x][y]);
                    }    
                }
            
                x++;
                y++;
            }            

        }
    
        return dp[0][N-1];
    }

}
