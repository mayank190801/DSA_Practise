public class lexographicallySmallest{
    public static void main(String[] args) {
        
    }


    //DAMN THIS QUESTION WORKED ON LITERALLY THE FIRST TRY BRUH

    public static int find(int[] par, int u){
        return par[u] == u ? u : (par[u] = find(par, par[u]));  //pretty single line logic
    }

    //my dsu method for this question
    public static String smallestString(String s, String t, String str) {
		int[] par = new int[26];
        for(int i= 0; i < 26; i++){
            par[i] = i;  //simply best
        }

        int n = s.length();

        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        char[] strc = str.toCharArray();

        //after we have done that mess
        for(int i= 0; i < n; i++){
            int one = sc[i] - 'a';
            int two = tc[i] - 'a';

            //jo lesser vaale pr pda hoga vo best hoga simple
            int p1 = find(par, one);
            int p2 = find(par, two);

            if(p1 < p2){
                par[p2] = p1;
            }else{
                par[p1] = p2;
            }
        }

        //after this simply update something for sure
        for(int i= 0; i < 26; i++){
            find(par, i);
        }

        //now update the given matrix
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strc.length; i++){
            int num = par[strc[i] - 'a'];
            sb.append((char)('a' + num));
        }

        String ans = sb.toString();
        return ans;
        
	}

}