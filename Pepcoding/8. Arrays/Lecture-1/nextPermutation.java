public class nextPermutation {

    //I WROTE THIS PIECE OF CODE BOIS
    public void nextPermutation(int[] nums) {
        //let's code this bitch down

        //first find the smallest element in their bois
        int n = nums.length;
        int set = -1;
        for(int i = n-2; i>= 0; i--){
            if(nums[i] < nums[i+1]){
                set = i;
                break;
            }
        }

        //edge case bois
        if(set == -1){
            reverse(nums, 0, nums.length-1);
            return;
        }

        //otherwise swap from the next big element
        int swapper = set+1;
        for(int i= n-1; i > set; i--){
            if(nums[i] > nums[set]){
                swapper = i;
                break;
            }
        }
        
        swap(nums, set, swapper);
        reverse(nums, set+1, nums.length-1);
        return;
    }

    public void reverse(int[] nums, int i , int j){
        while(i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public void swap(int[] nums, int i , int j){
        nums[i] = (nums[i] + nums[j]) - (nums[j] = nums[i]);
    }
    
}
