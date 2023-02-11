public class sum4 {
    public static void main(String[] args) {
        
    }

    //AS SUM METHOD IS GOING ON FOR NOW 
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < nums.length-3; i++){
            //a bit faster, and definitely less amount of code for sure
            //it's freaking sorted man, use that property and dont' bring 
            //any datat structure in this game for sure
            if(i>0 && nums[i-1] == nums[i]) continue;
            threeSum(nums, target-nums[i], i+1, ans, i);
        }
        return ans;
        
    }
    
    public void threeSum(int[] nums, int tar, int si, List<List<Integer>> ans, int ele) {
        for(int i = si; i < nums.length-2; i++){
            if(i>si && nums[i-1] == nums[i]) continue;
            twoSum(nums, tar-nums[i], i+1, ans, ele);
        }
    }

    //lol it got submitted my bois
    public void twoSum(int[] nums, int tar, int si, List<List<Integer>> ans, int ele){
        int ei = nums.length-1;
        int st =si-1;
        
        while(si < ei){
            if(ei < nums.length-1 && nums[ei] == nums[ei+1]){
                ei--;
                continue;
            }

            int sum = nums[si] + nums[ei];
            if(sum == tar){
                //add it in the answer bois
                ans.add(Arrays.asList(nums[ele], nums[st],nums[si], nums[ei]));
                ei--;
            }else if(sum < tar){
                si++;
            }else{
                ei--;
            }
        }
    }

}
