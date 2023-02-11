import java.awt.List;
import java.util.ArrayList;
import java.util.*;

public class palindromeOne {

    //METHOD - 2

    //ALL PALINDROME ITERATIVE DP SOLUTION (let's go bois)
    //last one was recurion but now iterative bois!!
    //ITERATIVE BOIS
    //BRILLIANT WAY OF SOLVING BRUH
    //NO COMMENTS SERIOUSLY
    public static List<List<String>> partition(String s) {
        int len = s.length();
        boolean[][] palin = allpalin(s);
        List<List<String>>[] dp = new ArrayList[len];
        for(int i= 0; i < len; i++){
            dp[i] = new ArrayList<>();
            //case if the complete string is palindrome
            if(palin[0][i]){
                List<String> base = new ArrayList<>();
                base.add(s.substring(0, i+1));
                dp[i].add(base);
            };

            for(int j = i; j > 0; j--){
                if(palin[j][i]){
                    List<List<String>> jpo = dp[j-1];
                    for(List<String> list : jpo){
                        List<String> base = new ArrayList<>(list);
                        base.add(s.substring(j, i+1));
                        dp[i].add(base);
                    }
                }
            }   
        }

        return dp[len-1];
    }
    

    //simple logically MCM shit sort of stuff!!!
    //ran on the first try boisssss!!! 
    //DOPE SHIT 

    //METHOD - 1

    //TRY FOR ALL POSSIBLE CASES (brute force)
    // public static List<List<String>> partition(String s) {
    //     List<List<String>> ans = new ArrayList<>();
    //     List<String> cans = new ArrayList<>();
    //     helper(s, 0, ans, cans);
    //     return ans;
    // }

    // public static void helper(String str, int st, List<List<String>> ans , List<String> cans){
    //     if(st == str.length()){
    //         ans.add(new ArrayList<>(cans)); //simple addition in the answer
    //         return;
    //     }

    //     for(int i = st ; i < str.length() ;  i++){
    //         if(isPalindrome(str, st, i)){  //O(n) -> O(1) But how the fuck??????
    //             cans.add(str.substring(st, i+1)); //include required
    //             helper(str, i+1, ans, cans);
    //             cans.remove(cans.size()-1);
    //         }
    //     }
        
    // }

    //simple is palindrome check bois!! (simple as that boiiii)
    public static boolean isPalindrome(String str, int si, int ei){
        while(si < ei){
            if(str.charAt(si) != str.charAt(ei)) return false;
            si++;
            ei--;
        }
        return true;
    }
        




    ///----------------------------
    //SAME ABOVE CODE BUT USING BETTTER PALINDROME TECHNIQUE
    // public static List<List<String>> partition(String s) {
    //     List<List<String>> ans = new ArrayList<>();
    //     boolean[][] palin = allpalin(s);
    //     List<String> cans = new ArrayList<>();
    //     helper(s, 0, ans, cans, palin);
    //     return ans;
    // }

    public static void helper(String str, int st, List<List<String>> ans , List<String> cans, boolean[][] palin){
        if(st == str.length()){
            ans.add(new ArrayList<>(cans)); //simple addition in the answer
            return;
        }

        for(int i = st ; i < str.length() ;  i++){
            if(palin[st][i]){
                cans.add(str.substring(st, i+1)); //include required
                helper(str, i+1, ans, cans, palin);
                cans.remove(cans.size()-1);
            }
        }
        
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
