import java.util.ArrayList;
import java.util.Stack;

public class kosaraju {
    public static void main(String[] args) {

    }

    //Function to find number of strongly connected components in the graph. -
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //first make a stack
        //then reverse
        //then apply dfs while emptying stack
        Stack<Integer> st = new Stack<>();
        int[] vis = new int[V];
        for(int i = 0; i < V; i++){
            if(vis[i] != 1){
                vis[i] = 1;
                traverse(i, vis, adj, st);
            }
        }

        //we have the stack now reverse the graph simple as that
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
        for(int i= 0; i < V; i++){
            revAdj.add(new ArrayList<>());
        }

        for(int i = 0; i < V; i++){
            for(int edge : adj.get(i)){
                revAdj.get(edge).add(i);
            }
        }

        int cnt = 0;
        int[] nvis = new int[V];
        while(!st.isEmpty()){
            int top = st.pop();
            if(nvis[top] != 1){
                nvis[top] = 1;
                traverse2(top, nvis, revAdj);
                cnt++;
            }
        }
        return cnt;
    }

    public static void traverse(int curr, int[] vis, ArrayList<ArrayList<Integer>> graph, Stack<Integer> st){
        for(int edge : graph.get(curr)){
            if(vis[edge] != 1){
                vis[edge] = 1;
                traverse(edge, vis, graph,st);
            }
        }
        st.add(curr);
    }

    public static void traverse2(int curr, int[] vis, ArrayList<ArrayList<Integer>> graph){
        for(int edge : graph.get(curr)){
            if(vis[edge] != 1){
                vis[edge] = 1;
                traverse2(curr, vis, graph);
            }
        }
    }
}
