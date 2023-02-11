import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class network {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<Edge>[] graph = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph[u].add(new Edge(v, 0));  //simple stuff for sure
            graph[v].add(new Edge(u, 1));
        }

        int ans = networkDelayTime(graph, n, 1);
        System.out.println(ans);
    }

    public static class Edge{
        int to;
        int wt;

        Edge(int to, int wt){
            this.to = to;
            this.wt = wt;
        }
    }

    public static int networkDelayTime(ArrayList<Edge>[] graph, int n, int k) {
        //now applying dijkstra
        int[] dist = new int[n + 1];
        int[] vis =new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> a.wt - b.wt);
        pq.add(new Edge(k, 0));
        dist[k] = 0;

        while(!pq.isEmpty()){
            Edge curr = pq.poll();
            if(vis[curr.to] == 1) continue;
            vis[curr.to] = 1;

            for(Edge edge : graph[curr.to]){
                if(vis[edge.to] == 1) continue;
                //not visited
                if(dist[curr.to] + edge.wt < dist[edge.to]){
                    dist[edge.to] = dist[curr.to] + edge.wt;
                    pq.add(new Edge(edge.to, dist[edge.to]));
                }
            }
        }

        return dist[n] == Integer.MAX_VALUE ? -1 : dist[n];
    }


}

