package Leetcode.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class g {
    public static void main(String[] args) {

    }

    // simple coding life brother
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // after that connect them
        for (int i = 0; i < roads.length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];

            graph[u].add(v);
            graph[v].add(u);
        }

        // graph is ready now get the database for all of this brother
        int[] vis = new int[n];
        long[] height = new long[n];
        long[] ans = new long[1];
        vis[0] = 1;

        for (int edge : graph[0]) {
            vis[edge] = 1;
            updateHeight(graph, vis, height, edge, ans, seats);
        }

        System.out.println(Arrays.toString(height));
        return ans[0];
    }

    // this seems logically correct
    // will get pretty fast with time for sure! because I am pro coder
    public static void updateHeight(ArrayList<Integer>[] graph, int[] vis, long[] height, int curr, long[] ans,
            int seats) {
        long cheight = 0;
        for (int edge : graph[curr]) {
            if (vis[edge] != 1) {
                vis[edge] = 1;
                updateHeight(graph, vis, height, edge, ans, seats);
                cheight += height[edge];
            }
        }
        height[curr] = cheight + 1L;
        ans[0] += height[curr] / seats + (height[curr] % seats == 0L ? 0L : 1L);
    }

}
