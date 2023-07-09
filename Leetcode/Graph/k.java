package Leetcode.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class k {
    public static void main(String[] args) {

    }

    // new question to be solved for sure
    public long maximumImportance(int n, int[][] roads) {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < roads.length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];

            graph[u].add(v);
            graph[v].add(u);
        }

        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Pair(i, graph[i].size()));
        }
        Collections.sort(list, (a, b) -> a.b - b.b);
        for (int i = 0; i < n; i++) {
            map.put(list.get(i).a, i + 1);
        }
        System.out.println(map);

        long ans = 0;
        int[] vis = new int[n];
        ArrayDeque<Integer> que = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (vis[i] == 1)
                continue;
            que.add(i);
            while (!que.isEmpty()) {
                int curr = que.poll();
                if (vis[curr] == 1)
                    continue;
                vis[curr] = 1;
                for (int edge : graph[curr]) {
                    if (vis[edge] != 1) {
                        ans += map.get(curr) + map.get(edge);
                        que.add(edge);
                    }
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

        @Override
        public String toString() {
            return a + " " + b;
        }
    }
}
