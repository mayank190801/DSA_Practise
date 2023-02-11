public class kadanes {

    //(types of kadanes we will study)
    //normal kadanes
    //k concat
    //one deletion
    //non onverlapping
    //ugly number

    //famous question
    public static int maxSubArray(int[] nums) {
        //sum, length, starting index (figure out all those bruh)
        int ans = Integer.MIN_VALUE;
        int csum = 0;
        for(int ele : nums){
            csum += ele;
            if(ans < csum){
                ans = csum; 
            }

            if(csum < 0){
                csum = 0;
            }
        }

        return ans;
    }

    //k concatenate
    //brilliant solve for sure bruh!!! brilliant
    public static int kConcatenationMaxSum(int[] arr, int k) {
        //simple question
        long mod = 1_000_000_007;
        //sum < 0 && sum > 0 cases!!
        if(k == 1){
            return maxSubArray(arr);
        }

        long ans = 0;
        int sum = 0;

        for(int ele : arr){
            sum += ele;
        }

        int len = arr.length;
        int[] dbl = new int[len*2];
        for(int i = 0; i < dbl.length; i++){
            dbl[i] = arr[i%len];
        }

        if(sum < 0){
            ans = maxSubArray(dbl);
        }else{
            ans = ((k-2)%mod * sum%mod)%mod + (maxSubArray(dbl)%mod)%mod;
        }

        if(ans < 0){
            return 0;
        }else{
            return (int) ans;
        }
        
    }

}
