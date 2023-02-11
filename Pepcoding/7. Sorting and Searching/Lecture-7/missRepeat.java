public class missRepeat{
    public static void main(String[] args) {
        
    }

    //let's solve this bad boi
    //METHOD 1 - 2 traversals ofc
    //METHOD 2 - 1 single traversal to find both (solved below)

    public int[] missingAndRep(int[] nums){
        int miss = -1;
        int rep = -1;
        for(int i= 0; i < nums.length; ){
            int cl = nums[i] -1;
            if(nums[cl] == cl+1){
                //updation on similarity for sure bois
                if(cl == i){
                    i++;
                }else if(rep != -1){
                    miss = i+1;
                    i++;
                }else{
                    rep = nums[i];
                    miss = i+1;
                    i++;
                }
            }else{
                swap(nums, i , cl);
            }
        }
        return new int[]{rep,miss};
    }

    //single line swap function for sure
    public static void swap(int[] nums, int i , int j){
        nums[j] = (nums[i] + nums[j]) - (nums[i] = nums[j]);
    }

}