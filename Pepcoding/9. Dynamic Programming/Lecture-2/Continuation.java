public class Continuation {

    public static void main(String[] args) {
        int[] nums = {0,-2,2};
        // int[] nums = {2,3,-5,7};
        int tar = 0;

        int ans = combiNeg(nums, tar, 0, 0);
        System.out.println(ans);
    }

    //Negative Cases for Subset Sum
    //SINGLE COMBI
    //Recursion Subsequence Version
    public static int combiNeg(int[] nums,int tar, int idx, int count){
        // //this won't work
        // if(tar == 0){
        //     return 1;
        // }
        
        //base cases
        if(idx != 0){
            if(tar == 0 || idx == nums.length){
                if(tar == 0 && count != 0){
                    return 1;
                }
                return 0;
            }
        }
        
        int ans = 0;
        ans += combiNeg(nums, tar-nums[idx], idx+1, count+1);
        ans += combiNeg(nums, tar, idx+1, count);
        return ans;
    }

    //MEMOZE OF UPPER VERSINO
    //ISSE CONVERT KRNA BAAKI HAI
    //BAS 2D array leke memoize kr lo
    public static int combiNegMemoize(int[] nums,int tar, int idx, int count){
        // //this won't work
        // if(tar == 0){
        //     return 1;
        // }
        
        //base cases
        if(idx != 0){
            if(tar == 0 || idx == nums.length){
                if(tar == 0 && count != 0){
                    return 1;
                }
                return 0;
            }
        }
        
        int ans = 0;
        ans += combiNegMemoize(nums, tar-nums[idx], idx+1, count+1);
        ans += combiNegMemoize(nums, tar, idx+1, count);
        return ans;
    }

    //let's code this part out, and move on(and fix the mistakes later on)
    //first understand the concepts and try to implement on your own
    //understanding concept is more important for now!!!!! (really really important)!!!

    //now in tabular form, we will extend our array dude 
    //on both sides, left and right!!! that would be pretty cool for sure
    
    //SOME OBSERVATIONS FROM THIS BAD BOI ( remember that )

    //RIGHT SHIFT - summation of neg sum
    //LEFT SHIFT - summation of neg sum
    //DP size = tar + 2*ngesum + 1
    //shifting -> negSUm
    //base case  dp[negSum]
    //ans -> dp[tar + negSum]


    //WEIRD SORT OF CODE BOIS
    public static int combinationsSingleTabNegCase(int[] nums, int tar){

        int negsum = 0;
        for(int ele : nums){
            if(ele < 0){
                negsum += (-ele);
            }
        }

        int[] dp = new int[tar + 2*negsum + 1];
        int[] prev = new int[tar + 2*negsum + 1];
        prev[negsum] = 1;
    
        //negativeSum has no effect on the answer (in this below loop)
        //automatically cuts each other out somehow
        for(int i = 1; i <= nums.length; i++){
            for(int j = 0; j < dp.length; j++){
                dp[j] += prev[j];  //old answer (no change )
                if(j-nums[i-1] >= 0 && j-nums[i-1] < dp.length){  //not out of the table bois
                    dp[j] += prev[j-nums[i-1]];   //my contribution
                }
            }   
            prev = dp;
            dp = new int[tar + 2*negsum +1];
        }
    
        return prev[tar + negsum];
    }




    
}
