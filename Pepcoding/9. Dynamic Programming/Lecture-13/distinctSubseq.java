public class distinctSubseq {

    public static void main(String[] args) {

        //Distinct Subsequence - 1
        String s = "babgbag";
        String t = "bag";

        //Distinct Subsequence - 2
        int ans = numDistinct(s, t);
        int answer = numDistinctUpdate(s, t);
        System.out.println(ans);        
        System.out.println(answer);
    }

    //FUCKING SIMILAR TO MEMOIZE ONE!!! 
    //BUT super duper shit for sure!! 
    //able to convert to table approach is always pretty cool
    //and try to do these question using current index or further index method


    //USING 2D dp, could be solved using 1D dp too!! (simple shit)
    //figure that out, pretty ease for sure (not much complicated stuff)
    public static int numDistinctUpdate(String s, String t) {
        //now solve using dp no?
        int len1 = s.length();
        int len2 = t.length();

        int[][] dp = new int[len1 + 1][len2 + 1];
    
        //setting those value up!!
        for(int i = 0; i <= len1; i++){
            dp[i][len2] = 1;
        }

        //edge cases are not handled yet tho
        for(int i = len1-1; i >= 0; i--){
            for(int j = len2 - 1; j >= 0; j--){
                if(s.charAt(i) == t.charAt(j)){
                    dp[i][j] += dp[i+1][j+1];
                    dp[i][j] += dp[i+1][j];
                }else{
                    dp[i][j] += dp[i+1][j];
                }
            }
        }

        return dp[0][0];        
    }


    //MY SOLUTION (recursion + memoization)
    //Now think in terms of DP no?

    //LOL GOT FREAKIN ACCEPTED WITH THE WORST TIME LIMIT I HAVE EVER SEEN
    //store the answer somewhere boss!!

    //Some updates boi
    //using this index or future index method rather than for loop is golden for sure
    //use it more often bois

    public static int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int i= 0; i < dp.length; i++){
            for(int j=0; j <dp[0].length; j++){
                dp[i][j] = -1;
            }
        }

        int answer = helper(s, t, 0, 0, dp);
        return answer;  //pretty simple for sure
    }

    //first we will solve by recursion and memoization bruh (tryna understand)
    public static int helper(String s, String t, int i, int j, int[][] dp){
        //some base cases
        if(j == t.length()){  //if complete return 
            dp[i][j] = 1;
            return 1;
        } 

        if(i == s.length()){  //
            dp[i][j] = 0;
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int ans = 0;
    
        //simple for loop ki jagah dude, if loop lagah de strings mein
        //much better conceptually, cause it will be added in it only
        //rather than looping the fuck out, this is better strat for sure
        if(s.charAt(i) == t.charAt(j)){
            ans += dp[i+1][j+1] != -1 ? dp[i+1][j+1] : helper(s, t, i+1, j+1, dp);
            ans += dp[i+1][j] != -1 ? dp[i+1][j] : helper(s, t, i+1, j, dp);
        }else{
            ans += dp[i+1][j] != -1 ? dp[i+1][j] : helper(s, t, i+1, j, dp);
        }

        dp[i][j] = ans;

        return ans;
    }
    
}
