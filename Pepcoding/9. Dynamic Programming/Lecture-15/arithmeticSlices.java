public class arithmeticSlices {
    public static void main(String[] args) {
        
    }

    //O(n) time - subarray one - self code!!!! - dope shit
    //O(n) space
    //this could be solved with O(1) space!!!
    public int numberOfArithmeticSlices(int[] nums) { //let's figure this one out 
        int n = nums.length;
        int[] dp = new int[n];
        int sum = 0;

        for(int i = 2; i < n; i++){
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i - 2]) {
                dp[i] = dp[i-1] + 1;
            }
            sum += dp[i];
        }

        return sum;    
    } 

    //Sir solve - O(n) - time
    // O(1) - space 
    //Always look at your dp and figure out if you can reduce some more space or not!!!
    //That is really really important for sure to do!
    public int numberOfArithmeticSlicesZeroSpace(int[] nums) { //let's figure this one out 
        int n = nums.length;
        int last = 0;
        int sum = 0;

        for(int i = 2; i < n; i++){
            if(nums[i] - nums[i-1] == nums[i-1] - nums[i - 2]) {   
                sum += last + 1;
                last = last + 1;
            }else{
                last = 0;
            }
        }

        return sum;    
    } 
    
}
