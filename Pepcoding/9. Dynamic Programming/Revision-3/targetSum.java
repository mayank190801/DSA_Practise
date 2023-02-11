public class targetSum{
	public static void main(String[] args){
		int[] nums = {1,1,1,1,1};
		int target = 3;

		//think about this and solve it bruh
		int ans = findTargetSumWays(nums, target);
		System.out.println(ans);

	}

	//now thinking about this and solving this problem!
	public static int findTargetSumWays(int[] nums, int target) {
		//make the dp size bruh
		int negSum = 0;
		for(int i : nums){
			negSum += i;
		}

		int n = nums.length;
		int[][] dp = new int[2*negSum + 1][n + 1];

		dp[negSum][0] = 1;  //initial case toh yehi bnta hai boss! 

		for(int i = 0; i < dp.length; i++){
			for(int j = 1; j <= n; j++){

				int pos = i + nums[j-1];
				if(pos >= 0 && pos < dp.length){
					dp[i][j] += dp[pos][j-1];
				}

				int neg = i - nums[j-1]; 
				if(neg >= 0 && neg < dp.length){
					dp[i][j] += dp[neg][j-1];	
				}

			}
		}

		for(int i = 0; i < dp.length; i++){
			System.out.println(dp[i][n]);
		}
		return dp[negSum + target][n];
    }


}