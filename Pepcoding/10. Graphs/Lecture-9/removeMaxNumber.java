import java.util.*;
import java.io.*;

public class removeMaxNumber {
    public static void main(String[] args) {
        
    }

    public static class dsuSize {
        int[] rank, parent;
        int n;
      
        public dsuSize(int n)
        {
            rank = new int[n];
            parent = new int[n];
            Arrays.fill(rank, 1);
            Arrays.fill(parent,-1);
            this.n = n;
        }
      
        public int find(int curr){
            if(parent[curr] == -1)
                return curr;
 
            //path compression optimisation
            return parent[curr] = find(parent[curr]);
        }
 
        public int union(int a, int b){
            int s1 = find(a);
            int s2 = find(b);
 
            if(s1 != s2){
                //union by size
                if(rank[s1] < rank[s2]){
                    parent[s1] = s2;
                    rank[s2] += rank[s1];
                }else{
                    parent[s2] = s1;
                    rank[s1] += rank[s2];
                }

                return 1;
            }
            return -1;
        }
    }


    //MY METHOD - first go solve baby!!!
    //fucking insane bruh  
    //so so so happy bruh!!
    
    //simply the question of how many removals, easy no?
    public static int maxNumEdgesToRemove(int n, int[][] edges) {
        dsuSize reddsu = new dsuSize(n + 1);
        dsuSize greendsu = new dsuSize(n + 1);

        int cntRed = n;
        int cntGreen = n;  //pretty basic idea 
        int remove = 0;

        for(int[] edge : edges){
            int u = edge[1];
            int v = edge[2];

            //after this is pretty simple for sure, no?
            if(edge[0] == 3){
                int get = reddsu.union(u, v);
                greendsu.union(u, v);
                if(get == 1){
                    cntGreen--;
                    cntRed--;
                }else remove++;
            }
        }

        //after this all have happened, do one thing for sure!! 
        //add remaining edge
        for(int[] edge : edges){
            int u = edge[1];
            int v = edge[2];

            //after this is pretty simple for sure, no?
            if(edge[0] == 1){
                int get = reddsu.union(u, v);
                if(get == 1) cntRed--; else remove++;
            }

            if(edge[0] == 2){
                int get = greendsu.union(u, v);
                if(get == 1) cntGreen--; else remove++;
            }
        }

        if(cntGreen == 1 && cntRed == 1) return remove;
        return -1;
    }
    
}
