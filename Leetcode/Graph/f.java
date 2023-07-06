package Leetcode.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class f {
    public static void main(String[] args) {

    }

    // concept of complete components shouldn't be too hard
    public static int countCompleteComponents(int n, int[][] edges) {
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

        int ans = 0;
        int[] vis = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (vis[i] != 1) {
                vis[i] = 1;

                boolean flag = true;
                ArrayDeque<Integer> que = new ArrayDeque<>();
                que.add(i);
                int len = graph[i].size();
                int cnt = 0;

                while (!que.isEmpty()) {
                    int curr = que.poll();
                    cnt++;
                    if (len != graph[curr].size())
                        flag = false;

                    for (int edge : graph[curr]) {
                        if (vis[edge] == 1)
                            continue;

                        vis[edge] = 1;
                        que.add(edge);
                    }
                }

                if (len != cnt - 1)
                    flag = false;
                if (flag)
                    ans++;
            }
        }

        return ans;
    }

}
