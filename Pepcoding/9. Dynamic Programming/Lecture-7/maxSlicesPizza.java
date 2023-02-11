public class maxSlicesPizza {
    
    //RECURSION
    //Same as house robber -2 + Limit on the number of pickups baby!!
    public static int maxSizeSlices(int[] nums) {
        int len = nums.length;
        return Math.max(pizzaSlices(nums, 0 , len-2, len/3), pizzaSlices(nums, 1, len-1, len/3));
    }
    
    //Recursino code is extremely important for this question!!!
    public static int pizzaSlices(int[] slices, int si , int ei, int k){
        if(si > ei || k == 0) return 0;
        
       //include
        int inc = pizzaSlices(slices, si+2, ei, k - 1) + slices[si];
        
        //exclude
        int exc = pizzaSlices(slices, si + 1, ei, k); 
        return Math.max(inc, exc);
    }


    //MEMOIZATION
    public static int maxSizeSlices(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[nums.length][len/3 + 1];
        int ans1 = pizzaSlices(nums, 0 , len-2, len/3, dp);
        dp = new int[nums.length][len/3 + 1];  //gotta refresh this bad boi
        int ans2 = pizzaSlices(nums, 1, len-1, len/3, dp);
        return Math.max(ans1, ans2);
    }
    
    //Recursion code is extremely important for this question!!!
    //Gotta get god level at Recursion and DP bruh (super duper important)
    public static int pizzaSlices(int[] slices, int si , int ei, int k, int[][] dp){
        if(si > ei || k == 0) return 0;

        if(dp[si][k] != 0){
            return dp[si][k];
        }
        
        //include
        int inc = pizzaSlices(slices, si+2, ei, k - 1, dp) + slices[si];
        
        //exclude
        int exc = pizzaSlices(slices, si + 1, ei, k, dp);
        return dp[si][k] = Math.max(inc, exc);
    }



}
