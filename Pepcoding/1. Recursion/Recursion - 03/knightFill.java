import java.util.*;
import java.io.*;
import java.awt.Point;


public class knightFill{

    public static int[][] t;

    public static boolean knightFill(int cx, int cy, int ct , int n){

        
        //base case should be in the front
        //this change was important always remember that
        t[cx][cy] = ct;
        if(ct == (n*n-1)){
            
            for(int i = 0; i < n ;i++ ){
                for(int j = 0; j < n; j++){
                    System.out.print(t[i][j] + " ");
                }
                System.out.println();
            }
        
            return true;
        }

        // t[cx][cy] = ct;
        boolean res = false;
        for(int i = 0; i < 8; i++){
            int[] dx = {1,-1,1,-1,2,-2,2,-2};
            int[] dy = {2,-2,-2,2,1,-1,-1,1};

            int xn = cx + dx[i];
            int yn = cy + dy[i];

            if(!(xn >= 0 && yn >= 0 && xn < n && yn < n)) continue;
            if(t[xn][yn] != -1) continue;

            //brilliant stuff learned here
            //totally loved this technique
            //always remember this, if you want to

            //You can put flag here also
            //don't worry about that!!!
            res = res || knightFill(xn, yn, ct+1, n);
            if(res) {
                return true;
            }
        }

        t[cx][cy] = -1;
        return false;
    }


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        t = new int[n+1][n+1];

        for(int i = 0; i <= n; i++){
            Arrays.fill(t[i], -1);
        }

        knightFill(0, 0, 0, n);
    }
    
}
