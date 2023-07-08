package Leetcode.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class h {
    public static void main(String[] args) {

    }

    // get into a better faang or startup for better learning! get good at interview
    // skills
    public static int minReorder(int n, int[][] connections) {
        ArrayList<Pair>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < connections.length; i++) {
            int u = connections[i][0];
            int v = connections[i][1];

            graph[u].add(new Pair(v, 1));
            graph[v].add(new Pair(u, -1));
        }

        ArrayDeque<Integer> que = new ArrayDeque<>();
        int[] vis = new int[n];
        vis[0] = 1;
        que.add(0);
        int ans = 0;

        while (!que.isEmpty()) {
            int curr = que.poll();
            for (Pair edge : graph[curr]) {
                if (vis[edge.a] != 1) {
                    vis[edge.a] = 1;
                    que.add(edge.a);
                    if (edge.b == 1)
                        ans++;
                }
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
    }

}
