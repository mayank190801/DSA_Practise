public class knapSack {

    //0-1 Knapsack code by me bois!!!
    //I thought of this one (remembered what i have been taught yet)
    //It simply when to pick up the old answer make the current answer
    //(yehi logic bna ab tak mera toh)
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        //lemme think for this bad boi code now for sure 
        int[][] dp = new int[n+1][W+1];
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= W; j++){
                if(wt[i-1] <= j){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-wt[i-1]] + val[i-1]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[n][W];
    } 

    //0-1 knapsack using sir code now!!!
    //This code works beautifully too for sure
    public static int combinationsSingleTabBaseSubsequence1D(int W, int[] wt, int val[], int n){

        int[] dp = new int[W+1];
        int[] prev = new int[W+1];
        
        for(int i = 1; i <= wt.length; i++){
            for(int j = 0; j <= W; j++){
                dp[j] = prev[j];  //old answer
                if(j-wt[i-1] >= 0){
                    dp[j] = Math.max(dp[j], prev[j-wt[i-1]] + val[i-1]);   //my contribution
                }
            }   
            prev = dp;
            dp = new int[W+1];
        }
    
        return prev[W];
    }

    

    
}
