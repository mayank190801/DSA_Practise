package Leetcode.Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class s {
    public static void main(String[] args) {

    }

    // think how you can solve it
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<Pair>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double wt = succProb[i];

            graph[u].add(new Pair(v, wt));
            graph[v].add(new Pair(u, wt));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.b - a.b >= 0 ? 1 : 0);
        int[] vis = new int[n];
        pq.add(new Pair(start_node, 1.0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            if (curr.a == end_node)
                return curr.b;
            if (vis[curr.a] == 1)
                continue;

            vis[curr.a] = 1;
            for (Pair edge : graph[curr.a]) {
                if (vis[edge.a] != 1) {
                    pq.add(new Pair(edge.a, edge.b * curr.b));
                }
            }
        }

        return 0;
    }

    public static class Pair {
        public int a;
        public double b;

        Pair(int a, double b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return a + " " + b;
        }
    }

}
