public class targetSum {

    //different ways of solving this question bois
    //TARGET SUM LEETCODE
    //SIR WAY OF DOING THINGS BE LIKE
    //SIR KAAFI BASIC LOGIC SE HAI BC!!!!!!!!!!
    public static int findTargetSumWays(int[] nums, int tar) {
        int negsum = 0;

        //all can be negative for sure
        for(int i : nums){
            negsum += i;
        }

        //exact dp size needed bois(important for sure)
        //i am super clearer!!!

        int[] dp = new int[Math.abs(tar) + 2*negsum + 1];
        int[] prev = new int[Math.abs(tar)  + 2*negsum + 1];
        
        //base case differs in this one (important) 
        prev[negsum] = 1;

        for(int i= 0; i< nums.length; i++){
            for(int j = 0; j < dp.length ; j++){
                //+ve
                int pos = j-nums[i];
                if(pos >= 0 && pos < dp.length){
                    dp[j] += prev[pos];
                }

                //-ve
                int neg = j+nums[i];
                if(neg >= 0 && neg < dp.length){
                    dp[j] += prev[neg];
                }
            }

            prev = dp;
            dp = new int[Math.abs(tar) + 2*negsum + 1];
        }

        return prev[Math.abs(tar) + negsum];    
    }

}
