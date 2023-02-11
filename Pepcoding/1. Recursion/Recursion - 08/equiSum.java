import java.util.*;
import java.io.*;
import java.awt.Point;


public class equiSum{

    public static int solve(int[] arr, int leftSum, int rightSum , int index, String set1 , String set2){

        if(index == arr.length){
            if(leftSum == rightSum){
                System.out.println(set1 + " == " + set2);
                return 1;
            }
            return 0;
        }

        int count = 0;
        count += solve(arr, leftSum + arr[index], rightSum, index+1 , set1 + arr[index] + "+" , set2);
        count += solve(arr, leftSum, rightSum + arr[index], index+1, set1, set2 + arr[index] + "+");

        return count;
    }

    public static int removeDuplicacy(int[] arr, int leftSum, int rightSum , int index, String set1 , String set2){

        if(index == arr.length){
            if(leftSum == rightSum){
                System.out.println(set1 + " == " + set2);
                return 1;
            }
            return 0;
        }

        int count = 0;
        count += removeDuplicacy(arr, leftSum + arr[index], rightSum, index+1 , set1 + arr[index] + "+" , set2);
        count += removeDuplicacy(arr, leftSum, rightSum + arr[index], index+1, set1, set2 + arr[index] + "+");

        return count;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int[] arr = {10,20,30,40};

        //set1 and set2
        //subsequences bullshit
        int answer = solve(arr, 0, 0, 0, "", "");        
        System.out.println(answer);
        int answerr = removeDuplicacy(arr, arr[0], 0, 1, "" + arr[0] + "+" , "");
        System.out.println(answerr);
    }
    
}
