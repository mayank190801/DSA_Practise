import java.util.Arrays;

public class palindromeTwo {

    //Methhod -1 
    //recursiion and slow palindrome

    //Mehtod -2 
    //Recursino and fast palindrome

    //METHOD - 3
    //iterative dp one


    //let's solve this bad boi now!! (seems pretty easy for sure)
    //Ran on my very first try boiiiiiii
    //I am pretty smart for real dududududue
    //pretty pretty pretty smart
    public int minCut(String s) {
        int len = s.length();
        boolean[][] palin = allpalin(s);
        int[] dp = new int[len];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for(int i = len-1; i >= 0; i--){
            //if the entire string is dp, do this
            if(palin[i][len-1]){
                dp[i] = 0;
                continue;
            }

            //otherwise move through it 
            for(int j = i ; j < len-1; j++){
                if(palin[i][j]){
                    dp[i] = Math.min(dp[i], dp[j+1] + 1);
                }
            }
        }

        return dp[0];
    }
    

    public static boolean[][] allpalin(String str){
        int len = str.length();
        boolean[][] dp = new boolean[len][len];
        
        //how to traverse half of the array!! 
        //pretty logical and better code for sure

        for(int gap = 0 ; gap < dp.length; gap++){
            int si = 0;
            int ei = gap;
            while(ei < dp.length){
                //1 length
                if(gap == 0){
                    dp[si][ei] = true;
                }else if(gap == 1){
                    if(str.charAt(si) == str.charAt(ei))
                        dp[si][ei] = true;
                }else{
                    if(str.charAt(si) == str.charAt(ei) && dp[si+1][ei-1])
                        dp[si][ei] = true;
                }
                si++;
                ei++;
            }
        }

         return dp;
    }

}
