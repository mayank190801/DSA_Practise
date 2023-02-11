public class surrounded {
    
    public static void main(String[] args) {
        
    }

    //let's solve this solve for sure bitch!!
    //THIS CODE GOT ACCEPTED FOR SURE!!! (but what was the logic boi!! Think about it for sure)
    //THERE ARE FUCKING BETTER WAYS OF SOLVING THIS PROBLEM FOR SURE BITCH!!!
    //FOR FUCKING SURE!!!! (YOU IDIOT THERE ARE BETTER WAYS FOR SURE!!)

    public static void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];
  
        //after this move through all
        for(int i= 0; i < n; i++){
            for(int j= 0; j < m; j++){
                if(board[i][j] == 'O' && !vis[i][j]){
                    boolean res = dfsIslands(i,j, board, vis, n, m);
                    if(res) updateIslands(i,j, board, n, m);
                }
            }
        }
  
        return;
    } 

    public static void updateIslands(int x, int y, char[][] grid, int n, int m){
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0, 1,-1};
  
        grid[x][y] = 'X';
        for(int i = 0; i < 4; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];
            if(cx >= 0 && cx < n && cy >= 0 && cy < m && grid[cx][cy] == 'O'){
                updateIslands(cx, cy, grid, n, m);
            }
        }

        return;
    }

    public static boolean dfsIslands(int x, int y, char[][] grid, boolean[][] vis, int n, int m){
        //move in four direction
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0, 1,-1};
  
        boolean res = true;
        //after this 
        vis[x][y] = true;
        for(int i = 0; i < 4; i++){
  
            int cx = x + dx[i];
            int cy = y + dy[i];

            if(!(cx >= 0 && cx < n && cy >= 0 && cy < m)){ //iska mtlb out, then false is returned
                res = false;
            }

            if(cx >= 0 && cx < n && cy >= 0 && cy < m && !vis[cx][cy] && grid[cx][cy] == 'O'){
                boolean got = dfsIslands(cx, cy, grid, vis, n, m);
                res = res && got;
            }
        }
  
        return res;
    }
}
