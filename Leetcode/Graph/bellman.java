package Leetcode.Graph;

import java.util.Arrays;

public class bellman {
    public static void main(String[] args) {

    }

    public static int isNegativeWeightCycle(int n, int[][] edges) {
        // int source could be anything for sure
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < edges.length; j++) {
                int u = edges[i][0];
                int v = edges[i][1];
                int wt = edges[i][2];

                if (dist[u] == Integer.MAX_VALUE)
                    continue;

                if (dist[u] + wt < dist[v]) {
                    if (i == n - 1) {
                        return 1;
                    }
                    dist[v] = dist[u] + wt;

                }

            }
        }

        return 0;
    }

}
