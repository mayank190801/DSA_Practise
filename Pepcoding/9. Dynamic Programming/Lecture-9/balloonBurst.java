import java.util.Arrays;

public class balloonBurst {

    //pretty same according to sir( so it should be iterative possible )
    //CAN THIS BE SOLVED USING ITERATIVE METHOD??? (think about it)

    //think in direction which needs to be burst furst and stuff
    //a bit tricky but def solvable

    //first try recursion types no?
    //FREAKIN DOPE DP BOIS!!!! (remember for sure as always)
    public int maxCoins(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len + 2][len + 2];
        burst(nums, -1, nums.length, dp);
        return dp[0][nums.length+1];
    }

    //SIMPLE RECURSIVE BITCH BOIS
    public int burst(int[] nums, int si, int ei, int[][] dp){
        if(si + 1 == ei){
            return 0;
        }
        
        if(dp[si+1][ei+1] != 0){
            return dp[si+1][ei+1];
        }

        int ans = Integer.MIN_VALUE;
        for(int b = si +1 ; b < ei; b++){
            int l = burst(nums, si, b, dp);
            int r = burst(nums, b, ei, dp);
            int left = si == -1 ? 1 : nums[si];
            int right = ei == nums.length ? 1 : nums[ei];
            ans = Math.max(ans, l + r + right*left*nums[b]);
        }

        return dp[si+1][ei+1] = ans;
    }

}
