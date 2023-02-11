import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class dijkstra {

    public static void main(String[] args) {

    }


    public static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {

        //so basically
        // {0,1} {2,9} for 1 connected to 0 and 2 with wieghts as 1 and 9
        int[] dist = new int[V];
        int[] visited = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;

        //damn my implementation of dijkstra works
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.wt - b.wt);
        pq.add(new Pair(S, 0));

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int node = curr.nd;
            int weight = curr.wt;

            if(visited[node] == 1) continue;
            visited[node] = 1;

            for(ArrayList<Integer> edges : adj.get(node)){
                int edge = edges.get(0);
                int edgeWt = edges.get(1);

                if(visited[edge] == 1) continue;
                if(dist[node] + edgeWt < dist[edge]){
                    dist[edge] = dist[node] + edgeWt;
                    pq.add(new Pair(edge, dist[edge]));
                }
            }
        }

        //that's how you make int[] instant arrays for life
        return dist;
    }

    public static class Pair{

        int nd;
        int wt;

        Pair(int nd, int wt){
            this.nd = nd;
            this.wt = wt;
        }
    }
}
