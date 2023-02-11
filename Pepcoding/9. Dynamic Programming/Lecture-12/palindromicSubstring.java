
public class palindromicSubstring {

    public static void main(String[] args) {
        //many variations
        // is (i, j) palindrome ???
        //count (i, j) palindrome substrings
        //longest (i, j) palindrome substring (imp) (dp then without using extra space)
        solve();
        //recursive, memoize, dp (approach)
    }

    //first recursion, using i+1, j-1, then i+1, j and then i,j-1 all these three cases for all palindrome
    public static void solve(){
        //all palindrome
        allPalindrome("aabbaa");
        //TIME AND SPACE - O(len^2) same

        //count All Palindrome
        countPalindromic("aabbaa");

        //longest Palindrome
        longestPalindromic("aabbaa");

    }

    public static boolean[][] allPalindrome(String str){
        int len = str.length();
        boolean[][] dp = new boolean[len][len];

        //how you traverse that thircha path on the cube,
        //gap strat baby
        for(int gap = 0; gap < len ; gap++){
            int si = 0;
            int ei = gap;
            while(ei < len){
                if(gap == 0){
                    dp[si][ei] = true;
                }else if(gap == 1){
                    if(str.charAt(si) == str.charAt(ei)){
                        dp[si][ei] = true;
                    }
                }else{
                    if(str.charAt(si) == str.charAt(ei) && dp[si+1][ei-1]){
                        dp[si][ei] = true;
                    }
                }
                si++;
                ei++;
            }
        }

        // for(boolean[] ar : dp){
        //     for(boolean ele : ar){
        //         System.out.print(ele + " ");
        //     }
        //     System.out.println();
        // }
        return dp;
    }

    //count palindromic substring, how did you do it?
    //simple count method

    //not so simple, you just don't use your brain you piece of shit
    //you be just listening and doing whatever is said to you fucker!!
    //fucker for life
    
    public static int countPalindromic(String str){
        int len = str.length();
        int[][] dp = new int[len][len];
        boolean[][] isPalin = allPalindrome(str);

        //how you traverse that thircha path on the cube,
        //gap strat baby
        for(int gap = 0; gap < len ; gap++){
            int si = 0;
            int ei = gap;
            while(ei < len){
                if(gap == 0){
                    dp[si][ei] = 1;
                }else if(gap == 1){
                    dp[si][ei] += dp[si+1][ei];
                    dp[si][ei] += dp[si][ei-1];
                    if(str.charAt(si) == str.charAt(ei)){
                        dp[si][ei]++;
                    }
                }else{
                    dp[si][ei] += dp[si+1][ei];
                    dp[si][ei] += dp[si][ei-1];
                    dp[si][ei] -= dp[si+1][ei-1];  //remove the common part for once (v.imp)
                    if(str.charAt(si) == str.charAt(ei) && isPalin[si+1][ei-1]){
                        dp[si][ei]++;
                    }
                }
                si++;
                ei++;
            }
        }

        // for(int[] ar : dp){
        //     for(int ele : ar){
        //         System.out.print(ele + " ");
        //     }
        //     System.out.println();
        // }
        return dp[len-1][len-1];
    }

    //Longest palindromic Substring
    //simple logic for sure
    public static String longestPalindromic(String str){
        int len = str.length();
        boolean[][] dp = new boolean[len][len];

        int s = 0;
        int e = 0;

        for(int gap = 0; gap < len ; gap++){
            int si = 0;
            int ei = gap;
            while(ei < len){
                if(gap == 0){
                    dp[si][ei] = true;
                }else if(gap == 1){
                    if(str.charAt(si) == str.charAt(ei)){
                        dp[si][ei] = true;
                    }
                }else{
                    if(str.charAt(si) == str.charAt(ei) && dp[si+1][ei-1]){
                        dp[si][ei] = true;
                    }
                }

                //longest yet ofc - so update the answer
                if(dp[si][ei]){
                    s = si;
                    e = ei;
                }

                si++;
                ei++;
            }
        }

        return str.substring(s, e);
    }
}
