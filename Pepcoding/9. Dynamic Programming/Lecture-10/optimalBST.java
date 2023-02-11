public class optimalBST{

    public static void main(String[] args) {
        int[] keys = {10,12,20};
        int[] freq = {34,8,50};

        int len = keys.length;
        int[][] dp = new int[len][len];

        //freq count bois
        int[] ps = new int[len];

        //prefix sum had some error bruh
        ps[0] = freq[0];
        for(int i = 1; i < freq.length; i++){
            ps[i] = ps[i-1] + freq[i];
        }

        int answer = helper_(keys, freq, dp, ps);
        // int answer = helper(0, keys.length-1, keys, freq, 1, dp);
        System.out.println(answer);
    }

    //tabulation for this bad boi
    //gap strategy bois //easy as fuck
    public static int helper_(int[] keys, int[] freq, int[][] dp, int[] ps){

        //how to write code for gap method bois?
        int len = keys.length;
        for(int gap = 0; gap < len; gap++){
            int si = 0;
            int ei = gap;

            while(ei < len){
                if(gap == 0){
                    dp[si][ei] = freq[si];
                }else{
                    dp[si][ei] = Integer.MAX_VALUE;
                    int psum = ps[ei] - (si == 0 ? 0 : ps[si-1]);

                    for(int root = si ; root <= ei; root++){
                        int lans = root == 0 ? 0 : dp[si][root-1];
                        int rans = root == len - 1 ? 0 : dp[root+1][ei];    

                        int mycost = lans + rans + psum;
                        if(dp[si][ei] > mycost){
                            dp[si][ei] = mycost;
                        }
                    }
                }
                si++;
                ei++;
            }

        }

        return dp[0][len-1];
    }

    //basic recursion helper bois + memoization
    public static int helper(int si, int ei, int[] keys, int[] freq, int level, int[][][] dp){

        if(si > ei){
            return 0;
        }

        if(dp[si][ei][level] != 0){
            return dp[si][ei][level];
        }

        //for this bad boi helper it no??
        int cans = Integer.MAX_VALUE;
        for(int i = si ; i <= ei ; i++){
            //choosing the current i as the best
            int left = helper(si, i-1, keys, freq, level+1, dp);
            int right = helper(i+1, ei, keys, freq, level+1, dp);

            int current = level * freq[i];
            int ans = left + right + current;
            
            cans = Math.min(ans, cans);
        }

        return dp[si][ei][level] = cans;
    }









}