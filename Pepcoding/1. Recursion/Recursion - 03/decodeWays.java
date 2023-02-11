import java.util.*;
import java.io.*;
import java.awt.Point;


public class decodeWays{

    public static void decode(int index, String ans, String given){

        if(index == given.length()){
            System.out.println(ans);
            return;
        }

        //this is brilliant conversion for sure
        //this is for one digit
        char ch = given.charAt(index);
        int num1 = ch -'0';
        if(num1 == 0) return;
        decode(index+1, ans + (char)('A' + num1 - 1) , given);

        //now we will write for two digit
        if(index + 1 < given.length()){
            char ch2 = given.charAt(index+1);
            int num2 = ch2 -'0';
            int num = num1*10 + num2;

            //important condition
            if(num <= 26)
                decode(index+2, ans + (char)('A' + num -1), given);
        }
    }

    
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String s = "12034102";

        decode(0, "", s);
    }
    
}
