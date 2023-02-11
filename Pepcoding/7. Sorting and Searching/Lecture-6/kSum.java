import java.util.*;

public class kSum{
    public static void main(String[] args) {
        
    }

    //ksum
    //RECURSION VERSION OF KSUM 
    //TIME COMPLEXITY FOR THIS BABY

    //DO THIS ON YOUR OWN FOR SURE BOI
    //O(n^k-1)
    //Space O(k-1 + k);

    //now for the updated one 
    //T.C O(n^k/2)

    public void ksum(int[] nums, int k, int st,int tar, List<List<Integer>> ans , List<Integer> sans){

        if(k == 2){  //solve for 2 sum
            twoSum(nums, st, tar, ans ,sans);
            return;
        }

        for(int i= st ; i < nums.length ; i++){
            if(i > st && nums[i] == nums[i-1]){
                continue;
            }
            sans.add(nums[i]);
            ksum(nums, k-1, i+1,tar-nums[i], ans, sans);
            sans.remove(sans.size()-1);
        }
    }

    public void twoSum(int[] nums, int st, int tar,  List<List<Integer>> ans , List<Integer> sans ){
        int si = st;
        int ei = nums.length;
        while(si < ei){

            //check for duplicay to remove
            if(ei < nums.length-1 && nums[ei] == nums[ei+1]){
                ei--;
                continue;
            }

            int sm = nums[si] + nums[ei];
            if(sm == tar){
                sans.add(nums[si]);
                sans.add(nums[ei]);
                ans.add(new ArrayList<>(sans));
                sans.remove(sans.size()-1);
                sans.remove(sans.size()-1);
                ei--;
            }else if(sm < tar){
                si++;
            }else{
                ei--;
            }
        }
    }


}