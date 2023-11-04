public class leetcode23 {
    public static void main(String[] args) {

    }

    //so let's solve this
    public static int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int[][] dp = new int[len][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        int ans = 1;

        for(int i = 1; i < len; i++){
            int val1 = nums1[i];
           int bestPossible1 = Math.max(val1 >= nums1[i - 1] ? dp[i-1][0] : Integer.MIN_VALUE, val1 >= nums2[i - 1] ? dp[i - 1][1] : Integer.MIN_VALUE);
           dp[i][0] = Math.max(1, bestPossible1 + 1);
           int val2 = nums1[i];
           int bestPossible2 = Math.max(val2 >= nums1[i - 1] ? dp[i-1][0] : Integer.MIN_VALUE, val2 >= nums2[i - 1] ? dp[i - 1][1] : Integer.MIN_VALUE);
           dp[i][1] = Math.max(1, bestPossible2 + 1);
           ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }
        return ans;
    }
}
