public class leetcode30 {
    public static void main(String[] args) {
        String first = "";
        String second = "a";

        System.out.println(minDistance(first, second));
    }

    //let's write the recursive
    public static int minDistance(String word1, String word2) {
        return solve(word1, word2, word1.length() - 1, word2.length() - 1);
    }

    public static int solve(String word1, String word2, int fidx, int sidx) {
        if (fidx == -1 && sidx == fidx) return 0;
        if (fidx == -1 || sidx == -1) return Math.max(fidx + 1, sidx + 1);
        int val = 1 + Math.min(solve(word1, word2, fidx - 1, sidx - 1), Math.min(solve(word1, word2, fidx - 1, sidx), solve(word1, word2, fidx, sidx - 1)));
        if (word1.charAt(fidx) == word2.charAt(sidx)) {
            val = Math.min(val, solve(word1, word2, fidx - 1, sidx - 1));
        }
        return val;
    }

    //using dp to solve this stupid problem, let's figure it out
    //2D dp solution, can you convert it into 1D?? even more compact brother? Is it possible for your skill level to do that??
    //Can you humanly possibly to do that feat??
    public static int minDistance2(String word1, String word2){
         int len1 = word1.length();
         int len2 = word2.length();
         int[][] dp = new int[len1 + 1][len2 + 1];

         for(int i = 0; i <= len1; i++){
             for(int j = 0; j <= len2; j++){
                 if(i == 0 || j == 0){
                     dp[i][j] = Math.max(i, j);
                 }else{
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j - 1], dp[i-1][j - 1]));
                    if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                    }
                 }
             }
         }
         return dp[len1][len2];
    }

    public static int minDistance3(String word1, String word2){
        int len1 = word1.length();
        int len2 = word2.length();
        int[] dpLinear = new int[len2 + 1];
        int topLeft = 0;
        for(int i = 0; i <= len1; i++){
            for(int j = 0; j <= len2; j++){
                int tempTopLeft = dpLinear[j];
                if(i == 0 || j == 0){
                    dpLinear[j] = Math.max(i, j);
                }else{
                    dpLinear[j] = 1 + Math.min(dpLinear[j], Math.min(dpLinear[j - 1], topLeft));
                    if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                        dpLinear[j] = Math.min(dpLinear[j], topLeft);
                    }
                }
                topLeft = tempTopLeft;
            }
        }
        return dpLinear[len2];
    }



}

