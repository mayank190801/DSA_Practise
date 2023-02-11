import java.util.*;
import java.io.*;
import java.awt.Point;


public class QueenPerm2D{

    //You could simply use bno and convert to x and y!
    //SIMPLE AS THAT
    //USE PREVIOUS FUCKING CODE ONLY

    //TRICK ONE O ONE
    //idx = r * col + c;
    //r = idx/col;
    //c = idx%col;

    //we have to right code in four format
    //first would be for loop
    //for combiniat
    public static int forCombi(int row, int col, int rc, int cc, int qto, int qpsf , String ans){

        if(qpsf == qto){
            System.out.println(ans);
            return 1;
        }
        
        int curr = 0;
        for(int i = rc; i < row; i++){
            for(int j = cc; j < col; j++){
                //this is hella confusing man!!!
                if(cc+1 != col){
                    curr += forCombi(row, col, rc, cc+1, qto, qpsf+1, ans + "r" + rc + " " + "c" + cc + " " + "q" + qpsf + " ");
                }else{
                    curr += forCombi(row, col, rc+1, 0, qto, qpsf+1, ans + "r" + rc + " " + "c" + cc + " " + "q" + qpsf + " ");
                }
            }
        }

        return curr;
    }


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        //now i would have to place things in 2D order with recursion
        int row = 3;
        int col = 4;    

        int queen = 3;
        //then print also
        int ans = forCombi(row, col, 0, 0, queen, 0, "");



    }
    
}
