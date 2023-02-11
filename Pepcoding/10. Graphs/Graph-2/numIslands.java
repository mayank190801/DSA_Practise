public class numIslands {
    public static void main(String[] args) {




    }

    public static int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1'){
                    cnt++;
                    //apply dfs
                    dfs(grid, i, j, n, m);
                }
            }
        }

        return cnt;
    }

    public static void dfs(char[][] grid, int i, int j, int n, int m){
        int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        grid[i][j] = '0';

        for(int[] cdir : dir){
            int nx = cdir[0] + i;
            int ny = cdir[1] + j;

            if(nx >= n || ny >= m || nx < 0 || ny < 0 || grid[nx][ny] == '0') continue;
            dfs(grid, nx, ny, n, m);
        }
    };
}
