import java.util.ArrayList;
import java.util.*;
import java.io.*;
import java.util.Arrays;

public class nQueensMaxOpti{
    
  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    var ans = solveNQueens(n);
    System.out.println(ans);
  }  

  public static List<List<String>> solveNQueens(int n) {
    //simply isko solve kr do boss - using 2d as 1d array for sure now
    List<List<String>> ans = new ArrayList<>();
    boolean[][] board = new boolean[n][n];

    solver(n, 0, 0, board, ans, new int[n], new int[n], new int[2*n - 1], new int[2*n - 1]);
    return ans;
  }
  //now simply call the function nQueens

    public static void solver(int n, int floor, int queensPlaced, boolean[][] board, List<List<String>> ans, int[] rows, int[] cols, int[] d1, int[] d2){
        //combinations solved using for loops let's say
        if(queensPlaced == n){
            List<String> cans = new ArrayList<>();
            
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(board[i][j]){
                        // System.out.print('Q');
                        sb.append('Q');
                    }else{
                        // System.out.print('.');
                        sb.append('.');
                    }
                }

                String temp = sb.toString();
                cans.add(temp);
                sb = new StringBuilder();
                
            }
            
            ans.add(cans);
            return;
        }
        
        //there are some more optimisation baby
        //if you are done with this floor, then fucking go the next one!
        for(int room = 0; room < n; room++){  //checking at that given floor if someone exists or not
            int row = floor;
            int col = room;
            if(!(rows[row] == 1 || cols[col] == 1 || d1[row + col] == 1 || d2[row - col + n - 1] == 1)){
                board[row][col] = true;
                rows[row] = 1;
                cols[col] = 1;
                d1[row + col] = 1;
                d2[row - col + n - 1] = 1;

                solver(n, floor + 1,  queensPlaced + 1, board, ans, rows, cols, d1, d2);                

                //demark everything in here
                board[row][col] = false;
                rows[row] = 0;
                cols[col] = 0;
                d1[row + col] = 0;
                d2[row - col + n - 1] = 0;
            }
        }   
    }

}
