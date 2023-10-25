
public class leetcode5 {
    public static void main(String[] args) {
       //this could be optimised like ton
       //why do you even need pair brother? are you fucking dumb

    }

    public static int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int max = -1;
        int min = -1;
        //let's solve it asap brother,
        int len = nums.length;
        for(int i = 0; i < len - indexDifference; i++){
            int curr = nums[i];
            if(max == -1 || curr > nums[max]){
                max = i;
            }
            if(min == -1 ||curr < nums[min]){
                min = i;
            }
            int value = nums[i + indexDifference];
            if(Math.abs((value - nums[max])) >= valueDifference){
                return new int[]{max, i + indexDifference};
            }
            if(Math.abs((value - nums[min]))>= valueDifference){
                return new int[]{min, i + indexDifference};
            }
        }
        return new int[]{-1, -1};
    }

}
