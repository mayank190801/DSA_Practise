
import java.io.*;
import java.util.*;


public class goldMine{

	public static void main(String[] args){


	}

	public static int[] dir = {{0,1},{0,-1},{1,0},{-1,0}}; //simple moving up or down thingie
	public int max = 0;

    public static int getMaximumGold(int[][] grid) {
    	max = 0;
    	int m = grid.length;
    	int n = grid[0].length;

    	for(int i= 0; i < m; i++){
    		for(int j = 0; j < n; j++){
    			if(grid[i][j] == 0) continue;
    			grid[i][j] = -grid[i][j]
    			helper(grid, i, j, -grid[i][j]);
    			grid[i][j] = -grid[i][j];
  
    		}
    	}
    }

    public static int helper(int[][] grid, int i, int j, int cgold){
    	max = Math.max(cgold, max);

    	int m = grid.length;
    	int n = grid[0].length;

    	for(int[] d : dir){
    		int ci = i + d[0];
    		int cj = j + d[1];

    		if(ci >= 0 && ci < m && cj >= 0 && cj < n && grid[ci][cj] > 0){
    			grid[ci][cj] = -grid[ci][cj];
    			helper(grid, ci, cj, cgold - grid[ci][cj]);
    			grid[ci][cj] = -grid[ci][cj];
    		}
    	}
    }

}
		
