package Leetcode.Graph;

import java.util.ArrayList;

public class m {
    public static void main(String[] args) {

    }

    public static int maximalNetworkRank(int n, int[][] roads) {
        // rather than arraylist why not use set?
        // definitely more space for sure - but faster results
        // or int[][] 2d array to know who all are connected?
        int[][] connected = new int[n][n];
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < roads.length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];

            graph[u].add(v);
            graph[v].add(u);

            connected[u][v] = 1;
            connected[v][u] = 1;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = graph[i].size() + graph[j].size();
                if (connected[i][j] == 1)
                    sum--;
                ans = Math.max(ans, sum);
            }
        }

        return ans;
    }

}
