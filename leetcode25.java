import java.util.Arrays;

public class leetcode25 {
    //this one is going to be O(n^2)

    public static void main(String[] args) {
        //this could work or not, idk
    }

    public static int maximumJumps(int[] nums, int target) {
        int len = nums.length;
        int[] jumps = new int[len];
        Arrays.fill(jumps, -1);
        jumps[len - 1] = 0;
        for(int i = len - 2; i >= 0; i--){
           for(int j = i + 1; j < len; j++){
               if(jumps[j] == -1) continue;
               if(Math.abs(nums[i] - nums[j]) <= target) jumps[i] = Math.max(jumps[i], jumps[j] + 1);
           }
        }
        return jumps[0];
    }


}
