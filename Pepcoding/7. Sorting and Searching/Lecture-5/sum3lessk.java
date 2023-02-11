public class sum3lessk {
    public static void main(String[] args) {
        
    }

    //Simply same as that bad boi
    public int threeSumSmaller(int[] nums, int target) {
        // Write your code here
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i < nums.length-2; i++){
            count += twoSum(nums, target-nums[i], i+1);
        }
        return count;
    }
    
    //lol it got submitted my bois
    public int twoSum(int[] nums, int tar, int si){
        int ei = nums.length-1;
        int count = 0;
        while(si < ei){
            
            int sum = nums[si] + nums[ei];
            if(sum < tar){
                count += ei - si;
                si++;
            }else{
                ei--;
            }
        }

        return count;
    }

}
