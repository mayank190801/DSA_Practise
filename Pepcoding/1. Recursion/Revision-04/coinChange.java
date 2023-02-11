public class coinChange {

    public static void main(String[] args) {
        int[] coins = { 2, 3, 5, 7 };

        System.out.println("infi perm");
        infiPermutationFor(coins, 10, "");
        System.out.println();
        System.out.println("infi comb");
        infiCombinationFor(coins, 10, "", 0);
        System.out.println();
        System.out.println("single perm");
        singlePermutationFor(coins, 10, "", new int[coins.length]);
        System.out.println();
        System.out.println("single comb");
        singleCombinationFor(coins, 10, "", 0);


        //------------------------------------------------
        System.out.println();
        infiPermSubseq(coins, 10, 0, "");
        System.out.println();
        infiCombSubseq(coins, 10, 0, "");
        System.out.println();
        singlePermSubseq(coins, 10, 0, "");
        System.out.println();
        singleCombSubseq(coins, 10, 0, "");
        System.out.println();
        // singleperSubseq(coins, 10, 0, "");

    }

    //FOR
    //permutation infi 
    //permutation single
    //combination infi
    //combination single

    //SUBSEQ
    //permutation infi
    //permutation single
    //combination infi
    //combination single

    //------------------------------------------------------//------------------------------------------------------
    
    // infi permuation using for
    public static void infiPermutationFor(int[] coins, int tar, String ans){
        if(tar == 0){
            System.out.println(ans);
            return;
        }

        for(int i = 0; i < coins.length; i++){
            if(tar - coins[i] >= 0){
                infiPermutationFor(coins, tar - coins[i], ans + coins[i]);
            }    
        }
    }

    //infi combination using for
    public static void infiCombinationFor(int[] coins, int tar, String ans, int index){
        if(tar == 0){
            System.out.println(ans);
            return;
        }

        for(int i = index; i < coins.length; i++){
            if(tar - coins[i] >= 0){
                infiCombinationFor(coins, tar - coins[i], ans + coins[i], i);
            }    
        }
    }

    //single permutation using for
    public static void singlePermutationFor(int[] coins, int tar, String ans, int[] vis){
        if(tar == 0){
            System.out.println(ans);
            return;
        }

        for(int i = 0; i < coins.length; i++){
            if(vis[i] == 1) continue;
            vis[i] = 1;
            if(tar - coins[i] >= 0){
                singlePermutationFor(coins, tar - coins[i], ans + coins[i], vis);
            }    
            vis[i] = 0;
        }
    }

    //single combination using for 
    public static void singleCombinationFor(int[] coins, int tar, String ans, int index){
        if(tar == 0){
            System.out.println(ans);
            return;
        }

        for(int i = index; i < coins.length; i++){
            if(tar - coins[i] >= 0){
                infiCombinationFor(coins, tar - coins[i], ans + coins[i], i + 1);
            }    
        }
    }


    //------------------------------------------------------//------------------------------------------------------

    public static void infiPermSubseq(int[] coins, int tar, int idx, String ans) {
        if(idx == coins.length){
            if(tar == 0){
                System.out.println(ans);
            }
            return;
        }
        
        //if you take go to start!!
        //otherwise keep moving on brother
        if(tar - coins[idx] >= 0)
            infiPermSubseq(coins, tar - coins[idx], 0, ans + coins[idx]);

        infiPermSubseq(coins, tar, idx + 1, ans);
    }

    public static void infiCombSubseq(int[] coins, int tar, int idx, String ans){
        if(idx == coins.length){
            if(tar == 0){
                System.out.println(ans);
            }
            return;
        }
        
        //if you take go to start!!
        //otherwise keep moving on brother
        if(tar - coins[idx] >= 0)
            infiCombSubseq(coins, tar - coins[idx], idx, ans + coins[idx]);

        infiCombSubseq(coins, tar, idx + 1, ans);
    }

    //way too sexy solve for this one for sure!! (i don't think i so i would remember it till then)
    public static void singlePermSubseq(int[] coins, int tar, int idx, String ans){
        if(idx == coins.length){
            if(tar == 0){
                System.out.println(ans);
            }
            return;
        } 
     
        //if you take go to start!!
        //otherwise keep moving on brother
        if(tar - coins[idx] >= 0 && coins[idx] > 0){
            coins[idx] = -coins[idx];
            singlePermSubseq(coins, tar + coins[idx], 0, ans + (-coins[idx]));
            coins[idx] = -coins[idx];
        }

        singlePermSubseq(coins, tar, idx + 1, ans);
    }

    public static void singleCombSubseq(int[] coins, int tar, int idx, String ans){
        if(idx == coins.length){
            if(tar == 0){
                System.out.println(ans);
            }
            return;
        }
        
        //if you take go to start!!
        //otherwise keep moving on brother
        if(tar - coins[idx] >= 0)
            singleCombSubseq(coins, tar - coins[idx], idx + 1, ans +  coins[idx]);

        singleCombSubseq(coins, tar, idx + 1, ans);
    }

}
