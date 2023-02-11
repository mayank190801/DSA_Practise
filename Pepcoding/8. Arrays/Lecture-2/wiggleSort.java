public class wiggleSort {
    //baby 
    //Time complexity - (O(n))
    //Space complexity - (O(1))

    //METHOD - 1 Sort (O(nlogn)) & then keep swapping them! 
    //METHOD - 2 FUCKING EASY, I AM DUMB (swap from left only when needed)

    
    //JUST THINK EVEN MORE HARD BOIS, DON'T GIVE UP UP UP NEVER GIVE UP
    //NEVER GIVE UP, NEVER GIVE UP, NEVER GIVE UP, NEVER GIVE UP
    public void wiggleSort(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            if(i%2 == 0){
                if(nums[i-1] > nums[i]){
                    swap(nums, i, i-1);
                }
            }else{
                if(nums[i-1] < nums[i]){
                    swap(nums, i, i-1);
                }
            }
        }
    }

    public static void swap(int[] nums, int i, int j){
        nums[i] = (nums[i] + nums[j]) - (nums[j] = nums[i]);
    }

}
