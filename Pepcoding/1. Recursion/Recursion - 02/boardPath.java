import java.util.*;
import java.io.*;
import java.lang.reflect.Array;
import java.awt.Point;


public class boardPath{

    //VOID TYPE
    //this is reactive code
    //try writing the proactive code for this problem
    //asap
    public static void boardPath(int req, int curr, String path){

        if(curr > req) return;

        if(curr == req){
            System.out.println(path+req);
            return;
        }

        //otherwise jump in both
        String temp = path + curr;
        boardPath(req, curr+1, temp);
        boardPath(req, curr+2, temp);
        boardPath(req, curr+3, temp);
    }

    public static void proactiveBoard(int req, int curr, String path){
        if(curr == req){
            System.out.println(path+curr);
            return;
        }

        for(int i = 1; i <= 3; i++){
            if(curr + i > req) break;
            proactiveBoard(req, curr+i, path+curr);
        }
    }


    //return type 
    //reactive version

    //Try writing proactive version for sure!!!
    public static ArrayList<String> board(int n , int curr){
        if(curr > n) return new ArrayList<>();
        if(curr == n){
            ArrayList<String> base = new ArrayList<>();
            base.add(String.valueOf(n));
            return base;
        }

        ArrayList<String> temp = new ArrayList<>();
        for(int i = 1; i <= 3; i++){
            var list = board(n, curr + i);
            for(String s : list){
                temp.add(curr + s);
            }
        }

        return temp;
    }
    
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        proactiveBoard(5, 0, "");

        var temp = board(5, 0);
        System.out.println(temp);
        
        System.out.println(temp.size());
    }
    
}
