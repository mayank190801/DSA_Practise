import java.util.*;

public class checkPreq4 {
    public static void main(String[] args) {
        System.out.println("Hey there you world");

    }

    public static List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        //make a graph first of all
        ArrayList<Integer>[] graph = new ArrayList[numCourses + 1];
        for(int i = 0; i < numCourses + 1; i++){
            graph[i] = new ArrayList<>();
        }

        //after this
        for(int i = 0; i < prerequisites.length; i++){
            int from = prerequisites[i][0];
            int to = prerequisites[i][1];

            graph[from].add(to); //one way pathing
        }

        Map<Integer, Set<Integer>> connect = new HashMap<>();
        for(int i = 0; i < numCourses; i++){
            connect.putIfAbsent(i, new HashSet<>());
        }

        int[] vis = new int[numCourses + 1];
        for(int i= 0; i < numCourses; i++){
            if(vis[i] != 1){
                vis[i] = 1;
                topoAdder(vis, i, connect, graph);
            }
        }

        ArrayList<Boolean> ans = new ArrayList<>();
        for(int i = 0; i < queries.length; i++){
            ans.add(connect.get(queries[i][0]).contains(queries[i][1]));
        }

        return ans;
    }

    public static void topoAdder(int[] vis, int curr, Map<Integer, Set<Integer>> connect, ArrayList<Integer>[] graph){
        for(int edge : graph[curr]){
            if(vis[edge] != 1){
                vis[edge] = 1;
                topoAdder(vis, edge, connect, graph);
            }
        }

        for(int edge : graph[curr]){
            connect.get(curr).add(edge);
            connect.get(curr).addAll(connect.get(edge));
        }
    }

}
