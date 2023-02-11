public class satifiabilityEquations {
    public static void main(String[] args) {
        
    }

    //this given logic works flawlessly for sure bois!! 
    //just figure out the edge cases and you are good to go boi!
    //i love this for sure!

    public static int find(int[] par, int u){
        return par[u] == u ? u : (par[u] = find(par, par[u]));  //pretty single line logic
    }

    //
    public static boolean equationsPossible(String[] equations) {
        int[] par = new int[26];
        for(int i= 0; i < 26; i++){
            par[i] = i;
        }

        int n = equations.length;
        for(int i= 0; i < n; i++){
            if(equations[i].charAt(1) == '='){
                int one = equations[i].charAt(0) - 'a';
                int two = equations[i].charAt(4) - 'a';

                //make them connect for sure no matter what
                int p1 = find(par, one);
                int p2 = find(par, two);

                par[p1] = p2;  //simply connect them for some time
            }
        }

        for(int i= 0; i < n; i++){
            if(equations[i].charAt(1) != '='){
                int one = equations[i].charAt(0) - 'a';
                int two = equations[i].charAt(4) - 'a';

                //make them connect for sure no matter what
                int p1 = find(par, one);
                int p2 = find(par, two);

                if(p1 == p2) return false;
            }
        }

        return true;
    }

    
}
