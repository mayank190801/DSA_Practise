import java.util.ArrayList;

public class z {
    public static void main(String[] args) {

    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < dislikes.length; i++) {
            int u = dislikes[i][0];
            int v = dislikes[i][1];
            graph[u].add(v);
        }

        int[] curr = new int[n + 1];
        int[] vis = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (vis[i] == 0) {
                if (!dfs(curr, vis, graph, i, 1))
                    return false;
            }
        }

        return true;
    }

    public static boolean dfs(int[] curr, int[] vis, ArrayList<Integer>[] graph, int present, int parent) {
        vis[present] = 1;
        curr[present] = parent == 1 ? 2 : 1;
        for (int edge : graph[present]) {
            if (vis[edge] == 1 && curr[edge] != parent)
                return false;

            if (vis[edge] == 0) {
                if (!dfs(curr, vis, graph, edge, curr[present]))
                    return false;
            }
        }
        return true;
    }

}
