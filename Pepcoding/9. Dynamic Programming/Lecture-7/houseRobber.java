import java.util.Arrays;

public class houseRobber {

    //house robber problems babyyyy
    //HOUSE ROBBER - 1
    //(same as maxSum adjacent bois)
    //my code for 2 variables bois
    public static int rob(int[] nums) {
        int f = nums[0];
        int s = 0;

        for(int i = 1; i < nums.length; i++){
            int temp = f;
            f = s + nums[i];
            s = Math.max(temp, s);
        }

        return Math.max(f, s);
    }

    //SIR CODE FOR THE ABOVE PROBLEM
    //SIMPLE LOGICAL METHOD FOR THIS QUESTIONNNNN
    //RECURSION PROBABLYYYYYYYYYYY TLE BABYYYY!!!!! (i knew that shit)
    public static int robSir(int[] nums) {
        int ans = robSir(nums, 0);
        return ans;
    }

    public static int robSir(int[] nums, int idx){
        if(idx >= nums.length) {
            return 0;
        }
    
        //include
        int inc = robSir(nums, idx + 2) + nums[idx];

        //exclude
        int exc = robSir(nums, idx + 1);
        return Math.max(inc, exc);
    }


    //SIR CODE FOR THE ABOVE PROBLEM
    //MEMOIZED VERSION BOIS
    public static int robSir(int[] nums) {
        int[] dp = new int[nums.length];
        
        //memoization
        Arrays.fill(dp, -1);

        int ans = robSir(nums, 0);
        return ans;
    }

    public static int robSir(int[] nums, int idx, int[]dp){
        if(idx >= nums.length) {
            return 0;
        }

        //memoization
        if(dp[idx] != -1){
            return dp[idx];
        }
    
        //include
        int inc = robSir(nums, idx + 2, dp) + nums[idx];

        //exclude
        int exc = robSir(nums, idx + 1,dp);
        return dp[idx] = Math.max(inc, exc);
    }

    //SIR CODE FOR THIS PROBLEM
    //DP (USING DPPPPP!!!!) (but using a complete dp arrayyyy!!!!)
    public static int robSir(int[] nums) {

        if(nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        int len = nums.length;

        dp[len - 1] = nums[len - 1];
        dp[len - 2] =  Math.max(nums[len-1], nums[len-2]);
        for(int i = len - 3; i >= 0; i--){
            dp[i] = Math.max(dp[i+1], dp[i+2] + nums[i]);
        }

        return dp[0];
    }

    //SIR CODE FOR THIS QUESTION USING 2 Variables onlyyyy
    //DP (2 variables)
    public static int robSir(int[] nums) {

        if(nums.length == 1) return 0;
        
        int len = nums.length;
        int rright = nums[len-1];
        int right = Math.max(nums[len-1], nums[len-2]);

        for(int i = len-3 ; i >= 0; i--){
            int curr = Math.max(right, rright + nums[i]);
            rright = right;
            right = curr;
        }

        return right;
    }
        
}
