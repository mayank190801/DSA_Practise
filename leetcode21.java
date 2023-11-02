public class leetcode21 {

    public static void main(String[] args) {

    }

    //so this should makes more sense
    //I did solve it, but it looks ugly as fuck, I want to make it 10x better, how can I do that?

    public long maxScore(int[] nums, int x) {
        long evenMax = (nums[0] & 1) == 0 ? nums[0] : Integer.MIN_VALUE + 10_000_000;
        long oddMax = (nums[0] & 1) != 0 ? nums[0] : Integer.MIN_VALUE + 10_000_000;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] % 2== 0){
                evenMax = nums[i] + Math.max(evenMax, oddMax - x);
            }else{
                oddMax = nums[i] + Math.max(oddMax, evenMax - x);
            }
        }
        return Math.max(evenMax, oddMax);
    }
}
