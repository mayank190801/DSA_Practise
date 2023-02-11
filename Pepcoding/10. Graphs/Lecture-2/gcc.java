import java.io.*;
import java.util.*;

public class gcc {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

   //connected components using DFS!!! - //pretty dope shit!!
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      
      // write your code here
      //we can count components in here too if you want!!
      //pretty logical for sure no doubt!!
      //could use boolean looks pretty cool for sure!
      int[] visited = new int[vtces];
      for(int i= 0; i < vtces; i++){
          if(visited[i] == 1) continue;
          ArrayList<Integer> curr = new ArrayList<>();
          dfs(i, visited, graph, curr);
          comps.add(curr);
      }

      System.out.println(comps);
   }

   public static void dfs(int vtx, int[] visited, ArrayList<Edge>[] graph, ArrayList<Integer> curr){
        //this is money talking in we here for sure
        visited[vtx] = 1;  //marking on the same point for this one!!
        curr.add(vtx);
        for(Edge e : graph[vtx]){
            if(visited[e.nbr] != 1){
                dfs(e.nbr, visited, graph, curr);
            }
        }
        return;
   }
}