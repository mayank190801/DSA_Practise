import java.util.*;
import java.io.*;
import java.awt.Point;


public class friendPairing{
    public static void main(String[] args){

        //int n is given and print all the pairing bruh
        //int n can ke liye answer that's it
        //idx+1 always

        //simple changes can help solve it
        //heheh - stupid question

        friendsPairing(3);
    }

    public static void friendsPairing(int n){
        boolean[] used = new boolean[n+1];
        int answer = friendsPairing(n,used,1,"");
        System.out.println(answer);
    }

    public static int friendsPairing(int n , boolean[] used, int num , String ans){

        if(num > n){
            System.out.println(ans);
            return 1;
        }
    
        int count = 0;
        if(used[num] == false){

            used[num] = true;
            count += friendsPairing(n, used, num+1, ans + "(" + num + ")");
            for(int i= num+1; i <= n; i++){
                if(used[i] == true) continue;                 
                used[i] = true;
                count += friendsPairing(n, used, num+1, ans + "(" + num + "" + i + ")" );
                used[i] = false;
            }
            used[num] = false;
        }else{
            count += friendsPairing(n, used, num+1, ans);
        }

        return count;
    }


}
