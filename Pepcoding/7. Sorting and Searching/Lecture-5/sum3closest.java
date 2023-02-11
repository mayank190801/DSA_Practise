import java.util.Arrays;

import javax.lang.model.type.IntersectionType;

public class sum3closest{
    public static void main(String[] args) {
        
    }

    //DEFINITELY PRETTY PERFECT CODE FOR SURE
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = Integer.MIN_VALUE;
        for(int i= 0; i < nums.length-2; i++){
            int sum = nums[i] + twoSumClosest(nums, target-nums[i], i);
            if(ans == Integer.MIN_VALUE || Math.abs(sum - target) < Math.abs(ans-target)){
                ans = sum;
            }
        }

        return ans;
    }

    public int twoSumClosest(int[] nums, int target, int si){
        int ans = Integer.MIN_VALUE;
        si++;
        int ei = nums.length-1;
        while(si < ei){
            //when do the updation for sure shoul be clear bois
            int sum = nums[si] + nums[ei];
            if(ans == Integer.MIN_VALUE || Math.abs(sum - target) < Math.abs(ans-target)){
                ans = sum;
            }

            if(sum == target){
                return sum;
            }else if(sum < target){
                si++;
            }else{
                ei--;
            }
        }

        return ans;
    }


}