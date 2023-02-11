public class isBipartiteDFS {

    public static void main(String[] args) {


    }

    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];

        boolean res = true;
        for(int i = 0; i < n; i++){
            if(vis[i] != 0) continue;
            res = res && bfsColor(graph, vis, 1, i);
        }

        return res;
    }

    public static boolean bfsColor(int[][] graph, int[] vis, int color, int num){

        //current ka color is 1 or 2 only
        vis[num] = color;
        boolean res = true;
        for(int i = 0; i < graph[num].length; i++){
            if(vis[graph[num][i]] != 0){
                if(vis[graph[num][i]] == color) return false;
            }else{
                res = res && bfsColor(graph, vis, color == 1 ? 2 : 1, graph[num][i]);
            }
        }

        return res;
    }

}
