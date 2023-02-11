class coinChange {

	public static void main(String[] args){
		int[] coins = {2, 3, 5};
		int amount = 11;

		int ans = coinChange(coins, amount);
		System.out.println(ans);
	}

	

    public static int coinChange(int[] coins, int amount) {
    	int max = Integer.MAX_VALUE - 1;
    	int n = coins.length;
    	int[][] dp = new int[amount + 1][n + 1];

    	//setting base values
    	for(int i = 0; i <= amount; i++){
    		dp[i][0] = Integer.MAX_VALUE - 1;
    	}

    	for(int i = 1; i <= amount; i++){
    		for(int j = 1; j <= n; j++){  //only taking values
    			if(i - coins[j-1] >= 0){
    				dp[i][j] = Math.min(dp[i][j-1], dp[i - coins[j-1]][j] + 1);
    			}else{
    				dp[i][j] = dp[i][j-1];
    			}
    		}
    	} 

    	return dp[amount][n] == Integer.MAX_VALUE - 1 ? -1 : dp[amount][n];   
    }


    //apply combo infi simple as that bro
    public int change(int amount, int[] coins) {
    	int len = coins.length;
        int[][] dp = new int[amount + 1][len + 1];

        for(int i = 0; i <= amount; i++){
        	for(int j = 1; j <= len; j++){
                if(i == 0){
                    dp[i][j] = 1;
                    continue;
                }
                
        		dp[i][j] += dp[i][j-1];
        		if(i - coins[j-1] >= 0){
        			dp[i][j] += dp[i - coins[j-1]][j];
        		}
        	}
        }

        return dp[amount][len];
    }

}










