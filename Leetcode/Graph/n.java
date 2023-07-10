package Leetcode.Graph;

import java.util.ArrayList;

public class n {
    public static void main(String[] args) {

    }

    public static int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < richer.length; i++) {
            int u = richer[i][0];
            int v = richer[i][1];

            graph[v].add(u);
        }

        int[] vis = new int[n];
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            if (vis[i] != 1) {
                vis[i] = 1;
                dfs(graph, i, ans, quiet, vis);
            }
        }

        return ans;
    }

    public static void dfs(ArrayList<Integer>[] graph, int curr, int[] ans, int[] quiet, int[] vis) {
        ans[curr] = curr;
        for (int edge : graph[curr]) {
            if (vis[edge] != 1) {
                vis[edge] = 1;
                dfs(graph, edge, ans, quiet, vis);
            }
            if (quiet[ans[edge]] < quiet[ans[curr]]) {
                ans[curr] = ans[edge];
            }
        }
        return;
    }

}
