import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class kstops {
    public static void main(String[] args) {

    }

    public class Edge{
        int to;
        int wt;

        Edge(int to, int wt){
            this.to = to;
            this.wt = wt;
        }
    }

    //now for this flights
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int i= 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < flights.length; i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int wt = flights[i][2];

            graph[u].add(new Edge(v, wt));
        }

        int[] dist = new int[n];
        dist[src] = 0;
        Arrays.fill(dist, Integer.MAX_VALUE);
        int[] vis = new int[n];


        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.add(new int[]{src, 0, 0});

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int vertex = curr[0];
            int cost = curr[1];
            int stops = curr[2];

            if(stops > k) continue;
            if(vis[vertex] == 1) continue;

            for(Edge edge : graph[vertex]){
                if(vis[edge.to] == 1) continue;

                if(edge.wt + dist[vertex] < dist[edge.to]){
                    dist[edge.to] = edge.wt + dist[vertex];
                    pq.add(new int[]{edge.to, dist[edge.to], stops + 1});
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }


}
