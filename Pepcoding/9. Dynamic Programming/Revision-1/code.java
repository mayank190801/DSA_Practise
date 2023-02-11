public class code{

    //multiple test cases
    //perm (single, infinite) (for, subseq)
    //comb (single, infinite) (for, susbseq)

    //HENCE TOTAL OF 8 WAYS bois
    //perm (single) (not optimised with dp)
    //everyone else YESSS!!!
    
    public static void main(String[] args) {

        int[] coins = {2,3,5,7};
        int tar = 10;

        int ans = permInfi(coins, tar);
        int ans1 = comboInfi(coins, tar);
        int ans2 = comboSingle(coins, tar);
        int ans3 = comboSingleVertical(coins, tar);
        int ans4 = comboSingleVertical1D(coins, tar);
        int ans5 = comboInfiVertical1D(coins, tar);


        System.out.println(ans);
        System.out.println(ans1);
        System.out.println(ans2);
        System.out.println(ans3);
        System.out.println(ans4);
        System.out.println(ans5);
    }

    //direct dp solves
    //single perm can't be!! 

    //perm infi bois
    public static int permInfi(int[] coins, int tar){ 
        int[] dp = new int[tar + 1];
        int n = coins.length;
        dp[0] = 1;

        for(int j = 1; j <= tar; j++){
            for(int i = 0; i < n; i++){
                if(j - coins[i] >= 0){
                    dp[j] += dp[j - coins[i]];
                }
            }
        }

        return dp[tar];
    }

  
    //remember the logic, that is more important in here for sure
    public static int comboInfi(int[] coins, int tar){ 
        int n = coins.length;
        int[][] dp = new int[tar + 1][n + 1];

        //always + 1!
        dp[0][0] = 1;
        for(int i = 0; i <= tar; i++){
            for(int j = 1; j <= n; j++){
                dp[i][j] += dp[i][j-1];
                if(i - coins[j-1] >= 0){
                    dp[i][j] += dp[i-coins[j-1]][j];
                }
            }
        }

        return dp[tar][n];
    }

   
     public static int comboSingle(int[] coins, int tar){
        int n = coins.length;
        int[][] dp = new int[tar + 1][n + 1];
        dp[0][0] = 1;

        //always + 1!
        for(int i = 0; i <= tar; i++){
            for(int j = 1; j <= n; j++){
                dp[i][j] += dp[i][j-1];
                if(i - coins[j-1] >= 0){
                    dp[i][j] += dp[i - coins[j-1]][j-1];
                }
            }
        }

        return dp[tar][n];
    }


    //now let's talk some sense in here for sure boi!! (let's talk some sense for sure)
    //this should be actually kaafi sense!! (listen carefully)

    //we are able to convert perm infi to 1D easily!! (we have even started with that)
    //with horizonal traversal if you convert that in 2D (it works simple!!)

    //But we can not convert horizontal traversal into 1D (in combo) (for loop)
    //for that we require subsequence i.e vertical traversal
    //let's see

    public static int comboSingleVertical(int[] coins, int tar){
        int n = coins.length;
        int[][] dp = new int[tar + 1][n + 1];
        dp[0][0] = 1;

        //always + 1
        for(int j = 1; j <= n; j++){
            for(int i = 0; i <= tar; i++){
                dp[i][j] += dp[i][j-1];
                if(i - coins[j-1] >= 0){
                    dp[i][j] += dp[i - coins[j-1]][j-1];
                }
            }
        }

        return dp[tar][n];
    }

    public static int comboSingleVertical1D(int[] coins, int tar){
        int n = coins.length;
    
        int[] prev = new int[tar + 1];
        int[] curr = new int[tar + 1];
        prev[0] = 1;

        //always + 1
        for(int j = 1; j <= n; j++){
            for(int i = 0; i <= tar; i++){
                curr[i] += prev[i];
                if(i - coins[j-1] >= 0){
                    curr[i] += prev[i - coins[j-1]];
                }
            }

            //yaha pr shift kro
            prev = curr;
            curr = new int[tar + 1];
        }

        return prev[tar];
    }

     public static int comboInfiVertical1D(int[] coins, int tar){
        int n = coins.length;
    
        int[] curr = new int[tar + 1];
        curr[0] = 1;

        //always + 1
        for(int j = 1; j <= n; j++){
            for(int i = 0; i <= tar; i++){
                if(i - coins[j-1] >= 0){
                    curr[i] += curr[i - coins[j-1]];
                }
            }

        }

        return curr[tar];
    }








}