public class firstMissing {

    //O(n) //only two traversals
    //O(1) //space bois
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while(i < nums.length){
            if(nums[i] >= 0 && nums[i] <= nums.length && nums[nums[i]-1] != nums[i]){
                swap(nums, i , nums[i] - 1);
            }else{
                i++;
            }
        }

        for( i= 0; i < nums.length; i++)
            if(nums[i] != i + 1) return i+1;
        
        return nums.length+1;
    }

    public static void swap(int[] nums, int i , int j){
        //solving from right to left for sure man!
        nums[j] = ((nums[i] + nums[j]) - (nums[i] = nums[j]));
    }
    
}
