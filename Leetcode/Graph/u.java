package Leetcode.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class u {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> getAncestors(int n, int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            ans.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph[v].add(u);
        }

        int[] vis = new int[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                dfsSolve(graph, i, vis, ans);
            }
        }

        return ans;
    }

    public static void dfsSolve(ArrayList<Integer>[] graph, int curr, int[] vis, List<List<Integer>> ans) {
        vis[curr] = 1;
        Set<Integer> set = new TreeSet<>();
        for (int edges : graph[curr]) {
            if (vis[edges] == 0)
                dfsSolve(graph, edges, vis, ans);

            for (int par : ans.get(edges))
                set.add(par);
            set.add(edges);
        }
        for (int par : set) {
            ans.get(curr).add(par);
        }
    }

}
