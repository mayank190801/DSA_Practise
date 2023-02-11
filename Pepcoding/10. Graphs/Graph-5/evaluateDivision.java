import java.util.*;

public class evaluateDivision {
    public static void main(String[] args) {

    }

    //let's solve this bad boi now!!
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Integer> map = new HashMap<>();
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

        for(int i = 0; i < equations.size(); i++){
            String st1 = equations.get(i).get(0);
            String st2 = equations.get(i).get(1);
            if(!map.containsKey(st1)){
                map.put(st1, map.size());
                graph.add(new ArrayList<>());
            }

            if(!map.containsKey(st2)){
                map.put(st2, map.size());
                graph.add(new ArrayList<>());
            }

            int pos1 = map.get(st1);
            int pos2 = map.get(st2);

            graph.get(pos1).add(new Pair(pos2, values[i]));
            graph.get(pos2).add(new Pair(pos1, 1.0/values[i]));
        }

        double[] answer = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++){
           String from = queries.get(i).get(0);
           String to = queries.get(i).get(1);

           double ans = bfs(graph, map.get(from), map.get(to));
           answer[i] = ans;
        }

        return answer;
    }

    public double bfs(ArrayList<ArrayList<Pair>> graph, int from, int source){
        Queue<Pair> que = new ArrayDeque<>();
        int[] vis = new int[graph.size()];
        vis[from] = 1;
        que.add(new Pair(from, 1.0));

        while(!que.isEmpty()){
            int size = que.size();
            while(size--> 0){
                Pair curr = que.poll();
                if(curr.a == source) return curr.b;

                for(Pair p : graph.get(curr.a)){
                    if(vis[p.a] == 1) continue;
                    vis[p.a] = 1;
                    que.add(new Pair(p.a, p.b * curr.b));
                }
            }
        }

        return -1.0;
    }


    public class Pair{
        int a;
        double b;

        Pair(int a, double b){
            this.a = a;
            this.b = b;
        }
    }

}
