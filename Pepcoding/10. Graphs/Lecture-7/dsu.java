public class dsu {
    
    //PROPERTIES 
    // only on undirected graph
    // Disjoint Set Union - simple
    // Transitive Nature - a u b and b u c -> a u c
    // seta -> setb == setb -> seta


    //path compression
    //union by size  - height ke basis pr bois!! (pretty dope)
    //if used only one - O(logn)
    //if used both - O(4) - Ackerman's Proof for figuring this out
    //Don't give a fuck about how that works for sure!

    //ADVANTAGE
    //no need to create graph 
    //DSU -> dynamic graph 
    //cycle detection
    //spanning trees 
    //minimum spanning trees

    //DISADVANTAGE
    //bidirectional relation
    //transitive relation

    //Question
    //cycle detetion without making grpah
    //spanning tree - ( a graph with no cycle )

    //TWO CONCEPT -- 
    //union by rank - only for optimisation
    //union by size  - both for optimisaition and benefits

    //while using in matrix - always  use par[l2] = l1; //important (remember that)
    //something to learn from for sure today!! (i love it!!)

    //DSU based on heights rather than using number of elements present in them
    public int[] par;
    public int[] rank;

    public dsu(int size){
        rank = new int[size];
        par = new int[size];
        for(int i = 0; i < size; i++){
            par[i] = i;
        }
    }

    public int find(int u){  //simple one liner
        return par[u] == u ? u : (par[u] = find(par[u]));
    }

    public int union(int u, int v){
        int l1 = find(u);
        int l2 = find(v);
        if(l1 != l2){
            int r1 = rank[l1];
            int r2 = rank[l2];
            if(r1 > r2){
                par[l2] = l1;
            }else if(r1 < r2){
                par[l1] = l2;
            }else{
                par[l1] = l2;
                rank[l2]++;
            }
        }else{
            return -1;
        }
        return 1;
    }
    

}
