package Leetcode.Graph;

import java.util.Arrays;

public class r {
    public static void main(String[] args) {

    }

    // daily few dsa problems - no matter what - keep solving and keep getting
    // better at it - keep giving leetcode contest and boom, you are a happy go man!
    // - dsa on tips
    // system design to study - have to revise oops, os, dbms
    // start practising development - that's it
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // hmm edges are bidirectional for sure
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
            cost[i][i] = 0;
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            cost[u][v] = wt;
            cost[v][u] = wt;
        }

        // why not
        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    long dist = (long) cost[i][via] + (long) cost[via][j] >= Integer.MAX_VALUE ? Integer.MAX_VALUE
                            : (long) cost[i][via] + (long) cost[via][j];
                    cost[i][j] = Math.min(cost[i][j], (int) dist);
                }
            }
        }

        // think about this what could be done
        int curr = n;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (cost[i][j] <= distanceThreshold)
                    cnt++;
            }
            if (cnt <= curr) {
                curr = cnt;
                ans = i;
            }

        }

        return ans;
    }

}
