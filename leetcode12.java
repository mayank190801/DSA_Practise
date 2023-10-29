import java.util.Arrays;

public class leetcode12 {
    public static void main(String[] args) {

    }

    //now we are at this position - it will all be in muscle memory after some point
    //that is the cooolest part for sure 4
    //code our solution here, simple
    public static int findKOr(int[] nums, int k) {
        int [] bits = new int[35];
        for(int i = 0; i < nums.length; i++){
            int curr = nums[i];
            int idx = 0;
            while(curr != 0){
               if((curr & 1) == 1){
                   bits[idx]++;
               }
               curr = curr >> 1;
               idx++;
            }
        }
        int ans = 0;
        for(int i = 0; i < 35; i++){
            if(bits[i] >= k){
                ans += Math.pow(2, i);
            }
        }

        System.out.println(Arrays.toString(bits));
        return ans;
    }

    public static long minSum(int[] nums1, int[] nums2) {
        //thoda socho, find the total sum, and number of empty places
        long sum1 = 0, sum2 = 0;
        int em1 = 0, em2 = 0;
        for(int i = 0; i < nums1.length; i++){
            if(nums1[i] == 0) em1++;
            sum1 += nums1[0];
        }
        for(int i = 0; i < nums2.length; i++){
            if(nums2[i] == 0) em2++;
            sum2 += nums2[0];
        }
        //so we have the count now, now if
        if(em1 == 0){
            if(sum2 + em2 > sum1) return -1;
        }
        if(em2 == 0){
            if(sum1 + em1 > sum2) return -1;
        }


        return Math.max(sum1 + em1, sum2 + em2);


    }

}
