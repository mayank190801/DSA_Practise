import java.util.ArrayList;

class Solution {

    //I have done using extra space, but you can do it within nums as well
    //using ans variable only!!
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> lis = new ArrayList<>();
        lis.add(nums[0]);

        for(int i = 1; i < nums.length; i++){  //think about it once for sure
            if(lis.get(lis.size() - 1) < nums[i]){
                lis.add(nums[i]);
            }else{
                //apply binary search and update the index
                int idx = binaryIndex(nums[i], lis);
                lis.set(idx, nums[i]);
            }
        }

        return lis.size();
    }

    public int binaryIndex(int num, ArrayList<Integer> lis){

        //apply binary search and find the index where it should be placed
        int l = 0;
        int r = lis.size() -1;
        int aidx = -1;

        while(l <= r){
            int mid = (l + r)/2;
            if(lis.get(mid) >= num){
                aidx = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }   

        return aidx;
    }



}