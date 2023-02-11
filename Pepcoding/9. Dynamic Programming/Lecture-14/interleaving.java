public class interleaving {
    
    public static void main(String[] args) {
        //If k is removed, then it gives even better representation for sure!!!
        //Figure out the reason yourself!!! (very important for sure!!)
        //could be solved using dp table!!! (simple)
    }

    //solve it 
    public static boolean isInterleave(String s1, String s2, String s3) {

        if(s1.length() + s2.length() != s3.length()) return false;

        int[][][] dp = new int[s1.length() + 1][s2.length() + 1][s3.length() + 1];
        return help(s1, s2, s3, 0, 0, 0, dp) == -1 ? false : true;
    }

    public static int help(String s1 , String s2, String s3, int i , int j , int k, int[][][] dp){

        //true -> 1
        //false -> -1
        //not visited -> 0
        if(k == s3.length()){  //not the perfect condition tho for this question
            return 1;
        }

        if(dp[i][j][k] != 0){
            return dp[i][j][k];
        }
        int res = -1;
        
        if(i < s1.length() &&  s1.charAt(i) == s3.charAt(k)){
            res = help(s1, s2, s3, i+1, j, k+1, dp);
        }

        if(j < s2.length() && s2.charAt(j) == s3.charAt(k) && res != 1 ){
            res = help(s1, s2, s3, i, j+1, k+1, dp);
        }

        return dp[i][j][k] = res; 
    }

    //let's do this question in top down approach, using iterative dp!! (i have started to like this even more with time)
    //seriously i am loving this idea for sure

    //convert from 3D to 2D + plus iterative version bois
    //Damn this code works for sure!! (that too beautifully for fuck sake) 
    public static boolean isInterleaves(String s1, String s2, String s3) {

        if(s1.length() + s2.length() != s3.length()) return false;

        //making 2d dp bois!! (let's figure this one out)
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        dp[s1.length()][s2.length()] = 1;

        for(int i = s1.length(); i >= 0; i--){
            for(int j = s2.length(); j >= 0; j--){
                if(i == s1.length() && j == s2.length()) continue;
                
                int k = i + j;  //index (logix is not a problem)
                if(i < s1.length() &&  s1.charAt(i) == s3.charAt(k)){
                    dp[i][j] = dp[i+1][j];
                }

                if(dp[i][j] == 1) continue;
                if(j < s2.length() && s2.charAt(j) == s3.charAt(k) ){
                    dp[i][j] = dp[i][j+1];
                }             

            }
        }

        return dp[0][0] == 1;
    }

    //converting 2D to 1D dp bois!!! (pretty dope techinque for sure)
    //try this and you know dp pretty pretty much boi!!! (recursion relation is important to figure out)
    //now code using only 1D dp for this question please!!

    //Beautiful as fuck boi!!! (i love this piece of code)
    //I am finally in love with DP!! (pretty hard, but pretty dope shit for sure!!)
    //better than recursion memoization concepts for real
    public static boolean isInterleave1D(String s1, String s2, String s3) {

        if(s1.length() + s2.length() != s3.length()) return false;

        //making 2d dp bois!! (let's figure this one out)
        int[] curr = new int[s2.length() + 1];
        int[] below = new int[s2.length() + 1];

        //always set the lower end
        for(int i = s1.length(); i >= 0; i--){

            //keep going up and and up row wise
            for(int j = s2.length(); j >= 0; j--){
                if(i == s1.length() && j == s2.length()) curr[j] = 1; 
                
                int k = i + j;  //index (logix is not a problem)
                if(i < s1.length() &&  s1.charAt(i) == s3.charAt(k)){
                    curr[j] = below[j];
                }

                if(curr[j] == 1) continue;
                if(j < s2.length() && s2.charAt(j) == s3.charAt(k) ){
                    curr[j] = curr[j+1];
                }             

            }

            below = curr;
            curr = new int[s2.length() + 1];
        }

        return below[0] == 1;  //always find from the below one
    }












    

    
}
