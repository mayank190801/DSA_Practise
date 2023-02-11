public class unboundedKnapSack {

    //Knapsack unbounded is basically this only
    //EASILY SOLVED BOIS
    public static int combinationsInfiTabBaseSubsequence1D(int N, int W, int val[], int wt[]){

        int[] dp = new int[W+1];
        // dp[0] = 1;
        for(int i = 1; i <= N; i++){
            for(int j = 0; j <= W; j++){
                if(j-wt[i-1] >= 0){
                    dp[j] = Math.max(dp[j], dp[j-wt[i-1]] + val[i-1]) ;   //my contribution
                }
            }   
        }

        return dp[W];
    }
    
    
}
