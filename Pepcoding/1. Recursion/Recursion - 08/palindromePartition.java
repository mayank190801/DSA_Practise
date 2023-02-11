import java.util.*;
import java.io.*;
import java.awt.Point;


public class palindromePartition{
    
    //my lame method
    //for sure lame bruh
    public static void solve(String given, int index, String ans){

        if(index == given.length()){
            System.out.println(ans);
            return;
        }

        solve(given, index+1, ans + given.charAt(index) + "|");
        solve(given, index+1, ans + given.charAt(index));
    }

    public static boolean palindromeCheck(String given , int left, int right){
        right = right -1;
        while(left <= right){
            if(given.charAt(left) != given.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    //sir method
    //if palindrome then move forward, otherwise return the bullshit
    //my way was put as many as i can
    //that would be 8 and then checking which one are and which are not 
    //same i guess 
    public static int palindromeParition(String str, int idx, String ans){
        if(idx >= str.length()){
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for(int i = idx ; i < str.length(); i++){

            if(palindromeCheck(str, idx, i+1)){
                String palin = str.substring(idx, i+1);
                String added = "(" +palin + ")";
                count += palindromeParition(str, i+1, ans + added );
            }
            //otherwise move on
        }
        
        return count;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        //we have to
        String given = "pep";
        // solve(given, 0, "");
        palindromeParition(given, 0, "");

        //doubt regarding this question
        //if we would first make all the cut and then check each and every one
        //simple as that.
        //so figure that out everytime bruh

    }
    
}
