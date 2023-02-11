import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

public class kosaRajuAlgo {

    public static void main(String[] args) {
        
    }

    //remember the steps bois!!! for this algorithm!! 
    //STRONGLY CONNECTED COMPONENTS!!! 
    //undirected graph - connected components 
    //but the above is not true for directed graph!!!! 
    //hence to find this we will use this!!

    //steps - 
    //ALGO 
    // Topo Sort
    // Reverse Graph Edges
    // DFS on order given above - simply count while doing this!!!

    //KOSA RAJU ALGO
    public static int getSCC(){

        //Step 1
        boolean[] vis = new boolean[n];
        Stack<Integer> order = new Stack<>();
        for(int i= 0; i < n; i++){
            if(!vis[i]){
                dfsSCC(order, vis, order, i);
            }
        }

        //Step 2
        ArrayList<Edge>[] revgraph = new ArrayList[n+ 1];
        for(int i = 0; i < n; i++){
            revgraph[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++){
            for(Edge e : graph[i]){
                revgraph[e.v].add(new Edge(i, e.w));
            }
        }

        //step 3
        vis = new boolean[n];
        int scc = 0;
        while(order.size() > 0){
            int i = order.pop();
            if(!vis[i]){
                dfsSCC(revgraph, vis, new Stack<>(), i);
                scc++;
            }
        }

        return scc;
    }

    public static void dfsSCC( ArrayList<Edge>[] graph, boolean[] vis, Stack<Integer> order , int src){
        vis[src] = true;
        for(Edge e : graph[src]){
            if(!vis[e.v]){
                dfsSCC(graph, src, order);
            }
        }

        order.push(src);
    }

    
     




    
}
