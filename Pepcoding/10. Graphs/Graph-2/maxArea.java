public class maxArea {
    public static void main(String[] args) {

    }

    public static int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int maxArea = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    int area = dfsArea(grid, i, j, n, m);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    public static int dfsArea(int[][] grid, int i, int j, int n, int m){
        int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        grid[i][j] = 0;
        int tarea = 0;

        for(int[] cdir : dir){
            int nx = cdir[0] + i;
            int ny = cdir[1] + j;

            if(nx >= n || ny >= m || nx < 0 || ny < 0 || grid[nx][ny] == 0) continue;
            tarea += dfsArea(grid, nx, ny, n, m);
        }

        return tarea + 1;
    }


}
