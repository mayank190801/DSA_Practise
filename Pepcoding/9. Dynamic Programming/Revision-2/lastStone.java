public class lastStone{
	public static void main(String[] args){
		int[] stones = {2,7,4,1,8,1};
		int answer = lastStoneWeightII(stones);
		System.out.println(answer);
	}

	public static int lastStoneWeightII(int[] stones) {

		int total = 0;
		for(int num : stones){
			total += num;
		}
		int ftotal = total;
		total = total/2 + 1;

		int n = stones.length;
		boolean[][] dp = new boolean[total + 1][n + 1];
		dp[0][0] = true;

		for(int i= 0; i <= total; i++){
			for(int j = 1; j <= n; j++){
				dp[i][j] = dp[i][j-1];
				//otherwise that sum should be possible 
				if(i - stones[j-1] >= 0 && !dp[i][j]){
					dp[i][j] = dp[i - stones[j-1]][j-1];
				}
			}
		}

		int min = Integer.MAX_VALUE;
		for(int i= 0; i <= total; i++){
			if(dp[i][n]) min = Math.min(min, Math.abs(2 * i  - ftotal));
		}

		return min;
    }
}
