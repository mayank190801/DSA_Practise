public class leetcode25 {
    //this one is going to be O(n^2)

    public static void main(String[] args) {

    }

    public static int maximumJumps(int[] nums, int target) {
        int len = nums.length;
        int[] jumps = new int[len];
        //final ans will be written for index 0 only
        for(int i = len - 2; i >= 0; i--){
            int curr = -1;
           for(int j = i + 1; j < len; j++){
               if(jumps[j] == -1) continue;
               if(Math.abs(nums[i] - nums[j]) <= target) curr = Math.max(curr, jumps[j] + 1);
           }
           jumps[i] = curr;
        }
        return jumps[0];
    }


}
