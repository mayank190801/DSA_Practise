import java.util.Arrays;

public class longIncPath {
    public static void main(String[] args) {

    }

    public static int[][] dir = {{1,0}, {-1,0}, {0,-1}, {0,1}};

    public static int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] vis = new int[n*m]; //so we have this
        int[] height = new int[n*m];
        Arrays.fill(height, 1);

        for(int i = 0; i < n * m; i++){
            if(vis[i] != 1){
                vis[i] = 1;
                solve(i, vis, height, matrix, n, m);
            }
        }

        int ans = 1;
        for(int i : height) ans = Math.max(ans, i);
        System.out.println(Arrays.toString(height));
        return ans;
    }

    public static void solve(int curr, int[] vis, int[] height, int[][] matrix, int n, int m){
        int r = curr/m;
        int c = curr%m;

        for(int[] d : dir){
            int nx = d[0] + r;
            int ny = d[1] + c;

            if(nx >= 0 && nx < n && ny < m && ny >= 0 && matrix[nx][ny] > matrix[r][c]){
                if(vis[nx * m + ny] != 1){
                    vis[nx * m + ny] = 1;
                    solve(nx * m + ny, vis, height, matrix, n, m);
                }
                height[curr] = Math.max(height[curr], height[nx * m + ny] + 1);
            }
        }
    }
}
