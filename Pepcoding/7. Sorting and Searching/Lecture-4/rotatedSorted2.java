public class rotatedSorted2 {
    public static void main(String[] args) {
        
    }   


    //BY SIR 
    //Time Complexity
    //Simple as that boi!
    //Big(O(n))

    public boolean search(int[] nums, int target) {
        int si = 0;
        int ei = nums.length -1;
        while(si <= ei){
            //simple as fuck code boi, why don't you get that no?
            //clear this edge case bois, very very important shi boi
            if(nums[si] == target) return true;
            //exact same logic as mine, but his implementation skills 
            //are pretty op for sure man
            int mid = ei - (ei-si)/2;
            if(nums[mid] == target){
                return true;
            }else if(nums[si] < nums[mid]){
                if(target >= nums[si] && target < nums[mid])
                    ei = mid-1;
                else   
                    si = mid+1;
            }else if(nums[mid] < nums[ei]){
                if(target <= nums[ei] && target > nums[mid])
                    si = mid+1;
                else
                    ei = mid-1;
            }else{
                si++;
            }
        }

        return false;
    }


}
