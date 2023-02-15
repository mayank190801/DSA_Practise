public class ReversePairs {

    public static void main(String[] args) {
        int[] nums = {2,4,3,5,1};
        int ans = reversePairs(nums);

        System.out.println(ans);
    }

    public static int sortTwoArrays(int[] nums, int[] one, int[] two){

        int oi = 0;
        int ti = 0;
        int idx = 0;

        while(idx < nums.length){
            int oneVal = oi < one.length ? one[oi] : Integer.MAX_VALUE;
            int twoVal = ti < two.length ? two[ti] : Integer.MAX_VALUE;

            nums[idx] = Math.min(oneVal, twoVal);
            idx++;

            if(oneVal < twoVal) oi++; else ti++;
        }

        return countAnswers(one, two);
    }

    public static int reversePairs(int[] nums) {
        int len = nums.length;
        if(len <= 1) return 0;
        int ans = 0;
        //usage of long is important in this question for sure
        //becuase number are pretty much equal to the max for sure

        int middle = len/2;
        int[] one = new int[middle];
        int[] two = new int[len - middle];

        //this should be easy enough for me by now -- please focus hard
        for(int i = 0; i < middle; i++){
            one[i] = nums[i];
        }

        for(int i = 0; i < (len - middle); i++){
            two[i] = nums[middle + i];
        }

        ans += reversePairs(one);
        ans += reversePairs(two);

        //now sort and return some answer
        ans += sortTwoArrays(nums, one, two);
        return ans;
    }

    public static int countAnswers(int[] one, int[] two){
        int count = 0;
        int ptr = 0;
        for(int i = 0; i < one.length; i++){
            while(ptr < two.length && ((long)two[ptr]*(long)2 < (long)one[i])) ptr++;
            count += ptr;
        }
        return count;
    }




}
