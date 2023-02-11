import java.io.*;
import java.util.*;

public class knightTour {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] chess = new int[n][n];
        printKnightsTour(chess, r, c, 1);
        
    }

    public static void printKnightsTour(int[][] chess, int r, int c, int upcomingMove) {
        //kaafi kuch predone for sure
        int n = chess.length;
        int m = chess[0].length;
        
        if(upcomingMove == n*m){
            chess[r][c] = upcomingMove;
            displayBoard(chess);
            chess[r][c] = 0;
            return;
        }

        int[][] move = {{2,1},{2,-1},{1,2},{-1,2},{-2,1},{-2,-1},{1,-2},{-1,-2}};
        chess[r][c] = upcomingMove;

        for(int[] cmove : move){
            int cr = r + cmove[0];
            int cc = c + cmove[1];

            if(cr >= 0 && cr < n && cc >= 0 && cc < m){
                if(chess[cr][cc] == 0){
                    printKnightsTour(chess, cr, cc, upcomingMove + 1);
                }
            }
        }

        chess[r][c] = 0;
    }

    public static void displayBoard(int[][] chess){
        for(int i = 0; i < chess.length; i++){
            for(int j = 0; j < chess[0].length; j++){
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }
}