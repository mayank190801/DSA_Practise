public class moon{
    public static void main(String[] args) {

    }

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int n = grid.length;
        int m = grid[0].length;

        if(grid[row][col] == color) return grid;
        int init = grid[row][col];

        updatedGrid(grid, row, col, n, m, color, grid[row][col]);

        for(int i= 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0){
                    grid[i][j] = color;
                }else if(grid[i][j] == -1){
                    grid[i][j] = init;
                }
            }
        }

        return grid;
    }

    public void updatedGrid(int[][] grid, int row, int col,int n, int m, int color, int init){

        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};

        //first check on all four points for the answer
        boolean centre = true;

        for(int[] cdir : dir){
            int nx = cdir[0] + row;
            int ny = cdir[1] + col;
            if(nx < 0 || nx >= n || ny < 0 || ny >= m){
                centre = false;
                break;
            }
            if(!(grid[nx][ny] == -1 || grid[nx][ny] == 0 || grid[nx][ny] == init)) centre = false;

        }

        grid[row][col] = centre ? -1 : 0;

        for(int[] cdir : dir){
            int nx = cdir[0] + row;
            int ny = cdir[1] + col;
            if(nx < 0 || nx >= n || ny < 0 || ny >= m || grid[nx][ny] != init ) continue;
            updatedGrid(grid, nx, ny, n, m, color, init);
        }

    }
}