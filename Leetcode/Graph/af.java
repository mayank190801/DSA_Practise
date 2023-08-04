import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class af {
    public static void main(String[] args) {

    }

    // this should be doable now
    public static int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dis1 = getDistFromNode(edges, node1, n);
        int[] dis2 = getDistFromNode(edges, node2, n);

        // now I should find the min of max for both
        int dist = Integer.MAX_VALUE;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (dis1[i] == Integer.MAX_VALUE || dis2[i] == Integer.MAX_VALUE)
                continue;

            int newDist = Math.max(dis1[i], dis2[i]);
            if (newDist < dist) {
                ans = i;
            }
        }
        System.out.println(Arrays.toString(dis1));
        System.out.println(Arrays.toString(dis2));

        return ans;
    }

    public static int[] getDistFromNode(int[] egdes, int node, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[node] = 0;
        int[] vis = new int[n];
        vis[node] = 1;

        while (true) {
            int get = egdes[node];
            if (get == -1)
                break;
            if (vis[get] == 1)
                break;

            vis[get] = 1;
            // otherwise simple
            dist[get] = dist[node] + 1;
            node = get;
        }

        return dist;
    }

}
