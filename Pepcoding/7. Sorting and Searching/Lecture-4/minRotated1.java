public class minRotated1 {
    public static void main(String[] args) {
        
    }

    //SOlution for without duplicated bois
    public int findMin(int[] nums) {
        int si = 0; 
        int ei = nums.length-1;
        int last = nums[nums.length-1];
        
        //important stuff
        while(si < ei){
            int mid = (si+ei)/2;
            //check if min is found

            if(nums[mid] < last){
                ei = mid;
            }else{
                si = mid+1;
            }
        }

        return nums[ei];
    }

    //just make last element as the reference for sure
    //easy enough bois
    public int findMin(int[] nums) {
        int si = 0; 
        int ei = nums.length-1;
        int last = nums[nums.length-1];
        
        //important stuff
        while(si < ei){
            int mid = (si+ei)/2;
            //check if min is found

            if(nums[mid] < nums[ei]){
                ei = mid;
            }else if(nums[mid] > nums[ei]){
                si = mid+1;
            }else{
                ei--;
            }
        }

        return nums[ei];
    }


}
