import java.util.*;

public class numberOfDistinctIslands{
    public static void main(String[] args) {
        int[][] grid =  {
            {1,1,0,0,1},
            {1,0,0,0,0},
            {1,1,0,0,1},
            {0,1,0,1,1}
          };
    
        int ans = numberofDistinctIslands(grid);
        System.out.println(ans);
    }

    //MY FUCKING SOLUTION BOIS!!! 
    //RUNS FUCKING WELL FOR SURE BROS!!!

    //simple shit for sure now!!!
    public static int numberofDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Set<String> set = new HashSet<>();
      
        //after this move through all
        for(int i= 0; i < n; i++){
            for(int j= 0; j < m; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    StringBuilder sb = new StringBuilder();
                    dfsIslands(i,j, grid, vis, n, m, sb, 0);
                    String island = sb.toString();
                    System.out.println(island);
                    set.add(island);
                }
            }
        }

        
      
        return set.size();
    }

    //This fucker did run bitches!
    //This fucker runs too damn!!
    public static void dfsIslands(int x, int y, int[][] grid, boolean[][] vis, int n, int m, StringBuilder sb, int val){
        //move in four direction
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0, 1,-1};
        // char[] dir = {'U', 'L', 'D','R'};
    
        //after this 
        vis[x][y] = true;
        for(int i = 0; i < 4; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];
            
            if(cx >= 0 && cx < n && cy >= 0 && cy < m && !vis[cx][cy] && grid[cx][cy] == 1){
                sb.append(val + " " + (val + i) + " ");
                dfsIslands(cx, cy, grid, vis, n, m, sb, val + i + 1);                
            }
        }
    
        return;
    }
}

