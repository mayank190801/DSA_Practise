import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class sum3 {
    public static void main(String[] args) {
        
    }

    //2sum
    //sorted 
    //2 pointer and hashmap both in O(n)
    //but different space complexity for both of them
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < nums.length-2; i++){
            //a bit faster, and definitely less amount of code for sure
            //it's freaking sorted man, use that property and dont' bring 
            //any datat structure in this game for sure
            if(i>0 && nums[i-1] == nums[i]) continue;
            twoSum(nums, -nums[i], i+1, ans);
        }
        return ans;
    }

    //lol it got submitted my bois
    public void twoSum(int[] nums, int tar, int si, List<List<Integer>> ans){
        int ei = nums.length-1;
        
        while(si < ei){
            if(ei < nums.length-1 && nums[ei] == nums[ei+1]){
                ei--;
                continue;
            }

            int sum = nums[si] + nums[ei];
            if(sum == tar){
                //add it in the answer bois
                ans.add(Arrays.asList(nums[si], nums[ei], -tar));
                ei--;
            }else if(sum < tar){
                si++;
            }else{
                ei--;
            }
        }
    }


}


    
}
