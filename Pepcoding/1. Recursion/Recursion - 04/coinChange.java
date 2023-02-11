import java.util.*;
import java.io.*;
import java.awt.Point;


public class coinChange{

    //infinite coins

    //coinsPermutations
    public static int coinsPermutation(int[] coins, int target){

        if(target == 0) return 1;

        int ans = 0;
        for(int i = 0; i < coins.length; i++)
            if(coins[i] <= target)
                ans += coinsPermutation(coins, target-coins[i]);
            
        return ans;
    }

    //coinsCombinations
    public static int coinsCombinations(int[] coins, int target, int index, String temp){

        if(target == 0) {
            System.out.println(temp);
            return 1;
        }

        int ans = 0;
        for(int i = index; i < coins.length; i++)
            if(coins[i] <= target)
                ans += coinsCombinations(coins, target-coins[i], i, temp + coins[i]);
            
        return ans;
    }

    //single coins

    //combinations
    public static int singleCoinCombi(int[] coins, int target, int index, String temp){

        if(target == 0) {
            System.out.println(temp);
            return 1;
        }

        int ans = 0;
        for(int i = index; i < coins.length; i++)
            if(coins[i] <= target)
                ans += singleCoinCombi(coins, target-coins[i], i+1, temp + coins[i]);
            
        return ans;
    }

    //permutations
    public static int sinleCoinPerm(int[] coins, int target, int[] arr, String answer){

        if(target == 0){
            System.out.println(answer);
            return 1;
        } 

        int ans = 0;
        for(int i = 0; i < coins.length; i++){
            if(coins[i] <= target && arr[i] == -1){
                arr[i]=1;
                ans += sinleCoinPerm(coins, target-coins[i], arr, answer + coins[i]);
                arr[i]= -1;
            }
        }
       
        return ans;
    }


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int[] coins = {2,3,5,7};
        int target = 10;

        int perm = coinsPermutation(coins, target);
        System.out.println(perm);

        System.out.println();
        System.out.println();

        int comb = coinsCombinations(coins, target, 0, "");
        System.out.println(comb);

        System.out.println();
        int singleComb = singleCoinCombi(coins, target, 0, "");
        System.out.println(singleComb);

        System.out.println();

        int[] arr= new int[coins.length];

        Arrays.fill(arr, -1);
        int sinlePerm = sinleCoinPerm(coins, target, arr, "");
        System.out.println(sinlePerm);
    }
    
}
