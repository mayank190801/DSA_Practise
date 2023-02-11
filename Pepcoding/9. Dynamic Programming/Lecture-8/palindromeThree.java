import java.util.Arrays;

public class palindromeThree {

    //SIR CODE (recursion with easy faith baby)
    //WORKS INSANELY WELL
    public static int palindromePartition(String s, int k) {
        int[][] mincost = allpalin(s);
        int[][] dp = new int[k+1][s.length()];
        for(int i= 0; i <= k; i++){
            Arrays.fill(dp[i], -1);
        }
        int ans = palindromePartition(s, 0, k, mincost, dp);
        return ans;
    }

    public static int palindromePartition(String str, int st , int k, int[][] mincost, int[][] dp){

        if(st == str.length()) return 0;
        if(k == 1){
            return mincost[st][str.length() - 1];
        } 

        if(dp[k][st] != -1){
            return dp[k][st];
        }

        int ans = Integer.MAX_VALUE;
        for(int i = st; i <= str.length() - k ; i++){
            ans = Math.min(ans, palindromePartition(str, i+1, k-1, mincost, dp) + mincost[st][i]);
        }
        return dp[k][st] = ans;
    }

    //ME FIGURING OUT BELOW SOLUTION (LIKE AN IDIOT HEHEHE)
    //let's figure out how many changes are required 
    //SOLVED USING ITERATIVE DP BOIIII
    //NEVER TELL WORLD YOU ARE IDIOT , CAUSE YOU ARE FUCKING GENIUS
    public static int palindromePartition(String s, int k) {
        //minimum at each point no?
        int[][] palin = allpalin(s);

        //so now i have to code a function that will do at most k cuts in all possible ways
        //get it?
        int len = s.length();
        int[][] dp = new int[s.length()+1][k+1];
        for(int i = 0; i <= s.length(); i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for(int i = len-1; i >= 0; i--){
            int clen = len-i; //comes out 1 for 1 character
            int min = Math.min(clen, k+1);
            for(int j = 0; j < min; j++){
                if(j == 0){
                    dp[i][0] = palin[i][len-1]; //index
                    continue;
                }
                //kitne cut maarne hai iss round mein basically (think about it)
                for(int l = i; l < len-j; l++){  //isme max kaha tak jaa skte hai???
                    dp[i][j] = Math.min(dp[i][j] , palin[i][l] + dp[l+1][j-1]);  //dp updations no?
                }
            }
        }

        //golden k = to k - 1 was golden
        return dp[0][k-1];  //final answer in here
    }


    public static int[][] allpalin(String str){
        int len = str.length();
        int[][] dp = new int[len][len];
        
        //how to traverse half of the array!! 
        //pretty logical and better code for sure

        for(int gap = 0 ; gap < dp.length; gap++){
            int si = 0;
            int ei = gap;
            while(ei < dp.length){
                //1 length
                if(gap == 0){
                    dp[si][ei] = 0;
                }else if(gap == 1){
                    if(str.charAt(si) != str.charAt(ei))
                        dp[si][ei] = 1;
                }else{
                    dp[si][ei] = dp[si+1][ei-1];
                    if(str.charAt(si) != str.charAt(ei))
                        dp[si][ei]++;
                }
                si++;
                ei++;
            }
        }

         return dp;
    }
    
}
