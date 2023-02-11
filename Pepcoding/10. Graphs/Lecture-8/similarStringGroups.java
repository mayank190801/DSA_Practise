public class similarStringGroups {
    public static void main(String[] args) {
        String[] strs = {"tars","rats","arts","star"};
        int groups = numSimilarGroups(strs);
        System.out.println(groups);
    }

    //WITHOUT USING HASHMAP

    //find function 
    public static int find(int[] par, int u){
        return par[u] == u ? u : (par[u] = find(par, par[u]));  //pretty single line logic
    }
    
    //first method - 1 ( mine mine mine mine ) (using dsu and array)
    public static int numSimilarGroups(String[] strs) {
        //naming each of them somthing bad bruh
        int n = strs.length;
        int cnt = n;

        int[] par = new int[n];
        int[] rank = new int[n];
        for(int i = 0; i < n; i++){
            par[i] = i;
            rank[i] = 1;
        }
        

        //after this - run a for loop on this bad boi - gotta definitely check of all of them, no other option
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                String one = strs[i];
                String two = strs[j];
                
                int p1 = find(par, i);
                int p2 = find(par, j);
                if(p1 == p2) continue;

                int diff = 0;
                for(int k = 0; k < one.length(); k++){
                    if(one.charAt(k) != two.charAt(k)) diff++;  //at max two pos should be different 
                }

                if(diff <= 2){  //very important observation for sure 
                    int rank1 = rank[p1];
                    int rank2 = rank[p2];
                    
                    if(rank1 > rank2){
                        rank1 += rank2;
                        par[p2] = p1;
                    }else{
                        rank2 += rank1;
                        par[p1] = p2;
                    }

                    cnt--;
                }

            }
        }

        return cnt;
    }

    
}
