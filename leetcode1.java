class leetcode1 {
    public int minimumSum(int[] nums) {
        int len = nums.length;
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < len - 2; i++){
            for(int j = i + 1; j < len - 1; j++){
                for(int k = j + 1; k < len; k++){
                    //so in this case i, j, k will always be different for sur e
                    // sum should be the least
                    if(nums[i] < nums[j]  && nums[j] > nums[k]){
                        ans = Math.min(ans, nums[i] + nums[j] + nums[k]);
                    }
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}