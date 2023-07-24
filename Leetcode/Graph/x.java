import java.util.ArrayDeque;
import java.util.ArrayList;

public class x {
    public static void main(String[] args) {

    }

    // let's solve this question for real life now
    public long countPairs(int n, int[][] edges) {
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

        ArrayList<Integer> groups = new ArrayList<>();
        int[] vis = new int[n];
        long total = 0;
        ArrayDeque<Integer> que = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (vis[i] != 1) {
                vis[i] = 1;
                que.add(i);

                int cnt = 0;
                while (!que.isEmpty()) {
                    int curr = que.poll();
                    cnt++;
                    for (int edge : graph[curr]) {
                        if (vis[edge] == 0) {
                            vis[edge] = 1;
                            que.add(edge);
                        }
                    }
                }

                groups.add(cnt);
                total += cnt;
            }
        }

        // since we know the answer will be in long
        // so the important thing is you could basically used this piece in ther only
        // this part should not be done alag se tbh, simple as that
        // but the count would be typical no??
        long ans = 0;
        long currSize = total;
        for (int i = 0; i < groups.size() - 1; i++) {
            long curr = groups.get(i);

            long rem = currSize - curr;
            long curTotal = rem * curr;

            ans += curTotal;
            currSize = rem;
        }
        return ans;
    }

}
