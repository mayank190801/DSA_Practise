import java.util.ArrayList;
import java.util.Scanner;

public class questionTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] cats = new int[n];
        for(int i= 0; i < n; i++){
            cats[i] = sc.nextInt();
        }

        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < n -1; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph[u].add(v);
            graph[v].add(u);
        }

        int[] visited = new int[n + 1];
        visited[1] = 1;
        int answer = dfs(graph, 1, visited, cats, 0, m);
        System.out.println(answer);
    }



    //O(V+E)
    public static int dfs( ArrayList<Integer>[] graph, int node, int[] visited, int[] cats, int consec, int m){

        //base case
        if(cats[node-1] == 1){
            consec++;
        }else{
            consec = 0;
        }

        if(consec > m) return 0;

        //leaf node se return
        if(graph[node].size() == 1 && node != 1){
            return 1;
        }

        int ans = 0;
        for(int edges : graph[node]){
            if(visited[edges] == 1){
                continue;
            }
            visited[edges] = 1;
            ans += dfs(graph, edges, visited, cats, consec, m);
        }

        return ans;
    }

}
