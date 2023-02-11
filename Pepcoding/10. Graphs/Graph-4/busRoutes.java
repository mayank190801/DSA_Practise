import java.util.*;

public class busRoutes {
    public static void main(String[] args) {

    }

    public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        ArrayDeque<Integer> que = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        int[] vis = new int[routes.length];

        for(int i = 0; i < routes.length; i++){
            for(int j = 0; j < routes[i].length; j++){
                map.putIfAbsent(routes[i][j], new ArrayList<>());
                map.get(routes[i][j]).add(i);

                if(routes[i][j] == source){
                    que.add(i);
                    vis[i] = 1;
                }
            }
        }

        int change = 0;
        set.add(source);

        while(!que.isEmpty()){
            int size = que.size();
            while(size --> 0){
                int busCurr = que.poll();
                for(int stops : routes[busCurr]){
                    if(stops == target) return change;
                    if(set.contains(stops)) continue;
                    set.add(stops);

                    for(int buses : map.get(stops)){
                        if(vis[buses] == 1) continue;
                        que.add(buses);
                    }
                }
            }
            change++;
        }


        return -1;
    }
}
