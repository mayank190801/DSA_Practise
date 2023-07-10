package Leetcode.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;

public class o {
    public static void main(String[] args) {

    }

    public static int reachableNodes(int n, int[][] edges, int[] restricted) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            graph[u].add(v);
            graph[v].add(u);
        }

        int[] vis = new int[n];
        vis[0] = 1;
        ArrayDeque<Integer> que = new ArrayDeque<>();
        que.add(0);
        int cnt = 1;

        HashSet<Integer> set = new HashSet<>();
        for (int i : restricted)
            set.add(i);

        while (!que.isEmpty()) {
            int curr = que.poll();
            for (int edge : graph[curr]) {
                if (set.contains(edge))
                    continue;
                if (restricted[edge] == 1)
                    if (vis[edge] != 1) {
                        vis[edge] = 1;
                        cnt++;
                        que.add(edge);
                    }
            }

        }

        return cnt;
    }

}
