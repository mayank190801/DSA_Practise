package Leetcode.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;

public class w {
    public static void main(String[] args) {

    }

    public int[] gardenNoAdj(int n, int[][] paths) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < paths.length; i++) {
            int u = paths[i][0] - 1;
            int v = paths[i][1] - 1;

            graph[u].add(v);
            graph[v].add(u);
        }

        int[] ans = new int[n];
        int[] vis = new int[n];

        for (int i = 0; i < n; i++) {
            if (vis[i] == 1)
                continue;
            ArrayDeque<Integer> que = new ArrayDeque<>();
            que.add(i);
            vis[i] = 1;
            while (!que.isEmpty()) {
                int curr = que.poll();

                int[] fpresent = new int[5];
                for (int edges : graph[curr]) {
                    if (vis[edges] == 1) {
                        fpresent[ans[edges]] = 1;
                    } else {
                        vis[edges] = 1;
                        que.add(edges);
                    }
                }
                for (int i = 1; i <= 4; i++) {
                    if (fpresent[i] == 0)
                        ans[i] = i;
                }
            }

        }

        return ans;
    }

}
