public class largestNumberTwice {

    //METHOD - 1
    //SORTING for sure
    
    //METHOD - 2
    //Two traversals ofc
    
    //METHOD - 3
    //Single traversal baby
    //This bad boi works
    
    public int dominantIndex(int[] nums) {
       
        int max = 0;
        int ans = 0;
        int smax = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > max){
                smax = max;
                max = nums[i];
                ans = i;
                continue;
            }

            if(nums[i] > smax){
                smax = nums[i];
            }
        }

        if(nums.length == 1) return 0;
        return 2*smax <= max ? ans : -1;

    }
}
