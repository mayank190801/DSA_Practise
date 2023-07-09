package Leetcode.Graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class i {
    public static void main(String[] args) {

    }

    public static int minCostConnectPoints(int[][] points) {
        int n = points.length;
        HashMap<Integer, Pair> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new Pair(points[i][0], points[i][1]));
        }

        PriorityQueue<Triplets> pque = new PriorityQueue<>((a, b) -> a.a - b.a);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Pair u = map.get(i);
                Pair v = map.get(j);

                int dist = Math.abs(u.a - v.a) + Math.abs(u.b - v.b);
                pque.add(new Triplets(dist, i, j));
            }
        }

        dsu dsuOne = new dsu(n);
        int ans = 0;
        while (!pque.isEmpty()) {
            Triplets curr = pque.poll();
            if (dsuOne.union(curr.b, curr.c) != -1) {
                ans += curr.a;
            }
        }

        return ans;
    }

    public static class Triplets {
        public int a;
        public int b;
        public int c;

        Triplets(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public String toString() {
            return a + " " + b + " " + c;
        }
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

    public static class dsu {

        private int[] rank;
        private int[] par;

        dsu(int size) {
            rank = new int[size];
            par = new int[size];
            Arrays.fill(rank, 1);
            for (int i = 0; i < size; i++) {
                par[i] = i;
            }
        }

        public int find(int u) {
            return par[u] == u ? u : (par[u] = find(par[u]));
        }

        public int union(int u, int v) {
            int par1 = find(u);
            int par2 = find(v);
            if (par1 == par2)
                return -1;
            int r1 = rank[par1];
            int r2 = rank[par2];
            if (r1 > r2) {
                rank[par1] += rank[par2];
                par[par2] = par1;
            } else {
                rank[par2] += rank[par1];
                par[par1] = par2;
            }
            return 1;
        }
    }

}
