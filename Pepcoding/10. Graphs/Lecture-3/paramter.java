public class paramter {
    public static void main(String[] args) {
        
    }

    //let's sovle it
    //MAYANK SINGH SOLVED THIS PROBLEM WITH FUCKING BRIGHT COLORS BROSKI!!!
    //SUPERB BITCH!!!
    public static int islandPerimeter(int[][] grid) {
        int n = grid.length;
      int m = grid[0].length;
      boolean[][] vis = new boolean[n][m];

      int perimeter = 0;
      //after this move through all
      for(int i= 0; i < n; i++){
          for(int j= 0; j < m; j++){
              if(grid[i][j] == 1 && !vis[i][j]){
                  perimeter += dfsIslands(i,j, grid, vis, n, m);;
              }
          }
      }

      return perimeter;
  }
  
   public static int dfsIslands(int x, int y, int[][] grid, boolean[][] vis, int n, int m){
      //move in four direction
      int[] dx = {1,-1,0,0};
      int[] dy = {0,0, 1,-1};

      //after this 
      vis[x][y] = true;
      int perimeter = 0;
      int calls = 0;
      for(int i = 0; i < 4; i++){

          int cx = x + dx[i];
          int cy = y + dy[i];

          if(cx >= 0 && cx < n && cy >= 0 && cy < m){
              if(grid[cx][cy] == 1) calls++;
              if(!vis[cx][cy] && grid[cx][cy] == 1)
                perimeter += dfsIslands(cx, cy, grid, vis, n, m);                
          }
      }

      return perimeter + (4 - calls);
    }
    
}
