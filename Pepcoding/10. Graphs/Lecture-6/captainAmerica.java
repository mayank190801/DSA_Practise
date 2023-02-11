import java.util.ArrayList;
import java.util.Stack;

public class captainAmerica {

    //DAMN PERFECTLY SOLVED ON THE FIRST ATTEMPT!!!
    //JUST USAGE OF TWO CONCEPTS - mother vertex and kosa raju algo - beautiful question
    public static void main(String[] args) {
        int N = 5; 
        int M =5;
        int[][] V = {{1, 2}, {2, 3}, {3, 4}, {4, 3}, {5, 4}};
        int ans = captainAmerica(N, M, V);
        System.out.println(ans);
    }

    //above code for this problem for sure
    public static void dfsMV(int src, int n, ArrayList<Integer>[] graph, boolean[] vis){
        //simple shit for sure bois
        vis[src] = true;
        for(int i : graph[src]){
            if(!vis[i]){
                dfsMV(i, n, graph, vis);
            }
        }
    }

    //code for MVP
    public static int motherVertex(int n, ArrayList<Integer>[] graph){
        boolean[] vis = new boolean[n + 1];
        int mv = -1;

        for(int i= 1; i <= n; i++){
            if(!vis[i]){
                dfsMV(i, n, graph, vis);
                mv = i;
            }
        }

        vis = new boolean[n + 1];
        dfsMV(mv, n, graph, vis);

        for(int i = 1; i <= n; i++){
            if(!vis[i]) return -1;
        }

        return mv;
    }


    //Let's first try solving this absurd problem no? - let's give our best try
    //Do all the codes in here for better accuracy bois!
    public static int captainAmerica(int N, int M, int V[][]){
        ArrayList<Integer>[] graph = new ArrayList[N + 1];
        ArrayList<Integer>[] revgraph = new ArrayList[N + 1];

        for(int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
            revgraph[i] = new ArrayList<>();
        }

        //next is making edges and stuff
        for(int i = 0; i < M; i++){
            int u = V[i][0];
            int v = V[i][1];

            graph[u].add(v);   
            revgraph[v].add(u);
        }

        //now what next - let's think about it first find the mother vertex in revgraph
        //then find all the SCC for that boi!! using Kosa raju algo - top
        int mv = motherVertex(N, revgraph);
        if(mv == -1){  //not possible for this case
            return 0;
        }
        
        //now applying kosa raju on this question for ease of the answer
        //topo sort laake do boss
        boolean[] vis = new boolean[N + 1];
        Stack<Integer> order = new Stack<>();

        for(int i = 1; i <= N; i++){
            if(!vis[i]){
                topoSort(i, N, vis, graph, order);
            }
        }

        //now simple shit is left to, how many SCC for that bad boi! which contains mv!!
        vis = new boolean[N + 1];
        int count = 0;
        while(!order.isEmpty()){
            int curr = order.pop();
            int ans = 0;
            if(!vis[curr]){
                ans = topoSort(curr, N, vis, revgraph, new Stack<Integer>());
                if(vis[mv] && count == 0){
                    count = ans;
                }
            }
          
        }
        
        return count;
    }

    public static int topoSort(int src, int n, boolean[] vis, ArrayList<Integer>[] graph, Stack<Integer> order){
        vis[src] = true;
        int count = 0;
        for(int i : graph[src]){
            if(!vis[i]){
                count += topoSort(i, n, vis, graph, order);
            }
        }
        order.add(src);
        return count + 1;
    }
    
    
}
