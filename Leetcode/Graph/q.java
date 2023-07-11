package Leetcode.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class q {
    public static void main(String[] args) {

    }

    // solve
    public static int minScore(int n, int[][] roads) {
        ArrayList<Pair>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < roads.length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            int wt = roads[i][2];

            graph[u].add(new Pair(v, wt));
            graph[v].add(new Pair(u, wt));
        }

        // now
        ArrayDeque<Integer> que = new ArrayDeque<>();
        int[] vis = new int[n + 1];
        vis[1] = 1;
        que.add(1);
        int ans = Integer.MAX_VALUE;

        while (!que.isEmpty()) {
            int curr = que.poll();
            for (Pair edge : graph[curr]) {
                if (vis[edge.a] != 1) {
                    vis[edge.a] = 1;
                    que.add(edge.a);
                }

                ans = Math.min(ans, edge.b);
            }
        }

        return ans;
    }

    public static class Pair {
        public int a;
        public int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return a + " " + b;
        }
    }

}
