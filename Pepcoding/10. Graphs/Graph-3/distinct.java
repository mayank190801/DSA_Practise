import java.util.HashSet;
import java.util.Set;

public class distinct {
    public static void main(String[] args) {

    }


    public int numberofDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();
        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, n, m, sb,1);
                    set.add(sb.toString());
                }
            }
        }

        return set.size();
    }

    public void dfs(int[][] grid, int i, int j, int n, int m, StringBuilder sb, int num){
        int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        char[] dirChar = {'L','R','U','D'};
        grid[i][j] = -1;
        sb.append(".");
        sb.append(num);

        for(int k = 0; k < 4; k++){
            int nx = dir[k][0] + i;
            int ny = dir[k][1] + j;

            if(nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 1){
                sb.append(dirChar[k]);
                dfs(grid, nx, ny, n, m, sb, num + 1);
            }
        }
    }

}
