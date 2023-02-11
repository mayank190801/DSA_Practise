public class shortestCommonSuperseq {

    public static void main(String[] args) {

        //ONE METHOD - Runtime (6ms)
        //so fuck sake, this question have multiple ways to be solved for sure
        //and the best one is using DP shit!!! (after making DP of lcs)
        //we would traverse it from the very end and keep on adding it to the string


        //SECOND METHOD - Runtime (47ms)
        //the one sir taught us!! 
        //which is making LCS string using the method we learned - 
        //then just simply traverse it through! 
        //if similar then just move that index aage simpleeeee

    }
    
    //SUBMITTED WITH RUNTIME - 47ms
    public static String shortestCommonSupersequence(String str1, String str2) {
        String lcs = longestCommonSubsequenceString(str1, str2);
        StringBuilder sb = new StringBuilder();

        int i = 0;
        int j = 0;

        //single loop boss!! No worries for that!!!
        //simple shit

        for(char ch : lcs.toCharArray()){
            while(str1.charAt(i) != ch){
                sb.append(str1.charAt(i));
                i++;
            }

            while(str2.charAt(j) != ch){
                sb.append(str2.charAt(j));
                j++;
            }

            sb.append(ch);
            i++;
            j++;
        }

        while(i < str1.length()){
            sb.append(str1.charAt(i));
            i++;
        }

        while(j < str2.length()){
            sb.append(str2.charAt(i));
            j++;
        }

        return sb.toString();
    }
    
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
