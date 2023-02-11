
public class answerCreation{
    public static void main(String[] args) {
        
    }

    //COMBINATION SINGLE & INFINITE
    //PERMUTATION INFINITE
    //FOR BOTH 2D WILL BE GIVEN
    //TRY MAKING EVERY OTHER ONE ON YOUR OWN BOI (think about this one)
    
    //let's try creating one bois(pretty easy for you yeah!!!)
    public static void createSingleCombination(int[] nums, int idx, int tar, int[][] dp, String ans){
    
        if(tar == 0 || idx == 0){
            if(tar == 0)
                System.out.println(ans);
            return;
        }        

        //some backward recursion bois (pretty annoying for sure)
        create(nums, idx-1, tar, dp, ans);
        if(tar - nums[idx-1] >= 0)
            create(nums, idx-1, tar-nums[idx-1], dp, ans + nums[idx-1]);
    }




}
