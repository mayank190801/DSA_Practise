package Leetcode.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class a {
    public static void main(String[] args) {
        System.out
                .println("hello there, I brother");
        Scanner sc = new Scanner(System.in);
        int f = sc.nextInt();
        System.out.println(f);

    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination)
            return true;
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            graph[from].add(to);
            graph[to].add(from);
        }

        // bfs maane queue,
        int[] vis = new int[n + 1];
        ArrayDeque<Integer> que = new ArrayDeque<>();

        vis[source] = 1;
        que.add(source);
        while (!que.isEmpty()) {
            int curr = que.poll();
            for (int edge : graph[curr]) {
                if (edge == destination)
                    return true;
                if (vis[edge] != 1) {
                    que.add(edge);
                    vis[edge] = 1;
                }
            }
        }

        return false;
    }
}
