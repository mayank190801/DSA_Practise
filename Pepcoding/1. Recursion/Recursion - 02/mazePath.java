import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
import java.awt.Point;


public class mazePath{

    //print all the ways for the maze path
    //2D in horizontal and vertical manner
    //let's see

    //i am good with void types for sure

    //always prefer proactive method
    //proactive method
    //also try reactive type if you can
    public static void maze(int n, int m, int currn, int currm, String ans){
        if(currn+1 == n && currm+1 == m){
            System.out.println(ans);
            return;
        }
        //otherwise
        if(currm < m) maze(n, m, currn, currm+1, ans + "H");
        if(currn < n) maze(n, m, currn+1, currm, ans + "V");
    }

    //return type for now
    //proactive version 
    public static ArrayList<String> mazeRet(int n, int m, int currn, int currm){

        if(n == currn+1 && m == currm+1){
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }
        
        ArrayList<String> temp = new ArrayList<>();

        if(currm < m){
            var tempRight = mazeRet(n, m, currn, currm+ 1);
            for(String s : tempRight){
                temp.add('H'+ s);
            }
        }
       
        if(currn < n){
            var tempDown = mazeRet(n, m, currn+1, currm);
            for(String s : tempDown){
                temp.add('V'+ s);
            }
        }
       
        return temp;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        maze(3, 3, 0, 0, "");

        var ans = mazeRet(3, 3, 0, 0);
        System.out.println(ans);
        
    }
    
}
