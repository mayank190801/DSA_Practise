import java.util.Arrays;

public class maxSum3NonOverlap {

    public static void main(String[] args) {
        int[] nums = {7,13,20,19,19,2,10,1,1,19};
        int k = 3;

        int[] rec = maxSumOfThreeSubarrays(nums, k);
        System.out.println(Arrays.toString(rec));
    }

    //LET'S GO , Let's fucking GOOOO!!!!
    //Simply make left and right, then figure from there and out
    //one csum , then baaki is leftMax and rightMax till now simple as that
    //Okie?

    //this is pretty simple for sure man!!!
    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {

        int n = nums.length;
        int[] PS = new int[n+1];
        for(int i = 0; i < n; i++){
            PS[i+1] = nums[i] + PS[i];  //simple boi
        }
        
        // System.out.println(Arrays.toString(PS));
        
        int[] left = new int[n];
        int[] right = new int[n];

        //they will store the ans, simple
        //not from starting, but from behind baby
        //gotcha???

        // left[0] = k-1;
        // left[1] = k-1;  //simple as that \
        for(int i= 0; i < k; i++){
            left[i] = k-1;
        }

        for(int i = k; i < n; i++){
            int csum = PS[i+1] - PS[i - k + 1];
            int bestTill = left[i-1];
            // System.out.println(bestTill);
            int psum = PS[bestTill + 1] - PS[bestTill - k + 1];

            //pretty obvious shit for sure
            if(csum > psum){
                left[i] = i; //simple as that
            }else{
                left[i] = left[i-1];
            }
        }

        //simple make something similar for above shit
        // right[n-1] = n-k;
        // right[n-2] = n-k;  //simple as that 
        for(int i = n-1; i >= n-k; i--){
            right[i] = n-k;
        }

        for(int i = n-k-1; i >= 0; i--){
            int csum = PS[i+k] - PS[i];
            int bestTill = right[i+1];
            // System.out.println(bestTill);
            int psum = PS[bestTill + k] - PS[bestTill];

            //pretty obvious shit for sure
            if(csum >= psum){
                right[i] = i; //simple as that
            }else{
                right[i] = right[i+1];
            }
        }

        // System.out.println(Arrays.toString(PS));
        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));
        // System.out.println(Arrays.toString(nums));

        int ans = Integer.MIN_VALUE;
        int[] answer = new int[3];  //pretty obvious
        for(int i = 2*k-1; i < n-k; i++){
            //indexes
            int lidx = left[i-k];
            int ridx = right[i+1];
            int cidx = i;

            // System.out.println(lidx + " " + cidx  + " " + ridx);

            int lSum =  PS[lidx + 1] - PS[lidx - k + 1];
            int rSum = PS[ridx + k] - PS[ridx];
            int cSum = PS[i+1] - PS[i-k+1];  //this is pretty doable too
 
            // System.out.println(lSum + " " + cSum + " " + rSum);
            int cans = lSum + rSum + cSum;
                
            if(cans > ans){
                answer[0] = lidx-k+1;
                answer[1] = i-k+1;
                answer[2] = ridx;
                ans = cans;
            }
        }

        return answer;
    }
    
}

// [7,13,20,19,19,2,10,1,1,19]
// 3
