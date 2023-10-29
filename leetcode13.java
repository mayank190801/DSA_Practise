public class leetcode13 {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(minIncrementOperations(nums,1));
    }


    //now solve for the third question
    public static long minIncrementOperations(int[] nums, int k) {
        //now think for this specific case - why not think about it
        //for every index we would have two choices, and what for the end indexes??
        //think for them as well brother, then put dp on the current solution - simple
        //one dp would be taken, other not taken?
        int len = nums.length;
        long[] dp = new long[len];
        dp[len - 1] = nums[len - 1] <= k ?  k - nums[len - 1] : 0;
        dp[len - 2] = nums[len - 2] <= k ? k - nums[len - 2] : 0;
        dp[len - 3] = nums[len - 3] <= k ? k - nums[len - 3] : 0;

        for(int i = len - 4; i >= 0; i--){
            long cost = nums[i] <= k ? k - nums[i] : 0;
            dp[i] = cost + Math.min(dp[i + 1], Math.min(dp[i + 2], dp[i + 3]));
        }

        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }




}
