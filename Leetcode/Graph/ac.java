import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

import Leetcode.Graph.i;

public class ac {
    public static void main(String[] args) {

    }

    // figure this out
    public static int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        ArrayList<Pair>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < redEdges.length; i++) {
            int u = redEdges[i][0];
            int v = redEdges[i][1];

            graph[u].add(new Pair(v, 1));
        }
        for (int i = 0; i < blueEdges.length; i++) {
            int u = blueEdges[i][0];
            int v = blueEdges[i][1];

            graph[u].add(new Pair(v, 2));
        }

        // now we have created the graph, pretty cool for sure
        int[][] dist = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 0;
        dist[0][1] = 0;

        int[][] vis = new int[n][2];
        ArrayDeque<Pair> que = new ArrayDeque<>();
        que.add(new Pair(0, 1));
        que.add(new Pair(0, 2));
        vis[0][0] = 1;
        vis[0][1] = 1;

        while (!que.isEmpty()) {
            Pair curr = que.poll();

            for (Pair edge : graph[curr.a]) {

                if (curr.b != edge.b) {
                    if (curr.b == 1 && vis[edge.a][0] != 1) {
                        vis[edge.a][0] = 1;
                        dist[edge.a][0] = dist[curr.a][1] + 1;
                        que.add(new Pair(edge.a, edge.b));
                    }

                    if (curr.b == 2 && vis[edge.a][1] != 1) {
                        vis[edge.a][1] = 1;
                        dist[edge.a][1] = dist[curr.a][0] + 1;
                        que.add(new Pair(edge.a, edge.b));
                    }

                }

            }

        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = Math.min(dist[i][0], dist[i][1]);
            ans[i] = ans[i] == Integer.MAX_VALUE ? -1 : ans[i];
        }
        return ans;
    }

    public static class Pair {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

}
