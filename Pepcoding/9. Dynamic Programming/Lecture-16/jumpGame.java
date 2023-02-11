public class jumpGame {

    //perfect code for this problem boys!!! 
    //2 star rated problem for sure!!!
    //how come medium huh???
    public boolean canJump(int[] nums) {  //havas ke pujari, aur jo neend rehti hai fir 2 din, uska kya???
        //farest you can reach boi
        int curr = 0;
        int n = nums.length;
        boolean flag = true;
        for(int i = 0; i < n; i++){
            if(i > curr){
                flag = false;
                break;
            }

            if(nums[i] + i > curr){
                curr = nums[i] + i;
            }

            if(curr == n - 1) break; //small optimisation
        }

        return flag;
    }

    //one more logic for this question
    //go from right to left, and keep creating the answerr for the ones which could reach the end
    //simply!!! (if dp[i] can reach or not!!)
    //but the complexity will fuck you up for sure!!! (cause gotta check each one of them)
    //don't follow this approach for sure!! -- don't 

    //sir version of code bois!
    public boolean canJumpSir(int[] nums) { 
        int i = nums.length - 2;
        while(i != -1){
            if(nums[i] == 0){
                int j = i - 1;
                while( j >= 0 && nums[j] + j <= i){
                    j--;
                }
                if(j == -1){
                    return false;
                }
                i = j;
            }else{
                i--;
            }
        }

        return true;
    }
    
}
