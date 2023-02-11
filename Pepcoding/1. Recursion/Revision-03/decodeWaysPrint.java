import java.util.*;
import java.io.*;

public class decodeWaysPrint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "12034102";

        decodeWays(s, "", 0);
        decodeWaysOPT(s, "", 0);
    }
    
    //think of how you can solve it??
    public static void decodeWays(String s, String tillNow, int index){

        if(index == s.length()){
            System.out.println(tillNow);
            return;
        }

        if(s.charAt(index) == '0') return;

        //otherwise 
        char one = (char)((s.charAt(index) - '1') + 'A');
        decodeWays(s, tillNow + (char)((s.charAt(index) - '1') + 'A'), index + 1);

        if(index + 1 < s.length()){
            //then only play with your lives in here simple no?
            int l = s.charAt(index) - '0';
            int r = s.charAt(index + 1) - '0';

            int val = l * 10 + r;
            if(val > 26) return;

            //otherwise
            decodeWays(s, tillNow + (char)(val - 1 + 'A'), index + 2);
        }
    }

    //decent could but could be optimized at several places for sure!! 
    //OPTIMISED
    public static void decodeWaysOPT(String s, String tillNow, int index){
        if(index == s.length()){
            System.out.println(tillNow);
            return;
        }

        int num1 = s.charAt(index) - '0';
        if(num1 == 0) return;

        decodeWaysOPT(s, tillNow + (char)(num1 - 1 + 'A'), index + 1);

        if(index + 1 < s.length()){
            //then only play with your lives in here simple no?
            int num2 = s.charAt(index + 1) - '0';

            int val = num1 * 10 + num2;
            if(val > 26) return;

            //otherwise
            decodeWaysOPT(s, tillNow + (char)(val - 1 + 'A'), index + 2);
        }
    }



}
