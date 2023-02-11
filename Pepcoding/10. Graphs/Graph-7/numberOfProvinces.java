import java.util.Arrays;

public class numberOfProvinces {
    public static void main(String[] args) {

    }

    public int findCircleNum(int[][] isConnected) {
        int num = isConnected.length;
        int compo = num;
        dsu d = new dsu(num);
        for(int i = 0; i < isConnected.length; i++){
            for(int j = 0; j < isConnected[i].length; j++){
                if(isConnected[i][j] == 1){
                    int success = d.union(i,j);
                    if(success == 1) compo--;
                }
            }
        }

        return compo;
    }

    public class dsu {

        private int[] rank;
        private int[] par;

        dsu(int size){
            rank = new int[size];
            par = new int[size];

            Arrays.fill(rank, 1);
            for(int i= 0; i < size; i++){
                par[i] = i;
            }
        }

        public int find(int u){
            return par[u] == u ? u : (par[u] = find(par[u]));
        }

        public int union(int u, int v) {
            int par1 = find(u);
            int par2 = find(v);

            if (par1 == par2) return -1;
            int r1 = rank[par1];
            int r2 = rank[par2];

            if (r1 > r2) {
                rank[par1] += rank[par2];
                par[par2] = par1;
            } else {
                rank[par2] += rank[par1];
                par[par1] = par2;
            }

            return 1;
        }
    }

}
