package Leetcode.Graph;

import java.util.Arrays;

public class l {
    public static void main(String[] args) {

    }

    public static int removeStones(int[][] stones) {
        int n = stones.length;
        dsu mdsu = new dsu(n);

        for (int i = 0; i < n; i++) {
            int x1 = stones[i][0];
            int y1 = stones[i][1];
            for (int j = i + 1; j < n; j++) {
                int x2 = stones[j][0];
                int y2 = stones[j][1];

                if (x1 == x2 || y1 == y2) {
                    mdsu.union(i, j);
                }
            }
        }

        // after this all dones and settled, simple stuff to do
        return mdsu.solve(n);
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
            System.out.println();
            return 1;
        }

        public int solve(int n) {
            for (int i = 0; i < n; i++) {
                find(i);
            }
            int[] vis = new int[n];
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (vis[par[i]] != 1) {
                    vis[par[i]] = 1;
                    ans += rank[par[i]] - 1;
                }
            }
            return ans;
        }
    }

}
