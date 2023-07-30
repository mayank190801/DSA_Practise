import java.util.ArrayList;
import java.util.Arrays;

public class ab {
    public static void main(String[] args) {

    }

    // this should make some sense
    public static int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
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

        int[] vis = new int[n];
        int[] found = new int[1];
        vis[bob] = 1;
        found[0] = -1;

        dfsUpdation(graph, bob, amount, found, vis, 1);
        Arrays.fill(vis, 0);
        vis[0] = 1;

        return dfsAnswer(graph, 0, amount, vis, 0);
    }

    private static int dfsAnswer(ArrayList<Integer>[] graph, int curr, int[] amount, int[] vis, int currSum) {
        int sum = currSum + amount[curr];
        if (graph[curr].size() == 1 && vis[graph[curr].get(0)] == 1)
            return sum;

        int max = Integer.MIN_VALUE;
        for (int nbr : graph[curr]) {
            if (vis[nbr] != 1) {
                vis[nbr] = 1;
                max = Math.max(dfsAnswer(graph, nbr, amount, vis, sum), max);
            }
        }

        return max;
    }

    private static void dfsUpdation(ArrayList<Integer>[] graph, int curr, int[] amount, int[] found, int[] vis,
            int counter) {
        if (curr == 0) {
            found[0] = counter;
            return;
        }

        for (int nbr : graph[curr]) {
            if (found[0] != -1)
                break;
            if (vis[nbr] == 0) {
                vis[nbr] = 1;
                dfsUpdation(graph, nbr, amount, found, vis, counter + 1);
            }
        }

        System.out.println(Arrays.toString(found));
        // now we are at this bad boi -- right
        // now write our logic to update amont
        if (found[0] != -1) {
            int pos = found[0];
            amount[curr] = (counter <= pos / 2) ? 0
                    : (pos % 2 == 1 && counter == pos / 2 + 1) ? amount[curr] / 2 : amount[curr];
        }
    }
}

// could be done with one dfs - if you think about it, extremely creative
// solution
// think of how you can do it with one DFS only