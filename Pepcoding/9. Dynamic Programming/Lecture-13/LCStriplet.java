public class LCStriplet {

    public static void main(String[] args) {
        
    }

    //multiple similar LCS are there bitch!!! (always remember that)
    //abac 
    //apcb  
    // ab and ac both are LCS and they impact the future answers pretty too well

    //PRETTY OP SHIT FOR SURE (in love with this trick, why not just extend this shit??)
    public static int LCSof3(String s1, String s2, String s3, int n1, int n2, int n3) 
    { 
        //without bug code bois!!! 
        //3D dp to be used for sure in this one
        int[][][] dp = new int[n1 + 1][n2 + 1][n3 + 1];

        for(int i = n1 - 1; i >= 0; i--){
            for(int j = n2 - 1; j >= 0; j--){
                for(int k = n3 - 1; k >= 0; k--){
                    if(s1.charAt(i) == s2.charAt(j) && s2.charAt(j) == s3.charAt(k)){
                        dp[i][j][k] = dp[i+1][j+1][k+1] + 1;
                    }else{
                        dp[i][j][k] = Math.max(dp[i+1][j][k], Math.max(dp[i][j+1][k],dp[i][j][k+1]));
                    }

                }
            }
        }

        return dp[0][0][0];
    }

    
}
