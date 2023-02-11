import java.util.*;
import java.io.*;
import java.awt.Point;


public class combinationSum{


    public static  List<List<Integer>> answer = new ArrayList<>();

    // public static void coinsCombinationsI(int[] coins, int target, int index, List<Integer> smallans){

    //     //so till here it is perfect for sure
    //     //now we gotta do some editing in here 
    //     //gotta make a deep copy and store it in the questoins
    //     if(target == 0) {
    //         //used for data copy and not reference copy babies
    //         answer.add(new ArrayList<>(smallans));
    //         return;
    //     }

    //     for(int i = index; i < coins.length; i++)
    //         if(coins[i] <= target){
    //             smallans.add(coins[i]);
    //             coinsCombinations(coins, target-coins[i], i, smallans);
    //             smallans.remove(smallans.size()-1);
    //         }                
            
    //     return;
    // }

    // public static void uniqueCombinationsII(int[] coins, int target, int index, List<Integer> smallans, List<List<Integer>> answer){
        
    //     if(target == 0){
    //         answer.add(new ArrayList<>(smallans));
    //         return;
    //     }
    
    //     for(int i= index ; i < coins.length ; i++){
    //         if(coins[i] <= target){
    //               //with a simple line i can solve this code 
    //             //hehehe
    //             if(i != index && coins[i] == coins[i-1]) continue;
                
    //             smallans.add(coins[i]);
    //             uniqueCombinations(coins, target- coins[i], i+1, smallans, answer);
    //             smallans.remove(smallans.size() -1);     
    //         }
    //     }
        
    //     return;
    // }

    //one more way of selecting infinite combination using subsequence method
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

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int[] coins = {2,3,5,7};
        int target = 10;

        // coinsCombinations(coins, target, 0, new ArrayList<>());
        // System.out.println(answer);

        int ans = infiCombiSequence(coins, target, 0, "");
        // System.out.println(ans);
    }
    
}


