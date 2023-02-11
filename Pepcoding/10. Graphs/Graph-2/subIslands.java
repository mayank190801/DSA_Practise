public class subIslands {
    public static void main(String[] args) {

    }

    public static int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length;
        int m = grid1[0].length;

        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid2[i][j] == 1) {
                    if(island(grid1, grid2, i, j, n, m)) cnt++;
                }
            }
        }

        return cnt;
    }

    public static boolean island(int[][] grid1, int[][] grid2, int i, int j, int n, int m){
        if(grid1[i][j] == 0) return false;

        int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        grid2[i][j] = 0;
        boolean ans = true;

        for(int[] cdir : dir){
            int nx = cdir[0] + i;
            int ny = cdir[1] + j;

            if(nx >= n || ny >= m || nx < 0 || ny < 0 || grid2[nx][ny] == 0) continue;
            if(!island(grid1, grid2, nx, ny, n, m)) ans = false;
        }

        return ans;
    }


}
