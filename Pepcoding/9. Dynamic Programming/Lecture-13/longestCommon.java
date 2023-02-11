import java.util.Arrays;

public class longestCommon {

    public static void main(String[] args) {
        solve();
    }

    //think think think
    //first both recursive logic, pretty cool
    //just return factor is changed halka sa!! super imp
    public static void solve(){

        //longest common substring
        String s1 = "SUNDAY";
        String s2 = "BUMPDAY";

        longestCommonSubsequence(s1, s2);
        //longest common subsequence 
        String str = longestCommonSubsequenceString(s1, s2);
        System.out.println(str);
    }

    //calls helps in answer creation, but doens't affect the return value
    //Recursion calling stuff (try solving it like that boi)
    //using recursion you might have to return int[] type if not wanna use static
    //simple as that
    // if(s1[i] == s2[j]){
    //     return LCS(i+1,j+1) + 1;
    // }else{
    //     return 0;
    // }
    // return [lcs, max]
    // and rememeber to call other calls too!!! (try to think in here)

    //kinda return types bois
    static int ans = 0;
    public static int help(String s1 , String s2, int i , int j){
        if(i == s1.length() || j == s2.length()){
            return 0;
        }

        int tr = 0;
        //updating to return only when something happened
        //contribution from this bad boi onlyyyy!!! think about it!!!
        if(s1.charAt(i) == s2.charAt(j)){
            tr = help(s1, s2, i+1, j+1) + 1;
        }

        help(s1, s2, i, j+1);
        help(s1, s2, i+1, j);

        ans = Math.max(ans, tr);
        return tr;
    }
    


    //  LONGEST COMMON SUBSTRING (possible using 1D Dp also!! (remember that boi))
    public int longestCommonSubstr(String s1, String s2, int n, int m){
        int l1 = s1.length();
        int l2 = s2.length();

        int[][] dp = new int[l1 + 1][l2 + 1];
            
        //three boxes are needed basically right bottom bottom-right (simple)
        //rec -> memo (great shit!!!)
        int ans = 0;
        for(int i = l1-1; i >= 0; i--){
            for(int j = l2-1; j >= 0; j--){
                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1] + 1;
                }else{
                    dp[i][j] = 0;  //only change  from subseq!!!
                }

                ans = Math.max(ans, dp[i][j]); //answer could be present all over the array
                //simple logic bois
            }
        }
        
        return ans;
    }


    //recursion code for LCS (pretty reasonable) (simple op code)
    public static int LCSRecursion(String s1, String s2, int i, int j) {    
        //base case
        if(i >= s1.length() || j >= s2.length()){
            return 0;
        }

        if(s1.charAt(i) == s2.charAt(j)){
            return LCSRecursion(s1, s2, i+1, j+1) + 1;
        }else{
            return Math.max(LCSRecursion(s1, s2, i+1, j), LCSRecursion(s1, s2, i, j+1));
        }
    }
    
    //this one is pretty simple for sure!! 
    //Runs at 16 ms baby!! pretty good!!
    //USING 2D DP!!!
    public static int longestCommonSubsequence(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();

        int[][] dp = new int[l1 + 1][l2 + 1];
            
        //three boxes are needed basically right bottom bottom-right (simple)
        //rec -> memo (great shit!!!)

        for(int i = l1-1; i >= 0; i--){
            for(int j = l2-1; j >= 0; j--){
                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        
        for(int[] arr : dp){
            for(int i : arr){
                System.out.print(i + " ");
            }
            System.out.println();
        }

        return dp[0][0];
    }

    //You could do it using 1D Dp and helper Dp simple!!!
    //solve it here bois

    //  ANNOYING STRING MAKING SOLVE DUDE!!! 
    public static String longestCommonSubsequenceString(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();

        String[] dp = new String[l2 + 1];
        Arrays.fill(dp, "");
        String[] help = new String[l2 + 1];

        //three boxes are needed basically right bottom bottom-right (simple)
        //rec -> memo (great shit!!!)
        for(int i = l1-1; i >= 0; i--){
            help[l2] = "";
            for(int j = l2-1; j >= 0; j--){
                help[j] = "";
                if(s1.charAt(i) == s2.charAt(j)){
                    help[j] = s1.charAt(i) + dp[j+1];
                }else{
                    String d = dp[j];
                    String r = help[j+1];
                    if(r.length() > d.length()){
                        help[j] = r;
                    }else{
                        help[j] = d;
                    }
                }
            }

            //updation
            dp = help;
            help = new String[l2 + 1];
        }

        return dp[0];
    }


    
}
