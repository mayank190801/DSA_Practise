package Leetcode.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class v {
    public static void main(String[] args) {

    }

    public static int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph[u].add(v);
            graph[v].add(u);
        }

        // after this find the least amount of time
        int[] time = new int[n];
        int[] vis = new int[n];
        ArrayDeque<Integer> que = new ArrayDeque<>();
        que.add(0);
        vis[0] = 1;
        int timer = 0;

        while (!que.isEmpty()) {
            int curr = que.poll();
            timer++;
            for (int edge : graph[curr]) {
                if (vis[edge] != 1) {
                    time[edge] = timer;
                    vis[edge] = 1;
                    que.add(edge);
                }
            }
        }

        int max = 0;
        for (int i = 1; i < n; i++) {
            int repeat = patience[i];
            int oneway = time[i];

            // what should be the math? figure that stuff out now
            if (oneway * 2 <= repeat) {
                max = Math.max(max, oneway * 2);
            } else {
                int times = oneway * 2 / repeat;
                if ((oneway * 2) % repeat == 0)
                    times--;

                // now we have the times
                int ans = oneway * 2 + times * repeat;
                max = Math.max(ans, max);
            }

        }

        return max;
    }

}