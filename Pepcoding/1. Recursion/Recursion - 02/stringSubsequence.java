import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
import java.awt.Point;


public class stringSubsequence{

    //this one freakin works
    public static void solve(String str, int index, String temp){
        if(index == str.length()){
            System.out.println(temp);
            return;
        } 

        //perfect
        solve(str, index+1, temp);
        solve(str, index+1, temp + str.charAt(index));
    }

    //next time returned version will be used
    //my method of doing things
    // public static ArrayList<String> all = new ArrayList<>();

    // public static String solveRet(String str, int index){
        
    //     if(index < 0){
    //         return "";
    //     }

    //     if(index == 0){
    //         String curr = solveRet(str, index+1);
    //         all.add(curr);
    //         all.add(curr + str.charAt(index));
    //     }
    // }

    //Sir code logic
    public static ArrayList<String> subs(String str, int idx){

        //base case for this question
        if(idx == str.length()){
            //important logic of the code
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        //faith condition should look like this
        ArrayList<String> recAns = subs(str, idx+1);//answer for bc
        ArrayList<String> ans = new ArrayList<>();//answer for abc

        int n = recAns.size();
        for(int i = 0; i < n; i++){
            recAns.add(recAns.get(i) + str.charAt(idx));
        }

        return recAns;
    }


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        String str=  "abc";
        solve(str, 0, "");

        var list = subs("abc", 0);
        System.out.println(list);
    }
    
}
