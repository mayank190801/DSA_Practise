public class coinChange{

    //multiple test cases
    //perm (single, infinite) (for, subseq)
    //comb (single, infinite) (for, susbseq)

    //HENCE TOTAL OF 8 WAYS bois
    //perm (single) (not optimised with dp)
    //everyone else YESSS!!!
    
    public static void main(String[] args) {
        int[] arr = {2,3,5,7};
        int tar = 10;

        int ans1 = permuteInfi(arr, tar);
        System.out.println(ans1);

        int[] dp = new int[tar+1];
        int ans2 = permuteInfiMemo(arr, tar, dp);  
        System.out.println(ans2);

        int ans3 = permuteInfiTab(arr, tar);
        System.out.println(ans3);

        int ans4 = combinationInfi(arr, tar, 0);
        System.out.println(ans4);

        int[][] t = new int[arr.length][tar+1];
        // int ans5 = combinationInfiMemo(arr, tar, 0, t);
        // System.out.println(ans5);

        // int ans6 = combinationsInfiTab(arr, tar, 0, t);
        // System.out.println(ans6);

        int ans7 = combinationsSingleTab(arr, tar, 0, t);
        System.out.println(ans7);
        
    }
 
    //PERMUTATION (infinite coins allowed)
    // (2,3,5,7) target - 10

    //FOR and SUBSEQ (two ways) (BOTH WERE RECURSION)
    //FOR mein saare options ek times pr
    //SUBSEQ mein index wise aage move krenge (take it or leave it)

    public static int permuteInfi(int[] nums, int tar){
        if(tar == 0){
            return 1;
        }

        int ans =0;
        for(int i = 0; i < nums.length; i++){
            if(tar - nums[i] >= 0){
                ans += permuteInfi(nums, tar-nums[i]);
            }
        }

        return ans;
    }


    public static int permuteInfiMemo(int[] nums, int tar, int[] dp){
        if(tar == 0){
            return 1;
        }

        if(dp[tar] != 0){
            return dp[tar];
        }

        int ans =0;
        for(int i = 0; i < nums.length; i++){
            if(tar - nums[i] >= 0){
                ans += permuteInfi(nums, tar-nums[i]);
            }
        }

        return dp[tar] = ans;
    }

    //think about iterative now 1D (only one variable is chaning)
    public static int permuteInfiTab(int[] nums, int tar){

        int[] dp = new int[tar+1];
        dp[0] = 1;

        //lol this shit works now
        for(int i = 0; i <= tar; i++){
            for(int j = 0; j < nums.length; j++){
                if(i - nums[j] >= 0){
                    dp[i] += dp[i - nums[j]];
                }
            }
        }

        return dp[tar];
    }


    //COMBINATIONS (infi coins, sinlge coins)

    //INFI COINS 

    //infi recursive
    public static int combinationInfi(int[] nums, int tar, int idx){

        if(tar == 0){
            return 1;
        }

        int ans = 0;
        for(int i = idx; i < nums.length; i++){
            if(tar-nums[i] >= 0){
                ans += combinationInfi(nums, tar-nums[i], i);
            }
        }

        return ans;
    }

    //infi memoize
    public static int combinationInfiMemo(int[] nums, int tar, int idx, int[][] dp){

        if(tar == 0){
            return 1;
        }

        if(dp[idx][tar] != 0){
            return dp[idx][tar];
        }

        int ans = 0;
        for(int i = idx; i < nums.length; i++){
            if(tar-nums[i] >= 0){
                ans += combinationInfiMemo(nums, tar-nums[i], i, dp);
            }
        }

        return dp[idx][tar] = ans;
    }


    public static int combinationsInfiTab(int[] nums, int tar, int idx, int[][] dp){

        for(int j = 0; j <= tar; j++){
            for(int i = 0; i < nums.length; i++){

                //base case bois
                if(j == 0){
                    dp[i][0] = 1;
                    continue;
                }

                //storing prev answer
                if(i != 0) dp[i][j] += dp[i-1][j];  //old answer

                if(j-nums[i] >= 0){
                    //which backward space we need??
                    dp[i][j] += dp[i][j-nums[i]];   //my contribution
                }
            }    
        }
        
        return dp[nums.length-1][tar];
    }




    //Sir said only one single change is there!
    //For single coins (tabulation)
    public static int combinationsSingleTab(int[] nums, int tar, int idx, int[][] dp){

        for(int j = 0; j <= tar; j++){
            for(int i = 0; i < nums.length; i++){

                //base case bois
                if(j == 0){
                    dp[i][0] = 1;
                    continue;
                }

                //storing prev answer
                if(i != 0) dp[i][j] += dp[i-1][j];  //old answer

                if(j-nums[i] > 0){
                    //which backward space we need??
                    if(i > 0)
                        dp[i][j] += dp[i-1][j-nums[i]];   //my contribution
                }

                //for self contribution addition (very important)
                if(j == nums[i]){
                    dp[i][j]++;
                }
            }    
        }
        
        return dp[nums.length-1][tar];
    }

    //With predefined base
    //Combinations single Tab 
    //2D dp bois (next we will convert in 1D dp)
    public static int combinationsSingleTabBase(int[] nums, int tar){

        int[][] dp = new int[nums.length+1][tar+1];
        dp[0][0] = 1;

        for(int j = 0; j <= tar; j++){
            for(int i = 1; i <= nums.length; i++){
                dp[i][j] += dp[i-1][j];  //old answer
                if(j-nums[i-1] >= 0){
                    dp[i][j] += dp[i-1][j-nums[i-1]];   //my contribution
                }
            }    
        }
    
        return dp[nums.length][tar];
    }

    //USING SUBSEQUENCE METHOD BOIS (last was using for loop method)
    public static int combinationsSingleTabBaseSubsequence(int[] nums, int tar){

        int[][] dp = new int[nums.length+1][tar+1];
        dp[0][0] = 1;

        for(int i = 1; i <= nums.length; i++){
            for(int j = 0; j <= tar; j++){
                dp[i][j] += dp[i-1][j];  //old answer
                if(j-nums[i-1] >= 0){
                    dp[i][j] += dp[i-1][j-nums[i-1]];   //my contribution
                }
            }    
        }
    
        return dp[nums.length][tar];
    }

    //1D dp bois using subsequence
    public static int combinationsSingleTabBaseSubsequence1D(int[] nums, int tar){

        int[] dp = new int[tar+1];
        int[] prev = new int[tar+1];
        prev[0] = 1;

        for(int i = 1; i <= nums.length; i++){
            for(int j = 0; j <= tar; j++){
                dp[j] += prev[j];  //old answer
                if(j-nums[i-1] >= 0){
                    dp[j] += prev[j-nums[i-1]];   //my contribution
                }
            }   
            prev = dp;
            dp = new int[tar+1];
        }
    
        return prev[tar];
    }

    //FOR INFINITE USING ABOVE CASE
    //NO NEED OF PREVIOUS!!! Think logically once for real
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

    //If you want 1D dp boi
    //PERMUTATION -> Vertical traversal
    //COMBINATION -> Horizontal traversal 

}