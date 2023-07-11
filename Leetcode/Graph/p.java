package Leetcode.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class p {
    public static void main(String[] args) {

    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        ArrayList<Integer>[] cgraph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            cgraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                cgraph[i].add(graph[i][j]);
            }
        }

        // our graph is ready for sure
        int[] vis = new int[n];
        int[] safe = new int[n];
        int[] set = new int[n];

        for (int i = 0; i < n; i++) {
            if (vis[i] != 1) {
                dfs(cgraph, vis, i, set, safe);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe[i] == 0)
                ans.add(i);
        }

        return ans;
    }

    public static void dfs(ArrayList<Integer>[] graph, int[] vis, int curr, int[] set, int[] safe) {
        if (vis[curr] == 1)
            return;

        vis[curr] = 1;
        set[curr] = 1;
        for (int edge : graph[curr]) {
            if (vis[edge] == 1 && set[edge] == 1) {
                safe[curr] = -1;
            }
            if (vis[edge] != 1) {
                dfs(graph, vis, edge, set, safe);
            }
            if (safe[edge] == -1) {
                safe[curr] = -1;
            }
        }
        set[curr] = 0;
        return;
    }

}
