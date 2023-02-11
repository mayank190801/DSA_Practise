import java.util.Arrays;

public class palindromicSubseq {
    public static void main(String[] args) { 

        //DISTINCT (pretty cool way, definitely remember this bad boi)

        //normally what happens basically!!!!
        //what usually happens in this bad boi!!
        //(i,j) -> equal (left + right - mid)
        //               (mid + 1)
        //      -> unequal (left + right - mid)
    
        //LEGENDARY LOGIC FOR SURE BOSS!!!! DEFINITELY REMEMBER THIS BAD BOI FOR SURE
        //DP AT IT'S PEAK
        //Generic question 101

        //THIS QUESTION IS FREAKIN LEGENDARY FOR SURE BOSS!!
        // (i,j) -> equal is converted to three csaes
        //1 -> when there is no a in the middle
        //2 -> when there is one a in the middle
        //3 -> when there is adjacent a in the left most and right most corner

        //for (i, j) -> not equal, it's totally different for sure 
        
    }

    public static int countPalindromicSubsequences(String s) {
        int len = s.length();

        int[] left = new int[len];
        int[] map = new int[26];
        Arrays.fill(map, -1);

        for(int i= 0; i < len; i++){
            char ch = s.charAt(i);
            left[i] = map[ch-'a'];
            map[ch-'a'] = i;  
        }

        int[] right = new int[len];
        map = new int[26];
        Arrays.fill(map, len);

        for(int i= len-1; i >= 0; i--){
            char ch = s.charAt(i);
            right[i] = map[ch-'a'];
            map[ch-'a'] = i;  
        }

        long[][] dp = new long[len][len];
        long mod = (int)(1e9) + 7;

        //now simply
        for(int gap = 0; gap < len; gap++){
            int si = 0;
            int ei = gap;

            while(ei < len){
                if(gap == 0){
                    dp[si][ei] = 1;
                }else if(gap == 1){
                    dp[si][ei] = 2;
                }else{
                    if(s.charAt(si) == s.charAt(ei)){  //duplicacy came in
                        int lidx = right[si];
                        int ridx = left[ei];

                        //no same in middle
                        if(lidx > ridx){
                            dp[si][ei] = ((2 * dp[si+1][ei-1]%mod) + 2)%mod;
                        }else if(lidx == ridx){
                        //single occur
                            dp[si][ei] = ((2 * dp[si+1][ei-1]%mod) + 1)%mod;
                        }else{
                        //multiple occur
                            dp[si][ei] = ((2 * dp[si+1][ei-1])%mod - (dp[lidx + 1][ridx - 1]%mod) + mod)%mod; 
                        }

                    }else{
                        dp[si][ei] = (dp[si][ei] + dp[si][ei-1] + dp[si + 1][ei] - dp[si+1][ei-1] + mod)%mod;
                    }
                }

                si++;
                ei++;                
            }
        }

        return (int)dp[0][len-1];
    }

}
