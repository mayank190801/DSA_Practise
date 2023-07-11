package Leetcode.Graph;

public class floydwarshall {
    public static void main(String[] args) {

    }

    // floyd warshall algorithm should be implemented in this question for sure
    public void shortest_distance(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // cost finding algorithm here will be used, and implement
                    long cost = (long) matrix[i][via] + (long) matrix[via][j] >= Integer.MAX_VALUE ? Integer.MAX_VALUE
                            : matrix[i][via] + matrix[via][j];
                    matrix[i][j] = Math.min(matrix[i][j], (int) cost);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == Integer.MAX_VALUE) {
                    matrix[i][j] = -1;
                }
            }
        }
    }

}
