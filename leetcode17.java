import java.util.List;

public class leetcode17 {

    public static void main(String[] args) {

    }

    //doesn't have too much time, have to push harder now, day in day out - simple as that
    //6-12 dsa bitch - office days pr something else if you can simple as that
    public static boolean canSplitArray(List<Integer> nums, int m) {
        int total = 0;
        for(int i : nums) total += i;
        return solver(nums, m, 0, nums.size() - 1, total, new int[nums.size()][nums.size()]);
    }

    public static boolean solver(List<Integer> nums, int m, int i , int j, int sum, int[][] dp){
        if(dp[i][j] != 0) return dp[i][j] == 1;
        if(i == j)  return true;
        int csum = 0;
        boolean possible = false;
        for(int k = i; k < j; k++){
            csum += nums.get(k);
            sum -= nums.get(k);

            boolean left = false;
            if(k - i + 1 == 1 || csum >= m){
                left = solver(nums, m, i, k, csum, dp);
            }
            boolean right = false;
            if(j - k == 1 || sum >= m){
                right = solver(nums, m, k + 1, j, sum, dp);
            }
            possible = possible || (left && right);
        }

        dp[i][j] = possible ? 1 : -1;
        return possible;
    }




}
