import java.util.List;

public class leetcode17 {

    public static void main(String[] args) {

    }

    //doesn't have too much time, have to push harder now, day in day out - simple as that
    //6-12 dsa bitch - office days pr something else if you can simple as that
//    public static boolean canSplitArray(List<Integer> nums, int m) {
//        int total = 0;
//        for(int i : nums) total += i;
//        return solver(nums, m, 0, nums.size() - 1, total, new int[nums.size()][nums.size()]);
//    }

//    public static boolean solver(List<Integer> nums, int m, int i , int j, int sum, int[][] dp){
//        if(dp[i][j] != 0) return dp[i][j] == 1;
//        if(i == j)  return true;
//        int csum = 0;
//        boolean possible = false;
//        for(int k = i; k < j; k++){
//            csum += nums.get(k);
//            sum -= nums.get(k);
//
//            boolean left = false;
//            if(k - i + 1 == 1 || csum >= m){
//                left = solver(nums, m, i, k, csum, dp);
//            }
//            boolean right = false;
//            if(j - k == 1 || sum >= m){
//                right = solver(nums, m, k + 1, j, sum, dp);
//            }
//            possible = possible || (left && right);
//        }
//
//        dp[i][j] = possible ? 1 : -1;
//        return possible;
//    }

    //how Can I code this into a better solution?? figure about that brother - chout bab
    //so that will be ofc 2D array solve, but there is O(1) as well, wtf is up with DSA man,
    //simple solutions are not accepted kya aaj kal??
    //hain ji?? - ka kr rhe ho bc -- socho thoda kaise ho skta hai - and do that
    //so chote chote answers se question bnana hai - iske liye 2d array kaisi chlti hai?? yaad hai kuch??

    public static boolean canSplitArray(List<Integer> nums, int m) {
        //now I have to make a 2d array with all i - j solutions possible inside it  --- first task
        int len = nums.size();
        int[][] dp = new int[len][len];

        //so for i = j we have now
        int gap = 0;
        while(gap ++ < len){
            for(int i = 0; i < len - gap; i++){
                //so for this i and j combination suppose



            }
        }

       return true;
    }
    


}
