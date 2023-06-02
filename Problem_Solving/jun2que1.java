import java.util.ArrayDeque;
import java.util.ArrayList;

public class jun2que1 {
    public static void main(String[] args) {
        int[][] bombs = { { 1, 2, 3 }, { 2, 3, 1 }, { 3, 4, 2 }, { 4, 5, 3 }, { 5, 6, 4 } };
        System.out.println(maximumDetonation(bombs));
    }

    public static int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // so after this is done, make the graph simple as possible
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // so we have to points with us, are they connecting with each other or not?
                long x1 = bombs[i][0];
                long y1 = bombs[i][1];
                long r1 = bombs[i][2];

                long x2 = bombs[j][0];
                long y2 = bombs[j][1];
                long r2 = bombs[j][2];

                long cDist = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
                long rDist = (r1 + r2) * (r1 + r2);

                if (cDist >= rDist)
                    continue;

                graph[i].add(j);
                graph[j].add(i);
            }
        }

        int ans = 0;
        int[] vis = new int[n];
        ArrayDeque<Integer> que = new ArrayDeque<Integer>(); // figure this out brother
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                que.add(i);
                vis[i] = 1;
                ans = Math.max(bfs(vis, que, graph), ans);
            }
        }

        return ans;
    }

    public static int bfs(int[] vis, ArrayDeque<Integer> que, ArrayList<Integer>[] graph) {
        int count = 0;
        while (!que.isEmpty()) {
            int curr = que.pop();
            for (int ele : graph[curr]) {
                if (vis[ele] == 0) {
                    que.add(ele);
                    vis[ele] = 1;
                }
            }
            count++;
        }
        return count;
    }

}
