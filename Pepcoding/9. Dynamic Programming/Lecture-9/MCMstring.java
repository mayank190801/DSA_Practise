import java.util.Arrays;

public class MCMstring {
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int N = 5;

        // int N = 3;
        // int[] arr = {3,3,3};
        matrixChainOrder(arr, N);
    }

    //THIS BELOW WAS DONE USING RECURSIVE APPROACH (TRY DOING IT FOR ITERATIVE ONE TOOO)
    public static String matrixChainOrder(int arr[], int N){
        //let's use recursion only bois!!!
        int[][] dp = new int[N+1][N+1];
        //making updates in this string bad boi!!!
        String[][] dpS = new String[N+1][N+1];

        for(int i= 0; i <= N; i++){
            for(int j= 0; j <= N; j++){
                dp[i][j] = -1;
            }
        }

        matrixMulti(N, arr, 0, N-1, dp, dpS);
        // System.out.println(Arrays.deepToString(dpS));
        return dpS[0][N-1];
    
    }

    //SOLVED AT THE VERY FIRST TRY!!!! BABY BOIIII
    public static int matrixMulti(int N, int arr[], int st, int end, int[][]dp, String[][] dpS){
        //simple logic
        if(st+1 == end){
            String s = "" + (char)(st + 'A');
            dpS[st][end] = s;
            return 0;
        }

        if(dp[st][end] != -1){
            return dp[st][end];
        }

        int ans = Integer.MAX_VALUE;
        for(int i = st+1; i < end; i++){
            int left = matrixMulti(N, arr, st, i, dp, dpS);
            int right = matrixMulti(N, arr, i, end, dp, dpS);
            String leftS = dpS[st][i];
            String rightS = dpS[i][end];
            String currS = "(" + leftS + rightS + ")";
            
            int cans = left + right + (arr[st] * arr[i] * arr[end]);
            if(cans < ans){
                ans = cans;
                dpS[st][end] = currS;
            }
        }

        return dp[st][end] = ans;
    }


}
