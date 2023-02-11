public class longestRepeatingSubseq {

    public static void main(String[] args) {

        //overlapping allowed
        //-> LCS(s,s) with i != j 

        //overlapping not allowed
        //ababa 
        //brute force O(n^3)
        // ( a ) (baba) LCS
        // (ab ) (aba) LCS
        // and so on!! 
    
    }

    //overlapping allowed version
    //SOLVED in one go!! simple as fuck
    public static int LongestRepeatingSubsequence(String str)
    {
        int len1 = str.length();
        int len2 = str.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        for(int i = len1 -1 ; i >= 0; i--){
            for(int j = len2 -1; j >= 0; j--){
                if(str.charAt(i) == str.charAt(j) && i != j){
                    dp[i][j] = dp[i+1][j+1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }

        return dp[0][0];
    }
    
}
