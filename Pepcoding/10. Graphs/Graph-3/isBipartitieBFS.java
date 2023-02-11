import java.util.ArrayDeque;
import java.util.Arrays;

public class isBipartitieBFS {
    public static void main(String[] args) {

    }

    public boolean support(int[][] graph, int[] vis, int current){
        ArrayDeque<Integer> que = new ArrayDeque<>();
        que.add(current);
        vis[current] = 1;
        int color = 0;

        while(!que.isEmpty()){
            int size = que.size();
            while(size --> 0){
                int curr = que.poll();
                for(int edge : graph[curr]){
                    if(vis[edge] == -1){
                        vis[edge] = color;
                        que.add(edge);
                    }else if(vis[edge] != color) return false;
                }

            }
            color = (color + 1) % 2;
        }

        return true;
    }

    //now figure out a cute solve
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        Arrays.fill(vis, -1);
        for(int i= 0; i < n; i++){
            if(vis[i] != -1) continue;
            ArrayDeque<Integer> que = new ArrayDeque<>();
            que.add(i);
            vis[i] = 1;
            int color = 0;

            while(!que.isEmpty()){
                int size = que.size();
                while(size --> 0){
                    int curr = que.poll();
                    for(int edge : graph[curr]){
                        if(vis[edge] == -1){
                            vis[edge] = color;
                            que.add(edge);
                        }else if(vis[edge] != color) return false;
                    }

                }
                color = (color + 1) % 2;
            }
        }

        return true;
    }

}
