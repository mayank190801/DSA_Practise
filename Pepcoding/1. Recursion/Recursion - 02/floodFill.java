import java.util.*;
import java.io.*;
import java.awt.Point;


public class floodFill{

    public static int[][] t;

    //try again on your own for more clarity please
    //solve these question one and for all
    public static void solve(int n, int m, int sn, int sm, String ans){

        if(sn+1 == n && sm+1 == m){
            System.out.println(ans);
            return;
        }

        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        char[] dir = {'D', 'U', 'R','L'};

        t[sn][sm] = 1;

        for(int i = 0; i < 4; i++){
            //int new 
            int xn = sn + dx[i];
            int yn = sm + dy[i];

            if(!(xn >= 0 && xn < n && yn >= 0 && yn < m)) continue;
            
            if(t[xn][yn] == 1) continue;
            solve(n, m, xn, yn, ans + dir[i]);
            
        }

        t[sn][sm] = 0;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = 3;
        int m = 3;
        t = new int[n+1][m+1];

        solve(n, m, 0, 0, "");
    }
    
}
