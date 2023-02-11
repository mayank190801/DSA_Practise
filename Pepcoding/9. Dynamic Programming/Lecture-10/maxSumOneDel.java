import java.util.Arrays;

public class maxSumOneDel {

    public static void main(String[] args) {
        int[] arr = {1,-2,-2,3};
        int ans = maximumSum(arr);
        System.out.println(ans);
    }

    //You can remove the making of left array, as you can make it during the runtime for sure
    //no worries to be done
    //he didn't handle that one specific condition, so think about it

    //SIR WAY OF CODING THIS SAME PROBLEM
    //LET'S TRY THAT FOR SURE
    public static int maxSum(int[] arr){
        int ans = Integer.MIN_VALUE;
        int len = arr.length;

        if(len == 1){
            return arr[0];
        }
        
        int[] lkad = new int[len];
        int[] rkad = new int[len];

        lkad[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            lkad[i] = Math.max(arr[i], lkad[i-1] + arr[i]);
        }
        rkad[len-1] = arr[len-1];
        for(int i = len - 2; i >= 0; i--){
            rkad[i] = Math.max(arr[i], rkad[i+1] + arr[i]);
        }

        for(int i = 1; i < len - 1; i++){
            int lk = lkad[i-1];
            int rk = rkad[i+1];

            ans = Math.max(ans, lk);
            ans = Math.max(ans, rk);
            ans = Math.max(ans, lk + rk);
        }

        ans = Math.max(ans, lkad[len-2]);
        ans = Math.max(ans, rkad[1]);
        // ans = Math.max(ans, lkad[len-1]);
        ans = Math.max(ans, rkad[0]);

        return ans;
    }



    public static int maximumSum(int[] arr) {
        //first make ending from left
        //next make ending from right

        //then apply kadanes on each step, simple as that no?
        int n = arr.length;
        int[] left = new int[n+1];
        int[] right = new int[n+1];

        //now for left
        int csum = 0;
        for(int i= 0; i < n; i++){
            csum += arr[i];
            left[i+1] = csum;
            if(csum < 0){
                csum = 0;
            }
        }

        //for for right baby
        csum = 0;
        for(int i= n-1; i >= 0; i--){
            csum += arr[i];
            right[i] = csum;
            if(csum < 0){
                csum = 0;
            }
        }

        left[0] = Integer.MIN_VALUE;
        right[n] = Integer.MIN_VALUE;
        
        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));
     
        // now one loop for left tor ight
        int cans = arr[0];
        for(int i : arr) cans = Math.min(cans, i);
        
        for(int i = 0; i < n; i++){
            // int curr = 
            int curr = -1;
            if(left[i] < 0 && right[i+1] < 0){
                curr = Math.max(left[i], right[i+1]);
            }else{
                curr = Math.max(left[i], 0) + Math.max(right[i+1], 0);
            }

            if(arr[i] > 0) curr += arr[i];
            // System.out.println(curr);
            cans = Math.max(curr, cans);
        }
    
        return cans;
    }
    
}
