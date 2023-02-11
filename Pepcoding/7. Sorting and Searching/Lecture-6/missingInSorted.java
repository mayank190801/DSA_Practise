public class missingInSorted {
    public static void main(String[] args) {
        
    }

    //SOLVING IN O(n) , just use kth mising code
    //SOLVING IN O(logn) , below we will do it for sure
    //JUST SIMPLE CHECKING QUESTION BOSS
    //PRETTY NASTY APPROACH FOR SURE BOIS
    public int missingElement(int[] nums, int k){
        int si = 0;
        int ei = nums.length-1;
        while(si <= ei){
            int mid = (si + ei)/2;
            int miss = countMissing(nums, mid);
            if(miss >= k){
                ei = mid-1;
            }else{
                si = mid+1;
            }
        }
        return nums[ei] - countMissing(nums, ei) + k;
    }

    public int countMissing(int[] nums, int i){
        return nums[i] - nums[0] - i;
    }

}
