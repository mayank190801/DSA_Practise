import java.util.*;
import java.io.*;
import java.awt.Point;


public class factorial {

    public static void factorial(int n , int ans){
        if(n == 0){
            System.out.println(ans);
            return;
        }

        factorial(n-1, n*ans);
    }

    public static int fact(int n){
        if(n == 0) return 1;
        return n * fact(n-1);
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        fact(5);
        factorial(5, 1);
    }
    
}
