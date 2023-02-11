public class enclaves {
    public static void main(String[] args) {

    }

    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 || j == 0 || i == n-1 || j == m-1){
                    if(grid[i][j] == 1){
                        updateGrid(grid, i, j, n, m);
                    }
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1) ans++;
                if(grid[i][j] == -1) grid[i][j] = 1;
            }
        }

        return ans;
    }

    public int updateGrid(int[][] grid, int i, int j, int n, int m){
        int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        int ans = 0;
        grid[i][j] = -1;

        for(int[] cdir : dir){
            int nx = cdir[0] + i;
            int ny = cdir[1] + j;

            if(nx < 0 || nx >= n || ny < 0 || ny >= m || grid[nx][ny] == 0) ans++;


            if(nx < 0 || nx >= n || ny < 0 || ny >= m || grid[nx][ny] != 1) continue;
            ans += updateGrid(grid, nx, ny, n, m);
        }

        return ans;
    }
}
