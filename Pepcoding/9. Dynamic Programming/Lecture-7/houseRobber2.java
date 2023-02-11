public class houseRobber2 {
    
    //MEthod - pretty fucking observant method (def you have to see once)
    //You just rob twice, and take like below
    //HOUSE ROBBER - 2
    //FREAKIN JUST DON'T TAKE THAT ELEMENT AND YOU ARE GOOD

    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        return Math.max(rob2(nums, 0, nums.length-2), rob2(nums, 1, nums.length-1));
    }

    public static int rob2(int[] nums, int si, int ei) {

        if(si == ei) return nums[si];

        int rright = nums[ei];
        int right = Math.max(nums[ei], nums[ei-1]);

        for(int i = ei-2 ; i >= si; i--){
            int curr = Math.max(right, rright + nums[i]);
            rright = right;
            right = curr;
        }

        return right;
    }


}
