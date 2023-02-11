public class productArrayItself {

    //All in O(n)
    //METHOD -1 (Using division operator) //tho not allowed
    //METHOD -2 (using leftProd, Using Right Prod)
    //METHOD -3 (Using rightProd only)
    //METHOD -4 (merging ans & rightProd) //no extra space boi

    //THIS CODE RUNS PERFECTLY
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length; 
        int[] ans = new int[n];

        //Making of rightProd in the arraySpace only
        int rightProd = 1;
        for(int i= n-1; i >= 0; i--){
            rightProd *= nums[i];
            ans[i] = rightProd;
        }

        //A bit clearer code bois (no need to handle edge cases)
        int leftProd = nums[0];
        ans[0] = ans[1];
        for(int i = 1; i < n-1; i++){
            ans[i] = leftProd * ans[i+1];
            leftProd *= nums[i];
        }
        ans[n-1] = leftProd;

        return ans;
    }
}
