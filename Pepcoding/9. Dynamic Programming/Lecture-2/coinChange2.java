public class coinChange2 {

    //combinations infi
    public static int combinationsInfiTabBaseSubsequence1D(int[] nums, int tar){
        int[] dp = new int[tar+1];
        //base case not initialised bois
        dp[0] = 1;
        for(int i = 1; i <= nums.length; i++){
            for(int j = 0; j <= tar; j++){
                if(j-nums[i-1] >= 0){
                    dp[j] += dp[j-nums[i-1]];   //my contribution
                }
            }   
        }

        return dp[tar];
    }
    
    public int change(int amount, int[] coins) {
        //the above code exactly worked for this problem man
    }
    
}
