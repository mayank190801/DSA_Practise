package Leetcode.Graph;

import java.util.ArrayDeque;
import java.util.List;

public class d {
    public static void main(String[] args) {

    }

    // I am monster
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        int[] vis = new int[n];
        vis[0] = 1;
        int viscount = 1;

        ArrayDeque<Integer> que = new ArrayDeque<>();
        que.add(0);
        while (!que.isEmpty()) {
            int curr = que.poll();
            for (int keys : rooms.get(curr)) {
                if (vis[keys] != 1) {
                    vis[keys] = 1;
                    viscount++;
                    que.add(keys);
                }
            }
        }

        return viscount == n;
    }
}
