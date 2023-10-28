import java.util.ArrayList;
import java.util.List;

public class leetcode10 {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);

        System.out.println(lengthOfLongestSubsequence(nums, 9));
    }

    public static int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[][] dp = new int[1001][1001];
        for(int i = 0; i < 1001; i++){
            for(int j = 0; j < 1001; j++){
                dp[i][j] = -1;
            }
        }
        int ans = solver(nums, target, 0, dp);
        return ans == Integer.MIN_VALUE ? -1 : ans;
    }

    public static int solver(List<Integer> nums, int target, int idx, int[][] dp){
        if(dp[idx][target] != -1) return dp[idx][target];
        if(idx == nums.size() ){
            return target == 0 ? 0 : Integer.MIN_VALUE;
        }
        int ans1 = Integer.MIN_VALUE;
        if(target - nums.get(idx) >= 0) {
            ans1 = 1 + solver(nums, target - nums.get(idx), idx + 1, dp);
        }
        int ans2 = solver(nums, target, idx + 1, dp);
        int fans = Math.max(ans1, ans2) < 0 ? Integer.MIN_VALUE : Math.max(ans1, ans2);

        dp[idx][target] = fans;
        return fans;
    }
}
