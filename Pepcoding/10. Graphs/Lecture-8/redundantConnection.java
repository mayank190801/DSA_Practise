public class redundantConnection {
    public static void main(String[] args) {
        
    }

    //find function
    public static int find(int[] par, int u){
        return par[u] == u ? u : (par[u] = find(par, par[u]));  //pretty single line logic
    }
    
    //THIS BELOW CODE RUNS IN 1 MS (super fast bitch!!!)
    //DSU is dope shit, always remember this bruh

    //my method bois
    public static int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;

        int[] par = new int[n];
        int[] rank = new int[n];

        for(int i= 0; i < n; i++){
            par[i] = i;
            rank[i] = 1;
        }

        //after this solve it - edges wise solve kro
        for(int i = 0; i < n - 1; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            //after this check if they have same parent
            int p1 = find(par, u);
            int p2 = find(par, v);

            if(p1 == p2){
                return new int[]{u,v};
            }

            //other
            int rank1 = rank[p1];
            int rank2 = rank[p2];
            
            if(rank1 > rank2){
                rank1 += rank2;
                par[p2] = p1;
            }else{
                rank2 += rank1;
                par[p1] = p2;
            }
        }
        
        return new int[]{0,0};
    }

    
}
