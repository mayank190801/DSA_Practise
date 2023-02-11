import java.util.*;

public class courseScheduleFour {
    public static void main(String[] args) {
        int numCourses = 3; 
        int[][] prerequisites = {{1,2},{1,0},{2,0}};
        int[][] queries = {{1,0},{1,2}};
        checkIfPrerequisite(numCourses, prerequisites, queries);
    }

    //DEFINITELY DOPE QUESTION FOR SURE!! - always respect the question - always try to find the brute forces solution
    //FIND THE BRUTE FORCE SOLUTION NO MATTER WHAT
    
    //COURSE SCHEDULE 4 - with taking help of khan's algo concept for sure 
    //only n = 100 edges for ease of the question
    //LOL THIS QUESTION WORKS FOR SURE
    //MY SOLVE BABY
    public static List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        //make a graph using these information
        int n = numCourses;
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i= 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[n];
        for(int i = 0; i < prerequisites.length; i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            indegree[v]++;
            graph[u].add(v);
        }

        //indegree works perfectly for sure!
        HashMap<Integer, Set<Integer>> prereq = new HashMap<>();
        int[] vis = new int[n];
        for(int i= 0; i < n; i++){
            if(!(indegree[i] == 0 && vis[i] == 0)) continue;
            Queue<Integer> que = new ArrayDeque<>(); 
            que.add(i);
            vis[i] = 1;
            prereq.put(i, new HashSet<>());  //simple
            while(!que.isEmpty()){
                int curr = que.poll();
                for(int child : graph[curr]){
                    indegree[child]--;
                    prereq.putIfAbsent(child, new HashSet<>());
                    for(int ele : prereq.get(curr)){
                        prereq.get(child).add(ele);
                    }
                    prereq.get(child).add(curr);

                    if(indegree[child] == 0){
                        que.add(child);
                        vis[child] = 1;
                    }
                }
            }
        }

        //now gotta answer all those queries
        List<Boolean> ans = new LinkedList<>();
        for(int i= 0; i < queries.length; i++){
            int u = queries[i][0];
            int v = queries[i][1];
            ans.add(prereq.get(v).contains(u));
        }

        return ans;
    }

    
}
