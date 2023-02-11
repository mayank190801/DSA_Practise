import java.util.Arrays;

public class sum2lessk {
    public static void main(String[] args) {
        
    }

    //let's solve for this bad boi

    //FOR COUNT
    public int twoSum5(int[] nums, int target) {
        int si = 0;
        int ei = nums.length-1;
        int count = 0;
        Arrays.sort(nums);

        while(si < ei){
            int curr = nums[si] + nums[ei];
            if(curr <= target){
                count += ei - si;
                si++;
            }else{
                ei--;
            }
        }

        return count;
    }

    //FOR MAXIMISE (for less than target) (leetcode version)
    public int twoSum5(int[] nums, int target) {
        int si = 0;
        int ei = nums.length-1;
        int max = 0;
        Arrays.sort(nums);

        while(si < ei){
            int curr = nums[si] + nums[ei];
            if(curr < target){
                max = Math.max(max, curr);
                si++;
            }else{
                ei--;
            }
        }

        return max;
    }

    

}
