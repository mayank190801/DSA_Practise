import java.util.Arrays;

public class coinChange1 {

    //these are the problems we have encountered till now bois
    public static void main(String[] args) {
        
        int[] coins = {1,2,5};
        int amount = 11;

        int ans = coinChangeTable(coins, amount);
        System.out.println(ans);

    }

    //this is for loop method for sure(vertical traversal ig)
    //so this below code works beautifully for the recursion code
    //you can see it yourself, now let's memoize it
    //THIS CODE SUCKS AT TLE 
    // public static int coinChange(int[] coins, int amount) { 
    //     int ans = helper(coins, amount);
    //     if(ans == Integer.MAX_VALUE-1) return -1;
    //     return ans;
    // }
    
    public static int helper(int[] coins, int amount){
        if(amount == 0) return 0;  //base case babies
        
        int ans = Integer.MAX_VALUE - 1;
        for(int i= 0; i < coins.length; i++){
            if(amount - coins[i] >= 0){
                int curr = helper(coins, amount-coins[i]);
                ans = Math.min(curr+1, ans);
            }
        }

        return ans;  //simple as that (incase not present
    }

    //SO THIS MEMOIZED CODE DOES GIVE THE ANSWER DUDE 
    //I am glad i still remember some coding drills and shit man!!!
    //This works for sure (glad man, glad!!!!)

    //memoize main function
     public static int coinChange(int[] coins, int amount) { 
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);

        int ans = coinChangeMemoize(coins, amount, dp);
        if(ans == Integer.MAX_VALUE-1) return -1;
        return ans;
    }

    //memoize
    public static int coinChangeMemoize(int[] coins, int amount, int[] dp) {

        if(amount == 0) return 0;  //base case babies

        if(dp[amount] != -1){
            return dp[amount];
        }
        
        int ans = Integer.MAX_VALUE - 1;
        for(int i= 0; i < coins.length; i++){
            if(amount - coins[i] >= 0){
                int curr = coinChangeMemoize(coins, amount-coins[i], dp);
                ans = Math.min(curr+1, ans);
            }
        }

        return dp[amount] = ans;  //simple as that (incase not present
        
    }

    //THIS IS THE FASTEST CODE OUT THERE 
    //only 12 ms bois (faster than speed of flash bois)
    public static int coinChangeTable(int[] coins, int amount){
        int[] dp = new int[amount+1];
        //how would you do it
        Arrays.fill(dp, Integer.MAX_VALUE-1);
        dp[0] = 0;

        for(int i = 1; i <= coins.length; i++){
            for(int j = 0; j <= amount; j++){
                if(j-coins[i-1] >= 0){
                    dp[j] = Math.min(dp[j-coins[i-1]]+1, dp[j]); //update in here
                }
            }   
        }

        //this is the end case bois
        if(dp[amount] == Integer.MAX_VALUE-1) return -1;
        return dp[amount];
    }
    
}
