import java.util.*;
import java.io.*;
import java.awt.Point;


public class QueenPermBox{


    //this is what i wrote on my own, if the direct answer was asked
    //so this was not very hard, simple logic of how you are placing stuff
    //it gives perfect answer 
    public static int queenComb(int box, int queen, int index){
        if(index == box){
            if(queen == 0){
                return 1;
            }
            return 0;
        }

        int ans = 0;
        if(queen > 0)
            ans += queenComb(box, queen-1, index+1);
        ans += queenComb(box, queen, index+1);

        return ans;
    }

    public static int queenPerm(int box, int queen, int index, int[] visited){
        if(index == box){
            if(queen == 0){
                return 1;
            }
            return 0;
        }

        int ans = 0;
        if(visited[index] == 0 && queen > 0){
            visited[index] = 1;
            ans += queenPerm(box, queen-1, 0, visited);
            visited[index] = 0;
        }
        ans += queenPerm(box, queen, index+1, visited);

        return ans;
    }


   ////////////////////////////////////////////////////////////////////////////////
   ////////////////////////////////////////////////////////////////////////////////
   ////////////////////////////////////////////////////////////////////////////////
   ////////////////////////////////////////////////////////////////////////////////


   //this is done using sir method, pretty cool no???
    public static int queenComb(int tno, int bno,  int tnq, int qpsf, String ans){
        if(bno == tno){
            if(qpsf == tnq){
                System.out.println(ans);
                return 1;
            }
            return 0;
        }

        int curr = 0;
        if(tnq > qpsf){
            curr += queenComb(tno, bno+1, tnq, qpsf+1, ans + "bno->" + (bno) + " " + "qno->" + (qpsf) + "\n");
        }
        curr += queenComb(tno, bno+1, tnq, qpsf, ans);

        return curr;
    }

    // public static int queenPerm(int tno, int bno,  int tnq, int qpsf, String ans, int[] visited){
    //     if(bno == tno){
    //         if(qpsf == tnq){
    //             System.out.println(ans);
    //             return 1;
    //         }
    //         return 0;
    //     }

    //     int curr = 0;
    //     if(tnq > qpsf && visited[bno] == 0){
    //         visited[bno] = 1;
    //         curr += queenPerm(tno, 0, tnq, qpsf+1, ans + "bno->" + (bno) + " " + "qno->" + (qpsf) + "\n");
    //         visited[bno] = 0;
    //     }
    //     curr += queenPerm(tno, bno+1, tnq, qpsf, ans, visited);

    //     return curr;
    // }

    //if we would have to solve this question using for loop and not subsequences
    //then what bitch???, then what would you do???, this is lil complicated stuff, but really cool
    //to be honest i love it

    //using for loop with sir arguments, pretty cool
    public static int queenCombFor(int tno, int bno,  int tnq, int qpsf, String ans){
        
        if(qpsf == tnq){
            System.out.println(ans);
            return 1;
        }
       
        int count = 0;
        for(int b = bno ; b < tno; b++){
            count += queenCombFor(tno, b+1, tnq, qpsf+1, ans + "bno->" + (b) + " " + "qno->" + (qpsf) + "\n");
        }

        return count;
    }


    //using for loop with queen perm this time
    public static int queenPermFor(int tno, int bno,  int tnq, int qpsf, String ans, int[] visited){
        
        if(qpsf == tnq){
            System.out.println(ans);
            return 1;
        }
     
        int curr = 0;
        for(int b = bno ; b < tno; b++){

            if(visited[b] == 1) continue;
            visited[b] = 1;
            curr += queenPermFor(tno, 0, tnq, qpsf+1, ans + "bno->" + (b) + " " + "qno->" + (qpsf) + "\n", visited);
            visited[b] = 0;
        }
    
        return curr;
    }


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int box = 7;
        int queen = 3;

        // int answer = queenComb(box,queen,0);
        // System.out.println(answer);

        // System.out.println();
        int[] visited = new int[box+1];
        // int ans = queenPerm(box, queen, 0, visited);
        // System.out.println(ans);
        // System.out.println();
        // int qc = queenComb(box, 0, queen, 0, "");
        // System.out.println(qc);
        // System.out.println();
        // int[] vis = new int[box+2];
        // int qp = queenPerm(box, 0, queen, 0, "", vis);
        // System.out.println(qp);
        // int ans = queenCombFor(box, 0, queen, 0, "");
        // System.out.println(ans);

        int ans = queenPermFor(box, 0, queen, 0, "", visited);
        System.out.println(ans);
    }

    
}
