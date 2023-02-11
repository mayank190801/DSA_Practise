import java.util.*;
import java.io.*;
import java.awt.Point;


public class power{

    //this is void type
    public static void pow(int a, int b, int ans){
        if(b== 0){
            System.out.println(ans);
            return;
        }
        pow(a, b-1, ans*a);
    }

    //this is return type
    public static int pow(int a, int b){
        if(b== 1) return a;
        return pow(a,b-1)*a;
    }

    public static int optipow(int a, int b){

        if(b == 0){
            return 1;
        }
        
        int x = optipow(a, b/2);
        if(b%2 == 0){
            return x * x;
        }else{
            return x * x * a;
        }
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        // int x = sc.nextInt();
        System.out.println(pow(2,5));
        pow(2,5,1);

        System.out.println(optipow(2, 9));
    }
    
}
