public class palindromicSubsequences {

    public static void main(String[] args) {
        
    }

    //count palindrome subseq
    //DOPEST of ALL!!
    public long countPS(String str)
    {
        int len = str.length();
        long[][] dp = new long[len][len];
        long mod = 1_000_000_007;
        //how you traverse that thircha path on the cube,
        //gap strat baby
        for(int gap = 0; gap < len ; gap++){
            int si = 0;
            int ei = gap;
            while(ei < len){
                if(gap == 0){
                    dp[si][ei] = 1;
                }else if(gap == 1){
                    dp[si][ei] = 2;
                    if(str.charAt(si) == str.charAt(ei)){
                        dp[si][ei]++;
                    }
                }else{
                    //definitely worked bruh, you uselessly made it more tricky fucker!! idiot fucker for sure
                    //it was just similar to this one, properly similar, but you fucker didn't get the last one either
                    //no??
                    dp[si][ei] = ((dp[si][ei]%mod + dp[si+1][ei]%mod + dp[si][ei-1]%mod)%mod - dp[si+1][ei-1]%mod + mod)%mod; //pretty obv unn dono ko mat le fir answer
                    if(str.charAt(si) == str.charAt(ei)){
                        dp[si][ei] = (dp[si][ei]%mod + dp[si+1][ei-1]%mod + 1L)%mod;  //unn dono ko le fir answer
                    }
                }
                si++;
                ei++;
            }
        }

        return dp[0][len-1];        
    }

    //longest palindromic subseq (think about it)
    //SIMPLE LOGIC BOIS!!! no worries , no no no worries!!! seriously
    public int longestPalindromeSubseq(String str) {
        int len = str.length();
        int[][] dp = new int[len][len];
        for(int gap = 0; gap < len ; gap++){
            int si = 0;
            int ei = gap;
            while(ei < len){
                if(gap == 0){
                    dp[si][ei] = 1;
                }else{                    
                    if(str.charAt(si) == str.charAt(ei)){
                        dp[si][ei] = dp[si+1][ei-1] + 2;
                    }else{
                        dp[si][ei] = Math.max(dp[si+1][ei], dp[si][ei-1]);
                    }
                }
                si++;
                ei++;
            }
        }
        return dp[0][len-1];  
    }


    //USING ABOVE  METHOD, COULD YOU FIND THE SOLUTION FOR LONGEST PALINDROMIC SUBSTIRNG????
    //THAT'S THE QUESTION
    //WE have done that using boolean, and index method till now!! WHAT ABOUT THIS BAD BOI????

    //THIS WORKS FOR SURE!! Beautifully for sure
    public String longestPalindromeSubString(String str) {
        int len = str.length();
        int[][] dp = new int[len][len];
        int st = 0;
        int end = 0; 
        for(int gap = 0; gap < len ; gap++){
            int si = 0;
            int ei = gap;
            while(ei < len){
                if(gap == 0){
                    dp[si][ei] = 1;
                }else{                    
                    if(str.charAt(si) == str.charAt(ei)){
                        if(dp[si+1][ei-1] == ei-si-1){
                            //whenver this happens update the answer!!
                            //simple shit no?? (really not but what can we do about that)
                            st = si;
                            end = ei;
                            dp[si][ei] = dp[si+1][ei-1] + 2;
                        }
                    }
                    dp[si][ei] = Math.max(dp[si][ei], Math.max(dp[si+1][ei], dp[si][ei-1]));
                }
                si++;
                ei++;
            }
        }
        return str.substring(st, end+1);  
    }

}
