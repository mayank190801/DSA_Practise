public class maxSumNonOverlap {
    public static void main(String[] args) {
        
    }

    //think about this one for sure!
    //BRUTE FORCE
    //left se ek array and right se ek array m and n lenth max ki
    //har point pr aake left and right ka max dheke rakhlo simple
    //simple

    //One more logic
    //Take max 3 and then max 2 (this won't work for sure)

    //METHOD - 3 (single traversal)
    //Simple as fuck!!! 
    //just take once 3 ka sum , and 2 ka sum at some index, and then 
    //find prev max 2 and max 3 till that point!!! 
    //Possible in one iteration bois!! (pretty cool for sure)
    //We are going to code this one

    public int maxSumTwoNoOverlap(int[] nums, int n, int m) {
        int ans = 0;
        for(int i= 1; i < nums.length; i++){
            nums[i] += nums[i-1];
        }

        int mlen = nums[m-1];
        int nlen = nums[n-1];

        ans = nums[m+n-1];
        for(int i = m + n; i < nums.length; i++){
            mlen = Math.max(mlen, nums[i-n] - nums[i-m-n]);
            ans = Math.max(ans, nums[i] - nums[i-n] + mlen);
            nlen = Math.max(nlen, nums[i-m] - nums[i-m-n]);
            ans = Math.max(ans, nums[i] - nums[i-m] + nlen);
        }
        
        return ans;
    }
    
}
