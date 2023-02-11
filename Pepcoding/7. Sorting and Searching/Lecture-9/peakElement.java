public class peakElement {
    public static void main(String[] args) {
        
    }

    //think about this one for sure
    //ACCEPTED IN 0MS
    public int findPeakElement(int[] nums) {
        int n = nums.length;

        int si = 0;
        int ei = n-1;

        //an answer always exist for sure
        //return index for sure
        while(si <= ei){
            int mid = (si + (ei - si)/2);

            long val = nums[mid];
            long left = (mid - 1) < 0 ? Long.MIN_VALUE : nums[mid-1];
            long right = (mid + 1) >= n ? Long.MIN_VALUE : nums[mid+1];

            if(val > left && val > right) return mid;
            else if( val > left ){
                si = mid+1;
            }else{
                ei = mid-1;
            }
        }

        return -1;
    }


    
}
