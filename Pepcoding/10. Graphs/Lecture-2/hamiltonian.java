import java.io.*;
import java.util.*;

public class hamiltonian {
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

      int src = Integer.parseInt(br.readLine());

      // write all your codes here
      //src is given , we gotta have all the paths in the stores baby!!
      StringBuilder sb = new StringBuilder();
      sb.append(src);

      ArrayList<String> allPathCycles = new ArrayList<>();

      boolean[] vis = new boolean[vtces];
      //now it is simple
      int left = vtces; 
      dfs(src,src, graph, vis, sb, allPathCycles, left - 1);  //src se aage bhej diya boss
    //   System.out.println(allPathCycles);
      for(String s : allPathCycles){
          System.out.println(s);
      }
    
   }

   //DEFINITELY MY CODE, I CAN SOLVE PROBLEMS, BUT IN A NASTY WAY FOR SURE
   public static void dfs(int src, int gsrc, ArrayList<Edge>[] graph, boolean[] vis, StringBuilder sb, ArrayList<String> allPathCycles, int left){

        if(left == 0){
            //all are for surely visited suppose!!
            //we will check if there is a edge between the last and src
            //then add * or . accordingly
            boolean flag = false;
            for(Edge e : graph[src]){
                if(e.nbr == gsrc){
                    flag = true;
                    break;
                }
            }

            sb.append(flag ? '*' : '.');
            String ans = sb.toString();
            allPathCycles.add(ans);
            sb.deleteCharAt(sb.length() - 1);
            return;
        }

        vis[src] = true;
        for(Edge e : graph[src]){
            if(!vis[e.nbr]){
                sb.append(e.nbr);
                dfs(e.nbr, gsrc, graph, vis, sb, allPathCycles, left - 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        vis[src] = false;

   }


}