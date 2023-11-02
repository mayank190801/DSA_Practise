public class leetcode21 {

    public static void main(String[] args) {

    }

    //so this should makes more sense
    public long maxScore(int[] nums, int x) {
        long evenMax = 0;
        long oddMax = 0;
        int len = nums.length;
        if(nums[0]%2 == 0){
            evenMax = nums[0];
            oddMax = Integer.MIN_VALUE + 10_000_000;
        }else{
            oddMax = nums[0];
            evenMax = Integer.MIN_VALUE + 10_000_000;
        }
        for(int i = 1; i < len; i++){
            boolean even = nums[i] % 2 == 0;
            long newMax = nums[i] + Math.max(evenMax - (!even ? x : 0) , oddMax - (even ? x : 0));
            if(even) evenMax = newMax; else oddMax = newMax;
        }
        return Math.max(evenMax, oddMax);
    }
}
