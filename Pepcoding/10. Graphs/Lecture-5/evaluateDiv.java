import java.util.ArrayList;
import java.util.HashMap;

public class evaluateDiv {
    public static void main(String[] args) {
        
    }

    //I SOLVED THIS HUMONGOUS PROBLEM ON MY OWN!! WHAT A STUD NO??
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
          //heavy question to code bois
        HashMap<String, Integer> indexing = new HashMap<>();  
        // ArrayList<Integer>[] graph = new ArrayList[];  //do i need arraylist graph?? or array arraylist graph
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        int idx = 0;
        for(int i = 0; i < equations.size(); i++){
            //both string
            String one = equations.get(i).get(0);  //simple zero
            String two = equations.get(i).get(1);  //simple one!

            if(!indexing.containsKey(one)){
                indexing.put(one, idx);
                graph.add(new ArrayList<>());
                idx++;
            }

            if(!indexing.containsKey(two)){
                indexing.put(two, idx);
                graph.add(new ArrayList<>());  //new storage area
                idx++;
            }

            //after that 
            int u = indexing.get(one);  
            int v = indexing.get(two);

            double val = values[i];
            double ival = ((double)1)/(double)(val);  //simple shit for sure!!

            graph.get(u).add(new Pair(v, val));
            graph.get(v).add(new Pair(u, ival));
        }

        //after this hopefully my graph should be ready
        // System.out.println(graph);
        // System.out.println(indexing);
        //this above system is working flawlessy guys - now bas answer de deta hu bois
        double[] ans = new double[queries.size()];
        int aidx = 0;

        for(int i = 0; i < queries.size(); i++){
            //now find the path for the answer 
            String one = queries.get(i).get(0);  //simple zero
            String two = queries.get(i).get(1);  //simple one!

            if(!indexing.containsKey(one) || !indexing.containsKey(two)){
                ans[aidx] = -1;
                aidx++;
               continue;
            }

            //otherwise
            int u = indexing.get(one);
            int v = indexing.get(two);

            if(u == v){
                ans[aidx] = 1;
                aidx++;
                continue;
            }

            //otherwise actually find the path bois!! -- think and solve this annoying problem for once and all
            //i can not take this anymore, this is torture
            //applying dfs bois! -- if found return double, otherwise not!!
            double[] answer = new double[2];
            boolean[] vis = new boolean[idx + 1];
            answer[0] = 1;
            solveDfsPath(u, v, graph, indexing, answer, 1, vis);  

            if(answer[1] == 1){
                ans[aidx] = answer[0];
            }else{
                ans[aidx] = -1;
            }
            aidx++;
    
        }
        
        return ans;
    }
    
     public static void solveDfsPath(int src, int dest, ArrayList<ArrayList<Pair>> graph,  HashMap<String, Integer> indexing, double[] ans, double curr, boolean[] vis){
        vis[src] = true;        
        if(src == dest){
            ans[0] = curr;
            ans[1] = 1;
            return;
        }

        for(Pair e : graph.get(src)){
            if(!vis[e.a]){
                solveDfsPath(e.a, dest, graph, indexing, ans, curr * e.wt, vis);
            }
        }
    }

    //after this pair class is ready, we will plan something out
    public static class Pair{
        public int a;
        public double wt;

        public Pair(int a, double wt){
            this.a = a;
            this.wt = wt;
        }

        @Override
        public String toString(){
            return a + " -> " + wt;  //pretty simple for sure
        }
    }

    
}
