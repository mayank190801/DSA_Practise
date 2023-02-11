import java.util.*;
import java.io.*;
import java.awt.Point;


public class restoreIP{

    public static void solve(char[] inp, int index, String ans, int dot){

        // System.out.println(dot);
        // System.out.println(ans);
        if(index == inp.length ){
            if(dot == 4){
                System.out.println(ans.substring(0, ans.length()-1));
            }  
            return;
        }

        int num1 = inp[index] - '0';
        solve(inp, index+1, ans + num1 + ".", dot + 1);

        if(num1 == 0) return;

        int num2digit = 23;
        if(index + 1 < inp.length){
            int num2 = inp[index+1] - '0';
            num2digit = num1*10 + num2;
            solve(inp, index+2, ans + num2digit + ".", dot + 1);    
        }
       
        if(index + 2 < inp.length){
            int num3 = inp[index+2] - '0';
             int num3digit = num2digit*10 + num3;
            if(num3digit <= 255)
                solve(inp, index+3, ans + num3digit + ".", dot + 1);
        }
    }
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        char[] inp = sc.nextLine().toCharArray();

        solve(inp, 0 , "" , 0);
    }
    
}
