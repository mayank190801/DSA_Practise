import java.util.*;
import java.io.*;

public class nQueensEvenMore {

    public static boolean isValidToPlace(boolean[][] board, int r, int c){
        int[][] dir = {{0,-1}, {-1,0}, {-1,-1}, {-1,1}};

        for(int k = 1; k < board.length; k++){
            for(int i= 0; i < dir.length; i++){
                int nr = r + dir[i][0]*k;
                int nc = c + dir[i][1]*k;

                if(nr >= 0 &&  nc >= 0 && nr < board.length && nc < board.length){
                    if(board[nr][nc]) return false;
                }
            }
        }

        return true;
    }

    public static boolean isValidToPlaceUpdate(boolean[][] board, int r, int c){
        int[][] dir = {{0,-1}, {-1,0}, {-1,-1}, {-1,1}};

        for(int i= 0; i < dir.length; i++){
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];

            while(nr >= 0 &&  nc >= 0 && nr < board.length && nc < board.length){
                if(board[nr][nc]) return false;
                nr += dir[i][0];
                nc += dir[i][1];
            }
        }
    
        return true;
    }

    public static int nQueen( int[][]board, int floor, int tnq , String ans, boolean[] row, boolean[] col, boolean[] d1, boolean[] d2 , List<List<String>> answer){

        if(tnq == 0){
            // System.out.println(ans);
            //banao ek list puri string
            List<String> temp = new ArrayList<>();
            
            for(int i= 0; i < board.length; i++){
                StringBuilder sb = new StringBuilder();
                for(int j= 0; j < board.length; j++)
                    sb.append(board[i][j] == 1 ? 'Q' : '.');
                String rand = sb.toString();
                temp.add(rand);
            }

            answer.add(temp);
            // System.out.println(Arrays.deepToString(board));
            return 1;
        }

        int res = 0;
        for(int room = 0; room < row.length; room++){
            int r = floor;
            int c = room;

            if(!row[r] && !col[c] && !d1[r+c] && !d2[r-c+row.length-1]){
                //brriliant check to do babies
                //this way we don't have to che ck again and again
                row[r] = true;
                col[c] = true;
                d1[r+c] = true;
                d2[r-c+row.length-1] = true; 
                board[r][c] = 1;
                res += nQueen(board, floor+1, tnq-1, ans + "r" + r + " c" + c + "\n", row, col, d1, d2, answer);
                board[r][c] = 0;
                row[r] = false;
                col[c] = false;
                d1[r+c] = false;
                d2[r-c+row.length-1] = false; 
            }  
        }

        return res;
    }

    public static void main(String[] args){
        long st = System.currentTimeMillis();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        List<List<String>> answer = new ArrayList<>();

        int ans =  nQueen(board, 0, n, "", new boolean[n], new boolean[n], new boolean[2*n-1], new boolean[2*n-1] , answer);
        long et=  System.currentTimeMillis();
        System.out.println(answer);
        System.out.println(ans);
        // System.out.println(et-st);
    }

}
