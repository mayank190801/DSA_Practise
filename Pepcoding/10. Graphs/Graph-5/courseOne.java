import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class courseOne {
    public static void main(String[] args) {

    }

    //fuck all three of them fucking works, that means I am pretty decent at this shit for sure now! (not at all bad for real)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        return findCycleOne(numCourses, prerequisites);
//        return findCycleTwo(numCourses, prerequisites);
        return findCycleThree(numCourses, prerequisites);
    }


    ///ONE WAY OF FINDING CYCLE
    public boolean findCycleThree(int n, int[][] prerequisites){  //using khan algo for sure!!
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for(int i= 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[n];
        for(int[] currReq : prerequisites){
            int from = currReq[0];
            int to = currReq[1];
            indegree[to]++;
            graph[from].add(to);
        }

        Queue<Integer> que = new ArrayDeque<Integer>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0) que.add(i);
        }

        ArrayList<Integer> topological = new ArrayList<>();
        while(!que.isEmpty()){
            int curr = que.poll();
            topological.add(curr);
            for(int edge : graph[curr]){
                indegree[edge]--;
                if(indegree[edge] == 0){
                    que.add(edge);
                }
            }
        }

        return topological.size() == n;
    }

    ///ONE WAY OF FINDING CYCLE/////
    public boolean findCycleTwo(int n, int[][] prerequisites){
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for(int i= 0; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] currReq : prerequisites){
            int from = currReq[0];
            int to = currReq[1];
            graph[from].add(to);
        }

        int[] vis = new int[n];
        boolean res = false;
        for(int i = 0; i < n; i++){
            if(vis[i] == 1) continue;
            res = res || dfsCheckTwo(graph, vis, i);
        }

        return res;
    }

    public boolean dfsCheckTwo(ArrayList<Integer>[] graph, int[] vis, int curr){
        vis[curr] = 1;
        boolean res = true;
        for(int edge : graph[curr]){
            if(vis[edge] == 1) return false;
            if(vis[edge] == 0){
                res = res || dfsCheckTwo(graph, vis, edge);
            }
        }
        vis[curr] = 2;
        return res;
    }



    ///ONE WAY OF FINDING CYCLE/////
    public boolean findCycleOne(int numCourses, int[][] prerequisites){
        int n = numCourses;
        ArrayList<Integer>[] graph = new ArrayList[numCourses + 1];
        for(int i= 0; i <= numCourses; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] currReq : prerequisites){
            int from = currReq[0];
            int to = currReq[1];
            graph[from].add(to);
        }

        int[] vis = new int[n];
        int[] currPath = new int[n];

        boolean res = false;
        for(int i = 0; i < n; i++){
            if(vis[i] == 1) continue;
            res = res || dfsCheck(graph, vis, currPath, i);
        }

        return res;
    }

    public boolean dfsCheck(ArrayList<Integer>[] graph, int[] vis, int[] currPath, int curr){
        vis[curr] = 1;
        currPath[curr] = 1;
        boolean res = false;

        for(int edge : graph[curr]){
            if(vis[edge] == 0){
                res = res || dfsCheck(graph, vis, currPath, edge);
            }else if(currPath[edge] == 1) return true;
        }

        currPath[curr] = 0;
        return res;
    }
    ///ONE WAY OF FINDING CYCLE/////




}
