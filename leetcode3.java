import java.util.Arrays;

public class leetcode3 {
    public static void main(String[] args) {
        //now let's work on improving this particular solution, as much as we can
        //in time complexity and space and the style of code written
        //daily work on that ability of yours! to improve the code quality brother

    }

    public static int minimumSum(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];

        int small = nums[0];
        for(int i = 1; i < len-1; i++){
            if(nums[i] <= small){
               small = Math.min(nums[i], small);
               left[i] = -1;
            }else{
                left[i] = small;
            }
        }
       small = nums[len - 1];
       for(int i = len - 2; i > 0; i--){
            if(nums[i] <= small){
               small = Math.min(nums[i], small);
               right[i] = -1;
            }else{
                right[i] = small;
            }
        }

       int ans = Integer.MAX_VALUE;
       for(int i = 1; i < len - 1; i++){
           if(left[i] == -1 || right[i] == -1) continue;
           ans = Math.min(nums[i] + left[i] + right[i], ans);
       }
       return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
