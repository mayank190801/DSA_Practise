package Leetcode.Graph;

import java.util.HashMap;
import java.util.PriorityQueue;

public class j {
    public static void main(String[] args) {

    }

    public static int minCostConnectPoints(int[][] points) {
        int n = points.length;
        HashMap<Integer, Pair> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new Pair(points[i][0], points[i][1]));
        }

        // now starting from point 0;
        int[] vis = new int[n];
        vis[0] = 1;
        int ans = 0;
        PriorityQueue<Triplet> pque = 






        return 0;
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
}
