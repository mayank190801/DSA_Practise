import java.util.*;

public class busRoutes {
    public static void main(String[] args) {
        int[][] routes = {{1,2,7},{3,6,7}};
        int src = 1;
        int tar = 6;
        int ans = numBusesToDestination(routes, src, tar);
        System.out.println(ans);
    }

    //let's figure this out no matter what baby!!
    public static int numBusesToDestination(int[][] routes, int source, int target) {
        //jo number jaha exist krta hai uska hashmap arraylist for storing all the routes simple
      
        if(source == target) return 0;
         Map<Integer, ArrayList<Integer>> map = new HashMap();

         int max = 0;
        for(int i= 0; i < routes.length; i++){
            for(int j = 0; j < routes[i].length; j++){
                //ye route number i hai simple
                int point = routes[i][j];
                map.putIfAbsent(point, new ArrayList<>());
                map.get(point).add(i);
                max = Math.max(i,max);
            }
        }

        Queue<Integer> que = new ArrayDeque<>();
        int[] vis = new int[max + 1];
        int[] route = new int[routes.length + 1];
        que.add(source);
        vis[source] = 1;

        //this is game of premarking and stuff for your own benefit
        int bus = 0;
        while(!que.isEmpty()){
            int size = que.size();
            while(size --> 0){
                //for loop on all the routes we can take from that bad boi
                int top = que.poll();
                for(int ways : map.get(top)){  //checking all ways
                    //now these are routes to discover
                    if(route[ways] == 1) continue;
                    route[ways] = 1;

                    //now go through all
                    for(int points : routes[ways]){
                        if(vis[points] == 1) continue;
                        vis[points] = 1;

                        //now figuring out something way more imp
                        if(points == target){
                            return bus + 1;
                        }
                        que.add(points);
                    }
                }
            }

            bus++;
        }

        // System.out.println(map);
        return -1;
    }

}
