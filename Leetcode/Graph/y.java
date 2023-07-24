import java.util.ArrayDeque;
import java.util.ArrayList;

public class y {
    public static void main(String[] args) {

    }

    public static int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;

                long x1 = bombs[i][0];
                long y1 = bombs[i][1];
                long r1 = bombs[i][2];

                long x2 = bombs[j][0];
                long y2 = bombs[j][1];

                long cDist = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
                long rDist = (r1) * (r1);

                if (cDist > rDist)
                    continue;

                graph[i].add(j);

            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int[] vis = new int[n];
            ans = Math.max(dfs(vis, graph, i), ans);
        }

        return ans;
    }

    public static int dfs(int[] vis, ArrayList<Integer>[] graph, int curr) {
        int cnt = 0;
        vis[curr] = 1;
        for (int edge : graph[curr]) {
            if (vis[edge] != 1) {
                cnt += dfs(vis, graph, edge);
            }
        }
        return cnt + 1;
    }
}
