package Leetcode.Graph;

import java.util.Arrays;

public class e {
    public static void main(String[] args) {
        String[] grid = { "/\\", "\\/" };
        System.out.println(regionsBySlashes(grid));
    }

    public static int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int m = grid[0].length();
        int[][][] vis = new int[n][m][2];
        int count = 0;

        // that makes some sense for sure
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 2; k++) {
                    if (vis[i][j][k] != 1) {
                        count++;
                        // vis[i][j][k] = 1;
                        dfs(grid, i, j, k == 0 ? 'L' : 'R', vis);
                    }
                }
            }
        }

        return count;
    }

    // start getting deeper into ml as well - fix time and fix coding regiment
    // now questions is when to mark visited? what do you think logically makes the
    // most sense?
    public static void dfs(String[] grid, int i, int j, char dir, int[][][] vis) {
        // create return scenarios here for safety of code for sure - please
        int n = grid.length;
        int m = grid[0].length();
        if (i < 0 || i >= n || j < 0 || j >= m)
            return;

        char present = grid[i].charAt(j);

        if (present == '/') {
            if (dir == 'R' || dir == 'D') {
                if (vis[i][j][1] == 1)
                    return;
                vis[i][j][1] = 1;

                dfs(grid, i + 1, j, 'U', vis);
                dfs(grid, i, j + 1, 'L', vis);
            } else {
                if (vis[i][j][0] == 1)
                    return;
                vis[i][j][0] = 1;

                dfs(grid, i - 1, j, 'D', vis);
                dfs(grid, i, j - 1, 'R', vis);
            }
        } else if (present == ' ') {
            if (vis[i][j][0] == 1)
                return;

            vis[i][j][0] = 1;
            vis[i][j][1] = 1;

            dfs(grid, i + 1, j, 'U', vis);
            dfs(grid, i, j + 1, 'L', vis);
            dfs(grid, i - 1, j, 'D', vis);
            dfs(grid, i, j - 1, 'R', vis);
        } else {
            if (dir == 'L' || dir == 'D') {
                if (vis[i][j][0] == 1)
                    return;

                vis[i][j][0] = 1;

                dfs(grid, i + 1, j, 'U', vis);
                dfs(grid, i, j - 1, 'R', vis);
            } else {
                if (vis[i][j][1] == 1)
                    return;
                vis[i][j][1] = 1;

                dfs(grid, i - 1, j, 'D', vis);
                dfs(grid, i, j + 1, 'L', vis);
            }
        }
    }

}
