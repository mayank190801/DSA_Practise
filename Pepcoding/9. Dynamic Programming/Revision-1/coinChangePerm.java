import java.util.Arrays;

public class coinChangePerm {
    public static void main(String[] args) {
        int[] arr = {2,3,5,7};
        int tar = 10;

        // int cnt = permInfi(arr, tar);
        // System.out.println(cnt);

        //now permInfiMemo
        // int[] dp = new int[tar + 1];
        // Arrays.fill(dp, -1);
        // int cnt = permInfiMemo(arr, tar, dp);
        // System.out.println(cnt);

        // int cnt = permInfiDp(arr, tar);
        // System.out.println(cnt);

        // int count = combiInfi(arr, tar, 0);
        // System.out.println(count);
        int[][] dp = new int[tar + 1][arr.length];
        for(int i = 0; i  <= tar; i++){
            Arrays.fill(dp[i], -1);  //please keep it simple and safe
        }
        int count = combiInfi(arr, tar, 0, dp);  
        System.out.println(count);

    }

    //multiple test cases -
    //perm (single, infinite) (for, subseq)
    //comb (single, infinite) (for, susbseq)

    //HENCE TOTAL OF 8 WAYS bois
    //perm (single) (not optimised with dp) - not optimised!! 
    
    //PERMUTATION (infinite coins allowed)
    // (2,3,5,7) target - 10

    //FOR and SUBSEQ (two ways)
    //using recursion pehle socho - 
    public static int permInfi(int[] arr, int tar){
        if(tar == 0){
            return 1;
        }

        //now for loop from start everytime bruh!! (no worries)
        int count = 0;
        for(int i= 0; i < arr.length; i++){
            if(tar - arr[i] >= 0)
                count += permInfi(arr, tar - arr[i]);
        }

        return count;
    }

    //perfect code bois for permInfi
    public static int permInfiMemo(int[] arr, int tar, int[] dp){
        if(dp[tar] != -1){
            return dp[tar];
        }

        if(tar == 0){
            return 1;
        }

        int count = 0;
        for(int i= 0; i < arr.length; i++){
            if(tar - arr[i] >= 0)
                count += permInfi(arr, tar - arr[i]);
        }

        return dp[tar] = count;
    }

    //permInfiDp - complete
    public static int permInfiDp(int[] arr, int tar){
        int[] dp = new int[tar + 1]; 
        dp[0] = 1;  //base case returns 1 

        for(int i= 1; i <= tar; i++){
            for(int j = 0; j < arr.length; j++){  //simply cut and move on
                if(i - arr[j] >= 0){
                    dp[i] += dp[i - arr[j]];
                }
            }
        }

        return dp[tar];
    }


    //NOW UNDERSTAND COMBINATIONS BOIS - 

    // - (Single and infinity)  -

    //infinity case first for sure ( - let's try this one out - )    
    public static int combiInfi(int[] arr, int tar, int idx){  

        //base cases
        if(tar == 0) return 1;
        
        //otherwise run a for loop 
        int count = 0;
        for(int i = idx; i < arr.length; i++){
            if(tar - arr[i] >= 0){
                count += combiInfi(arr, tar - arr[i], i);
            } 
        }

        return count;
    }

    //combiInfiMemo
    public static int combiInfiMemo(int[] arr, int tar, int idx, int[][] dp){
        if(dp[tar][idx] != -1){
            return dp[tar][idx];
        }

        if(tar == 0) return 1;
        
        //now simple
        int count = 0;
        for(int i = idx; i < arr.length; i++){
            if(tar - arr[i] >= 0){
                count += combiInfi(arr, tar - arr[i], i);
            } 
        }

        return dp[tar][idx] = count;
    }

    //now actual 2D dp solve bois!! - let's look at the dp version once again no?
    public static int combiInfi(int[] arr, int tar){
        int[][] dp = new int[arr.length][tar + 1];  

        //how to traverse through and fill this dp is the question  
        //how to traverse now?? that's the questions bois 



    }

    


    




    
}
