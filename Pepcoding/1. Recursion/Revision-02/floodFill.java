import java.util.*;
import java.io.*;

public class floodFill {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scn.nextInt();
            }
        }
        arr[0][0] = 2;
        floodfill(arr, 0, 0, "");
    }

    // asf -> answer so far 
    //
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static char[] sign = {'r','l','t','d'};

    //let's figure this out for sure
    public static void floodfill(int[][] maze, int sr, int sc, String asf) {

        int row = maze.length;
        int col = maze[0].length;
    
        if(sr == maze.length - 1 && sc == maze[0].length - 1){
            System.out.println(asf);
            return;
        }

        //otherwise try to move in four directions for sure 
        for(int i = 0; i < 4; i++){
            int cx = sr + dx[i];
            int cy = sc + dy[i];

            if(cx >= 0 && cx < row && cy >= 0 && cy < col && maze[cx][cy] == 0){
                maze[cx][cy] = 2;
                floodfill(maze, cx, cy, asf + sign[i]);
                maze[cx][cy] = 0;
            }
        }
    }
    
}
