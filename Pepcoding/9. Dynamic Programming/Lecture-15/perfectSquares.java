import java.util.Arrays;

public class perfectSquares {

    //DOPE SHIT QUESTION FOR SURE!!!
    //Definitely impressed for sure!

    public static void main(String[] args) {
        int num = 13;
        int given = numSquares(num);
        System.out.println(given);
    }

    //O(nlong) solution
    //SIR SOLVE, MUCH MUCH MUCH FUCKING BETTER FOR SURE!!!
    //LOVED LOVED LOVED IT!!!
    public static int numSquare(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        
        //squares se krlo simple na
        for(int i = 2; i <= n; i++){
            for(int j = 1; j*j <= n; j++){
                dp[i] = Math.min(dp[i], 1 + dp[i - j*j]);
            }
        }

        return dp[n];
    }

    //O(n*n) solution
    //figure this one out no matter what!!
    public static int numSquares(int n) {  //solvable for sure!!
            int[] dp = new int[n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[1] = 1;

            int curr = 1;
            while(curr * curr <= n){
                dp[curr * curr] = 1;
                curr++;
            }

            for(int i = 2; i <= n; i++){
                //if perfect square make 1 
                if(dp[i] == 1) continue;
                for(int j = 1; j < i ; j++){
                    int l = dp[j];
                    int r = dp[i - j];

                    dp[i] = Math.min(dp[i], l + r);
                }

            }

            return dp[n];
    }

}
