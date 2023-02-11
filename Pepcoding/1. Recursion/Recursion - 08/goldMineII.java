import java.util.*;
import java.io.*;
import java.awt.Point;


public class goldMineII{

    public static int collectGoldWithGivenStart(int[][] mat, int i, int j){
        //now go in depths according to

        mat[i][j] = -mat[i][j];
        int branches = 0;

        int[][] dir = {{-1,0}, {1,0},{0,-1},{0,1}};
        for(int k = 0; k < 4; k++){
            int nr = i + dir[k][0];
            int nc = j+ dir[k][1];

            if(nr >= 0 && nc >= 0 && nr < mat.length && nc < mat[0].length && mat[nr][nc] > 0){
                int ans = collectGoldWithGivenStart(mat, nr, nc); 
                branches = Math.max(branches, ans);   
            }
        }
        mat[i][j] = -mat[i][j];

        return branches + mat[i][j];
    }

    public static void goldMine(int[][] mat){
        int ans =0;
        for(int i= 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length ; j++){
                if(mat[i][j] > 0){
                    int cans = collectGoldWithGivenStart(mat, i, j);
                    ans = Math.max(cans , ans);
                }

            }
        }

        System.out.println("THIS IS THE MAXIMUM ANSWER");
        System.out.println(ans);
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        //first make this mat array please for ease of the game
        
        int[][] mat = new int[4][4];




    }
    
}
