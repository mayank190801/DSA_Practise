public class longestRepeatingSubstring {

    public static void main(String[] args) {

        //overlapping - non overlapping (simple method)
        //figure this both out!!

        //let's solve this one! No worries
        String str = "ablhiabohi";
        String answer = longestSubstring(str, str.length());
        System.out.println(answer);

        //now we know this shit works actually
        //<=

        //THIS WILL ALWAYS BE NON OVERLAPPING FOR SUBSTRING, if you will think 
        //you will get the reason whyyyyy!!! 
        //Simple and important question for sure
        
    }

    //SUCCESSFULLY PASSED BOIS
    public static String longestSubstring(String S, int N) {
        String s1 = S;
        String s2 = S;

        int l1 = s1.length();
        int l2 = s2.length();

        int len = 0;
        int st = 0;

        int[][] dp = new int[l1 + 1][l2 + 1];
            
        //three boxes are needed basically right bottom bottom-right (simple)
        //rec -> memo (great shit!!!)
        int ans = 0;
        for(int i = l1-1; i >= 0; i--){
            for(int j = l2-1; j >= 0; j--){
                if(s1.charAt(i) == s2.charAt(j) && i != j){
                    dp[i][j] = dp[i+1][j+1] + 1;
                }else{
                    dp[i][j] = 0;  //only change  from subseq!!!
                }

                ans = Math.max(ans, dp[i][j]); //answer could be present all over the array
                //simple logic bois
                if(dp[i][j] >= len){
                    len = dp[i][j];
                    st = i;
                }
            }
        }

        if(len == 0){
            return "-1";
        }
        
        return S.substring(st, st + len);
    }
    
}
