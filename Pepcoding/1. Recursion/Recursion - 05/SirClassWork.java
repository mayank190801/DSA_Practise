import java.util.*;
import java.io.*;
import java.awt.Point;




public class SirClassWork{

    //this infiCombination
    public static int infiCombiSequence(int[] coins, int target, int index, String ans){

        //in try of reduce complexity
        if(target == 0 || index == coins.length){
            if(target == 0)
                System.out.println(ans);
            return target == 0 ? 1 : 0;
        }
    
        int count = 0;
        if(coins[index] <= target){
            count += infiCombiSequence(coins, target-coins[index], index, ans + coins[index]);
        }
        count += infiCombiSequence(coins, target, index+1, ans);

        return count;
    }

    //this singleCombination
    public static int singleCombiSequence(int[] coins, int target, int index, String ans){

        //in try of reduce complexity
        if(target == 0 || index == coins.length){
            if(target == 0)
                System.out.println(ans);
            return target == 0 ? 1 : 0;
        }
    
        int count = 0;
        if(coins[index] <= target){
            count += singleCombiSequence(coins, target-coins[index], index+1, ans + coins[index]);
        }
        count += singleCombiSequence(coins, target, index+1, ans);

        return count;
    }

    //this infinite permutation
    public static int infiPermutationSequence(int[] coins, int target, int index, String ans){

        //in try of reduce complexity
        if(target == 0 || index == coins.length){
            if(target == 0)
                System.out.println(ans);
            return target == 0 ? 1 : 0;
        }
    
        int count = 0;
        if(coins[index] <= target){
            count += infiPermutationSequence(coins, target-coins[index], 0, ans + coins[index]);
            // count += infiPermutationSequence(coins, target-coins[index], index, ans+ coins[index]);
        }
        count += infiPermutationSequence(coins, target, index+1, ans);

        return count;
    }

    //this is sinle Permutation subsequence
    public static int singlePermutationSubseq(int[] coins, int target, int index, String ans){

        //in try of reduce complexity
        if(target == 0 || index == coins.length){
            if(target == 0)
                System.out.println(ans);
            return target == 0 ? 1 : 0;
        }
    
        int count = 0;
        if(coins[index] > 0 && coins[index] <= target){
            coins[index] = - coins[index]; //visied[idx] = true;
            count += singlePermutationSubseq(coins, target + coins[index], 0, ans + (-coins[index]));
            // count += singlePermutationSubseq(coins, target-coins[index], index, ans+ coins[index]);
            coins[index] = - coins[index]; //visited[idx] = false;
        }
        count += singlePermutationSubseq(coins, target, index+1, ans);

        return count;
    }



    

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int[] coins = {2,3,5,7};
        int target = 10;

        //brilliant way of solving this problem in the subsequence manner
        //pretty cool bitch
        infiCombiSequence(coins, target, 0, "");
        System.out.println();
        singleCombiSequence(coins, target, 0, "");
        System.out.println();
        infiPermutationSequence(coins, target, 0, "");
        System.out.println();
        singlePermutationSubseq(coins, target, 0, "");


    }
    
}
