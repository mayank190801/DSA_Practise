import java.io.*;
import java.util.*;

class encoding {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        int v = Integer.parseInt(st[0]);
        int e = Integer.parseInt(st[1]);

        int[] wells = new int[v];
        String[] words = br.readLine().split(" ");

        for (int i = 0; i < wells.length; i++) {
            wells[i] = Integer.parseInt(words[i]);
        }

        int[][] pipes = new int[e][3];
        for (int i = 0; i < e; i++) {
            String[] st1 = br.readLine().split(" ");
            pipes[i][0] = Integer.parseInt(st1[0]);
            pipes[i][1] = Integer.parseInt(st1[1]);
            pipes[i][2] = Integer.parseInt(st1[2]);

        }

        System.out.println(minCostToSupplyWater(v, wells, pipes));

    }

    //parent finding function
    public static int find(int[] parent, int a){
        return parent[a] == a ? a : (parent[a] = find(parent, parent[a]));
    }
    public static int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        //cost of making wells is given
        //all the pipes are given to us as well! - great shit
        int[] rank = new int[n + 1];
        int[] parent = new int[n + 1];
        int[] water = new int[n + 1];

        Arrays.fill(rank, 1);
        for(int i = 0; i <= n; i++) parent[i] = i;

        int cost = 0;
        int left = n;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        for(int i = 0; i < wells.length; i++) pq.add(new int[]{-1, (i + 1), wells[i]});
        for(int i = 0; i < pipes.length; i++) pq.add(new int[]{pipes[i][0], pipes[i][1], pipes[i][2]});

        System.out.println(pq);

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            if(curr[0] == -1){  //it's an edge
                int par = find(parent, curr[1]);
                if(water[par] != 1){
                    water[par] = 1;
                    left -= rank[par];
                    cost += curr[2];
                }
            }else{
                int par1 = find(parent, curr[0]);
                int par2 = find(parent, curr[1]);

                if(water[par1] == 1 && water[par2] == 1) continue;

                if(water[par1] == 1 || water[par2] == 1){  //we make the edge for sure
                    //connected simply
                    left -= (water[par1] == 1 ? rank[par2] : rank[par1]);
                    parent[par2] = par1;
                    rank[par1] += rank[par2];
                    cost += curr[2];

                }else{
                    cost += curr[2];
                    parent[par2] = par1;
                    rank[par1] += rank[par2];

                }
            }

            if(left == 0) return cost;
        }

        return cost;
    }


}
