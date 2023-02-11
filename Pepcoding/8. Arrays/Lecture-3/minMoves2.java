import java.util.Arrays;

public class minMoves2{

    //METHOD -1  (Sort and check for every position how many steps???)
    //METHOD -2  (A bit more optimised) (Do this above for only the middle positions) 
    
    //method 2 works in one traversal where as the above one in 2 traversals
    //up to you whatever suits you best
    //Why middle is more optimised????? (think about it)

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for(int i =0; i < nums.length/2 ; i++){
            ans += (nums[nums.length - i - 1] - nums[i]);
        }
        return ans;
    }

}