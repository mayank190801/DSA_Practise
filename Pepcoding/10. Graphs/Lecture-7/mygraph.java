import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class mygraph {

    public class dsu {
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


    public static class dsuUpdate {
        int[] rank, parent;
        int n;
      
        public dsuUpdate(int n)
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
 
        public void union(int a, int b){
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
            }
        }
    }

    public static void main(String[] args) {
        
    }

    //--- (solving question) --
    //cycle detection baby
    public static boolean cycleDetection(int[][] edges, int n){
        dsu uf = new dsu(n);
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            int val = uf.union(u, v);
            if(val == -1) return true;
        }
        return false;
    }
    
    //spanning trees
    public static void spanningTree(int n, int[][] edges){
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i= 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        dsu uf = dsu(n);
        for(int i= 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            int val = uf.union(u,v);  //could be this and another method could be doable too!
            if(val != -1){
                graph[u].add(v);
                graph[v].add(u);
            }
        }
    }
    
    //for minimum spanning trees - send edges on the basis of minimum weights -- imp
    //same as above code for sure! bois   
    
    //-- (new question) -- 
    //number of connected provinces for sure

    //one method for sure

    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        dsu uf = new dsu(n);
        for(int i= 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1){
                    uf.union(i,j);
                }
            }
        }
        
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(uf.find(i));
        }
        
        return set.size();
    }

    //second method
    //much much much better code for sure!! -- I love this code for real man
    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int compo = n;

        dsu uf = new dsu(n);
        for(int i= 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(isConnected[i][j] == 1){
                    int val = uf.union(i,j);
                    if(val == 1) compo--;
                }
            }
        }
        
        return compo;
    }

    //--(new question) --

    //method - 1
    //number of island --  (using my own dsu!!!! (everything on my own))
    public static int numIslands(char[][] grid) {
        //solve using DSU for once, using your own method and logic
        //r * c method for sure
        int r = grid.length;
        int c = grid[0].length;

        dsuUpdate uf = new dsuUpdate(r * c);  //total size of the shit

        for(int i= 0; i < r; i++){
            for(int j= 0; j < c; j++){
                if(grid[i][j] == '0') continue;
                
                int curr = i * c + j;
                int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
                for(int[] d: dir){
                    int cx = i + d[0];
                    int cy = j + d[1];

                    if(cx >= 0 && cx < r && cy >= 0 && cy < c && grid[cx][cy] == '1'){ 
                        int next = cx * c + cy;
                        uf.union(curr, next);
                    }
                }

            }
        }

        //and in the end find the biggest size by traversing through all shit
        //after this count the maximum for once!!! for us bruh
        Set<Integer> set = new HashSet<>();
        //now count the number of parenst
        for(int i= 0; i < r; i++){
            for(int j= 0; j < c; j++){
                if(grid[i][j] == '1'){
                    set.add(uf.find(i * c + j));
                }
            }
        }

        return set.size();
    }

    //method - 2
    //number of island --  (using my sir dsu!!!! (everything on my own))
    //a bit better than mine one for sure boss!!!
    public static int numIslands(char[][] grid) {

        int r = grid.length;
        int c = grid[0].length;

        dsu uf = new dsu(r * c);  //total size of the shit

        for(int i= 0; i < r; i++){
            for(int j= 0; j < c; j++){
                if(grid[i][j] == '0') continue;
                
                int curr = i * c + j;
                int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
                for(int[] d: dir){
                    int cx = i + d[0];
                    int cy = j + d[1];

                    if(cx >= 0 && cx < r && cy >= 0 && cy < c && grid[cx][cy] == '1'){ 
                        int next = cx * c + cy;
                        uf.union(curr, next);
                    }
                }

            }
        }

        //and in the end find the biggest size by traversing through all shit
        //after this count the maximum for once!!! for us bruh
        Set<Integer> set = new HashSet<>();
        //now count the number of parenst
        for(int i= 0; i < r; i++){
            for(int j= 0; j < c; j++){
                if(grid[i][j] == '1'){
                    set.add(uf.find(i * c + j));
                }
            }
        }

        return set.size();

    }

    //method -3 (Sir code is legendary for sure)
    // NUMBER OF ISLAND

     public int numIslands(char[][] grid) {
        int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int r = grid.length;
        int c = grid[0].length;
        dsu uf = new dsu(r * c);
        int ans = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    int u = i * c + j;
                    for (int[] d : dir) {
                        int nr = i + d[0];
                        int nc = j + d[1];
                        if (nr >= 0 && nc >= 0 && nr < r && nc < c
                                && grid[nr][nc] == '1') {
                            int v = nr * c + nc;
                            int val = uf.union(u, v);
                            if (val != -1) {// different parent  //finding gcc using answer variable is dope
                                ans--;
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }


    //--(new question) --
    
    //METHOD - 1
    //maximum area of island - (using my own DSU)
    //My dsu code gives perfect answer for this piece of code for sure!!
    //and i am totally okay with it! - loved it boss - no worries
    //let's try to code sir method and tryna understand how it works
    public int maxAreaOfIsland(int[][] grid) {
         //solve using DSU for once, using your own method and logic
        //r * c method for sure
        int r = grid.length;
        int c = grid[0].length;

        dsuUpdate uf = new dsuUpdate(r * c);  //total size of the shit

        for(int i= 0; i < r; i++){
            for(int j= 0; j < c; j++){
                if(grid[i][j] == 0) continue;
                
                int curr = i * c + j;
                int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
                for(int[] d: dir){
                    int cx = i + d[0];
                    int cy = j + d[1];

                    if(cx >= 0 && cx < r && cy >= 0 && cy < c && grid[cx][cy] == 1){ 
                        int next = cx * c + cy;
                        uf.union(curr, next);
                    }
                }

            }
        }

        //and in the end find the biggest size by traversing through all shit
        //after this count the maximum for once!!! for us bruh
        int size = 0;
        //now count the number of parenst
        for(int i= 0; i < r; i++){
            for(int j= 0; j < c; j++){
                if(grid[i][j] == 1){
                    size = Math.max(size, uf.rank[i * c + j]);
                }
            }
        }

        return size;
    }

    //method - 2, (Sir method for suree)
    //inbuilt dsu - with specific rank/size updation on one specific person
    //dope stuff for sure!! //parent[l2] = l1 & so on for the coolness
    public static int find(int[] par, int u){
        return par[u] == u ? u : (par[u] = find(par, par[u]));  //pretty single line logic
    }

    //This code actually runs the fastest as fuck boi!! (i liked it for sure)
    //inbuilt DSU is dope as fuck for sure!!
    public static int maxAreaOfIsland(int[][] grid) {
        //r * c method for sure
        int r = grid.length;
        int c = grid[0].length;
 
        int[] size = new int[r * c];
        int[] par = new int[r * c];
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        for(int i= 0; i < r * c; i++){
            par[i] = i;
            size[i] = 1;
        }
 
        int ans = 0;
        for(int i= 0; i < r; i++){
            for(int j= 0; j < c; j++){
                if(grid[i][j] == 0) continue;
                 
                int curr = i * c + j;
                int l1 = find(par, curr);
                for(int[] d: dir){
                    int cx = i + d[0];
                    int cy = j + d[1];
 
                    if(cx >= 0 && cx < r && cy >= 0 && cy < c && grid[cx][cy] == 1){ 
                        int next = cx * c + cy;
                        //now writing the union method in here
                        int l2 = find(par, next);
                        if(l1 != l2){  //important step for sure dude
                            par[l2] = l1;
                            size[l1] += size[l2];
                        }
                    }
                }

                ans = Math.max(ans, size[l1]);
            }   
        }

        return ans;
    }


    //--( new question )--
    //largest island by changing the bit!!!
    //One thing learned, using .clear() on data structures is super fast ngl!!
    //from 
    public static int largestIsland(int[][] grid) {
        //let's use inbuilt dsu, and dope as shit sir method or mine! - mine for sure! mine for the win
        //sir one is just bullshit boss!! - and annoying as fuck for sur!! - bitch!!
         //r * c method for sure
        int r = grid.length;
        int c = grid[0].length;
 
        int[] size = new int[r * c];
        int[] par = new int[r * c];
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

        for(int i= 0; i < r * c; i++){
            par[i] = i;
            size[i] = 1;
        }
 
        int ans = 0;
        for(int i= 0; i < r; i++){
            for(int j= 0; j < c; j++){
                if(grid[i][j] == 0) continue;
                 
                int curr = i * c + j;
                int l1 = find(par, curr);
                for(int[] d: dir){
                    int cx = i + d[0];
                    int cy = j + d[1];
 
                    if(cx >= 0 && cx < r && cy >= 0 && cy < c && grid[cx][cy] == 1){ 
                        int next = cx * c + cy;
                        //now writing the union method in here
                        int l2 = find(par, next);
                        if(l1 != l2){  //important step for sure dude
                            par[l2] = l1;
                            size[l1] += size[l2];
                        }
                    }
                }

                ans = Math.max(ans, size[l1]);
            }   
        }
        
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                int count = 1;
                set.clear();  //a clear method does wonder bois!! damn it!! never knew this thing
                if(grid[i][j] == 1) continue;

                for(int[] d: dir){
                    int cx = i + d[0];
                    int cy = j + d[1];
 
 
                    if(cx >= 0 && cx < r && cy >= 0 && cy < c && grid[cx][cy] == 1){ 
                        int next = cx * c + cy;
                        int l2 = find(par, next);
                        // System.out.println(l2);
                        if(set.contains(l2)) continue;
                        set.add(l2);
                        count += size[l2];
                    }
                }
                ans = Math.max(ans, count);
            }
        }
        
        return ans;
    }

    //Method - 2 (sir code for the above question)
    public int largestIsland(int[][] grid) {
        int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int r = grid.length;
        int c = grid[0].length;
        int[] par = new int[r * c];
        int[] size = new int[r * c];
        for (int i = 0; i < r * c; i++) {
            par[i] = i;
            size[i] = 1;
        }
        HashSet<Integer> leader = new HashSet<>();

        int ans = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    int u = i * c + j;
                    int l1 = findPar(par, u);
                    for (int[] d : dir) {
                        int nr = i + d[0];
                        int nc = j + d[1];
                        if (nr >= 0 && nc >= 0 && nr < r && nc < c && grid[nr][nc] == 1) {
                            int v = nr * c + nc;
                            int l2 = findPar(par, v);
                            if (l1 != l2) {
                                par[l2] = l1;
                                size[l1] = size[l1] + size[l2];
                            }
                        }
                    }
                    ans = Math.max(ans, size[l1]);// max area
                }
            }
        }

        int sum = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 0) {
                    sum = 0;
                    leader.clear();  //the most OP thing of the day for sure boss!! (totally gotta work for it)
                    for (int[] d : dir) {
                        int nr = i + d[0];
                        int nc = j + d[1];
                        if (nr >= 0 && nc >= 0 && nr < r && nc < c && grid[nr][nc] == 1) {
                            int v = nr * c + nc;
                            int l2 = findPar(par, v);
                            if (!leader.contains(l2)) {
                                sum += size[l2];
                                leader.add(l2);
                            }
                        }
                    }
                    ans = Math.max(ans, sum + 1);// max after converting
                }
            }
        }

        return ans;
    }

    //-- (new question) -- 
    //let's solve this question for sure no matter what boi!! (simple solve it)

    //Number of islands II  -> static, dynamic, transitive and all
    //GOT ACCEPTED SUPER EASILY BOSS

    //METHOD - 1 MINE MINE MINE MINE MINE
    public static List<Integer> numIslands2(int n, int m, Point[] operators) {
        //simply return number of operators at each turn //points genuine
        int ans = 0;
        int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        Set<Integer> set = new HashSet<>();  //I USED BASICALLY THIS LOGIC FOR SURE!!! (simple as fuck)
        dsu uf = new dsu(n * m);
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i = 0; i < operators.length; i++){
            Point curr = operators[i];
            int x = curr.x;
            int y = curr.y;

            int present = x * m + y;
            if(set.contains(present)){
                answer.add(ans);
                continue;
            };

            ans++;
            for(int[] d : dir){
                int cx = x + d[0];
                int cy = y + d[1];

                int next = cx * m + cy;
                if(cx >= 0 && cx < n && cy >= 0 && cy < m && set.contains(next)){
                    int val = uf.union(present, next);
                    if(val == 1){
                        ans--;
                    }
                }
            }

            set.add(present);
            answer.add(ans);
        }

        return answer;
    }

    //METHOD - 2 (USING GRID) + (inbuilt DSU - dope shit)
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int r = m;
        int c = n;
        int[] par = new int[r * c];
        for (int i = 0; i < r * c; i++) {
            par[i] = i;
        }
        int[][] grid = new int[r][c];
        List<Integer> ans = new ArrayList<>();
        int count = 0;
        for (int[] e : positions) {
            int i = e[0];
            int j = e[1];
            if (grid[i][j] == 1) {
                ans.add(count);
                continue;
            }
            grid[i][j] = 1;
            count++;
            for (int[] d : dir) {
                int nr = i + d[0];
                int nc = j + d[1];
                if (nr >= 0 && nc >= 0 && nr < r && nc < c && grid[nr][nc] == 1) {
                    int u = i * c + j;
                    int v = nr * c + nc;
                    int p1 = findPar(par, u);
                    int p2 = findPar(par, v);
                    if (p1 != p2) {
                        count--;
                        par[p2] = p1;
                    }
                }
            }
            ans.add(count);
        }
        return ans;
    }

    //Method - 3 (Without grid) - (without extra space as a set!!)
    //-- could you solve it without grid?? (this question is asked mostly in interviews) --
    public List<Integer> numIslands2_(int m, int n, int[][] positions) {
        int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int r = m;
        int c = n;
        int[] par = new int[r * c];
        for (int i = 0; i < r * c; i++) {
            par[i] = -1;// water initially
        }
        List<Integer> ans = new ArrayList<>();
        int count = 0;
        for (int[] e : positions) {
            int i = e[0];
            int j = e[1];
            int u = i * c + j;
            if (par[u] != -1) {
                ans.add(count);
                continue;
            }
            par[u] = u;
            // marking as land (only change in the code for sure!! (simply mark that edge as not -1)
            //SIMPLE CHANGE IN THE CODE KEEPS US FROM USING HASHSET<>();

            count++;
            for (int[] d : dir) {
                int nr = i + d[0];
                int nc = j + d[1];
                if (nr >= 0 && nc >= 0 && nr < r && nc < c && par[nr * c + nc] != -1) {  //dope logic for sure
                    int v = nr * c + nc;
                    int p1 = findPar(par, u);
                    int p2 = findPar(par, v);
                    if (p1 != p2) {
                        count--;
                        par[p2] = p1;
                    }
                }
            }
            ans.add(count);
        }
        return ans;
    }


    // -- (new question ) --
    //inbuilt implementations are cool for sure
    //few snippets of gyaan 
    //ALWAYS TRY TO IGNORE HASHMAP AS MUCH AS YOU CAN!!!! (pretty simple)

    //--Similar String Groups --

    //my method
    //first method - 1 ( mine mine mine mine ) (using dsu and array)

    //ONE VERY KILLER OPTIMISATION IN SIR CODE IS 
    //PUTTING COUNT >= 2 pr false inside the loop only!!!!
    //from 315 ms to 25 ms seedha conversion!! (fucking insane due)
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
                boolean flag = true;
                for(int k = 0; k < one.length(); k++){
                    if(one.charAt(k) != two.charAt(k)) diff++;  //at max two pos should be different 

                    //BRILLIANT FUCKING OBSERVATION DUDE!! (please figure this small small one your own bruh)
                    if(diff > 2){
                        flag = false;
                        break;
                    }
                }

                if(!flag) continue;

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


    //Sir method - dope observation and optimistion skills for sure
    public int numSimilarGroups(String[] strs) {
        int len = strs.length;
        int[] par = new int[len];// index based mapping
        int groups = len;
        for (int i = 0; i < len; i++) {
            par[i] = i;
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {// checking each pair similarity
                boolean similar = isSimilar(strs, i, j);
                if (similar) {
                    int p1 = findPar(par, i);
                    int p2 = findPar(par, j);
                    if (p1 != p2) {
                        par[p1] = p2;
                        groups--;
                    }
                }
            }
        }
        return groups;
    }

    public boolean isSimilar(String[] str, int i, int j) {
        int count = 0;
        for (int k = 0; k < str[i].length(); k++) {
            char ch1 = str[i].charAt(k);
            char ch2 = str[j].charAt(k);
            if (ch1 != ch2) {
                count++;
            }
            if (count > 2) {
                return false;
            }
        }
        return true;
    }


    //-- (new question) --
    //REDUNDANT CONNECTION BOIS
    
    // why dsu and not dfs??
    // dsu helps us find the last edge first of all!!!! 
    // seond dfs might not be totally efficient in finding the last one specifically
    // but for dfs we might have to make graph, but for dsu there is no need for sure!! (remember that)
    
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

    //sir method - mini as fuck code bruh - just used dsu class in here, not a big deal 
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        dsu uf = new dsu(n + 1);
        for (int[] e : edges) {  //always traverse smartly like him!! (so much to learn from his code)
            int u = e[0];
            int v = e[1];
            int val = uf.union(u, v);
            if (val == -1) {
                return e; //woah superb!!! (loved it bruh!!!) --- awesome optimisation dude
            }
        }
        return new int[0];
    }

    //a bit too lenghty for sure, bruh look into it please
    //-- (new question) --
    //lexographically smallest equivalent string 

    //my method
    //my dsu method for this question
    //time O(1)
    //space O(1)
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

    //we will look into sir method now for sure!
    //SIR METHOD
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] par = new int[26];
        for (int i = 0; i < 26; i++) {
            par[i] = i;
        }
        // DSU GENERATION
        for (int i = 0; i < s1.length(); i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            int p1 = findPar(par, ch1 - 'a');
            int p2 = findPar(par, ch2 - 'a');
            if (p1 < p2) {
                par[p2] = p1;
            } else {
                par[p1] = p2;
            }
        }

        // ANWSER GENERATION
        StringBuilder ans = new StringBuilder();

        for (char ch : baseStr.toCharArray()) {
            int idx = ch - 'a';
            int p = findPar(par, idx);
            ans.append((char) (p + 'a'));
        }
        return ans.toString();
    }

    //CONCEPT CHECK UP
    //string union ways
    //1. index - simliar string
    //2. mapping - lexi smallest string
    //3. hashmap - sentence simliarity

    // -- (new question) -- 
    //SENTECNE SIMILARITY 2 (for sure now)

    //MY METHOD
    //DSU with hashmap!! (dope shit bois)
    //giving every string some value bruh! 
    public static boolean isSentenceSimilarity(String[] words1, String[] words2, List<List<String>> pairs) {
        //first add all strings from pairs and give them some kind of numbering - my way of solving
        HashMap<String, Integer> map = new HashMap<>();
        for(List<String> pair : pairs){
            for(String curr : pair){
                if(map.containsKey(curr)) continue;
                map.put(curr, map.size());
            }
        }

        //after this we have some numberings attached 
        int n = map.size();
        int[] par = new int[n];
        for(int i= 0; i < n; i++){
            par[i] = i;  //after this it should be resolved for sure!
        }

        //let's make pairing and union right now
        for(List<String> pair : pairs){
            String one = pair.get(0);
            String two = pair.get(1);
            int none = map.get(one);
            int ntwo = map.get(two);

            //after this find their parents
            int p1 = find(par, none);
            int p2 = find(par, ntwo);

            if(p1 != p2){
                par[p1] = p2;
            }
        }

        //now making parent finding simpler
        for(int i= 0; i < words1.length; i++){
            String one = words1[i];
            String two = words2[i];

            if(one.compareTo(two) == 0) continue;  //incase both are same strings, simply move on
            if(!map.containsKey(one) || !map.containsKey(two)){
                return false;
            }
            
            //otherwise simply check if their parents are same or not
            int none = map.get(one);
            int ntwo = map.get(two);
            if(find(par, none) != find(par, ntwo)) return false;
        }
        // write your code here
        return true;
    }

    //SIR METHOD
    //sir method - let's see how did he do this one!! (i remember it's pretty cool for sure)
    //DOPE WAY OF MAKING DSU - string string, dsu brother!! (dope shit) - always remember that
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        HashMap<String, String> par = new HashMap<>();
        if (sentence1.length != sentence2.length) {
            return false;
        }
        // dsu creation
        for (List<String> similar : similarPairs) {
            String s1 = similar.get(0);
            String s2 = similar.get(1);
            if (!par.containsKey(s1)) {
                par.put(s1, s1);
            }

            if (!par.containsKey(s2)) {
                par.put(s2, s2);
            }

            String p1 = findPar(par, s1);
            String p2 = findPar(par, s2);
            par.put(p1, p2); //no sort of optimisation in here
        }

        // CHECK IF SIMILAR

        for (int i = 0; i < sentence1.length; i++) {
            String s1 = sentence1[i];
            String s2 = sentence2[i];

            //few edges cases needs to be handled ofc!
            if (s1.equals(s2)) {
                continue;
            }

            if (!par.containsKey(s1) || !par.containsKey(s2))
                return false;

            String p1 = findPar(par, s1);
            String p2 = findPar(par, s2);

            if (!p1.equals(p2)) {
                return false;
            }
        }
        return true;
    }

    //helper function for above shit
    public String findPar(HashMap<String, String> par, String u) {
        if (par.get(u).equals(u)) {
            return u;
        }
        String p = findPar(par, par.get(u));
        par.put(u, p);  //path compression - damn!! (super technique)
        return p;
    }

    //both methods are dope, remember both the practises for sure!! (no worries about anything else bruh)
    //simply and easy way of solving this question!! string string dope shit

    //-- (new question) --
    //SATISIFIABLITY OF EQUATIONS
    
    //MY SOLVE
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

    //SIR SOLVE
    // SATISFIABLILITY EQUATION
    public boolean equationsPossible(String[] equations) {
        int[] par = new int[26];
        for (int i = 0; i < par.length; i++) {
            par[i] = i;
        }

        // dsu for all equal
        for (String s : equations) {
            if (s.charAt(1) == '=') {
                char ch1 = s.charAt(0);
                char ch2 = s.charAt(3);
                int p1 = findPar(par, ch1 - 'a');
                int p2 = findPar(par, ch2 - 'a');
                par[p1] = p2;
            }
        }

        // CHECK FOR OPPOSITE
        for (String s : equations) {
            if (s.charAt(1) == '!') {
                char ch1 = s.charAt(0);
                char ch2 = s.charAt(3);
                int p1 = findPar(par, ch1 - 'a');
                int p2 = findPar(par, ch2 - 'a');
                if (p1 == p2) {
                    return false;
                }
            }
        }
        return true;
    }


    // -- (new question) --

    //REMOVE MAX NUMBER OF EDGES

    //My method
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
    

    //sir method
    //one improvement in sir code - simply sorted the game
    //super duper thinking skills dude, i love it for fuck sake
    //improvement from my code, wow, dope, sort, i love it
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges, (a, b) -> (b[0] - a[0]));  //fucking insane dude! (so smart for sure)
        int[] apar = new int[n + 1];
        int[] bpar = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            apar[i] = i;
            bpar[i] = i;
        }
        int remove = 0;
        int c1 = n;
        int c2 = n;
        for (int[] e : edges) {
            int type = e[0];
            int u = e[1];
            int v = e[2];
            if (type == 1) {// alice
                int p1 = findPar(apar, u);
                int p2 = findPar(apar, v);
                if (p1 == p2) {
                    remove++;
                } else {
                    apar[p1] = p2;
                    c1--;
                }
            } else if (type == 2) {// bob
                int p1 = findPar(bpar, u);
                int p2 = findPar(bpar, v);
                if (p1 == p2) {
                    remove++;
                } else {
                    bpar[p1] = p2;
                    c2--;
                }
            } else {// both
                int p1 = findPar(apar, u);
                int p2 = findPar(apar, v);
                if (p1 == p2) {
                    remove++;
                } else {
                    apar[p1] = p2;
                    bpar[p1] = p2;
                    c1--;
                    c2--;
                }
            }
        }
        if (c1 != 1 || c2 != 1) {
            return -1;
        }
        return remove;
    }


    // -- ( new question ) --
    // MALWARE SPREAD

    //MY SOLVE
    public static int minMalwareSpread(int[][] graph, int[] initial) {
        //making a dsu for sure, in this one
        int n = graph.length;
        int[] par = new int[n];
        int[] rank = new int[n];

        for(int i= 0; i < n; i++){
            par[i] = i;
            rank[i] = 1;
        }

        for(int i= 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(graph[i][j] == 0) continue;
                
                int p1 = find(par, i);
                int p2 = find(par, j);

                if(p1 == p2) continue;
                int r1 = rank[p1];
                int r2 = rank[p2];

                if(r1 < r2){
                    par[p1] = p2; 
                    rank[p2] = r1 + r2;
                }else{
                    par[p2] = p1;
                    rank[p1] = r1 + r2;
                }
            }
        }
        
        //after this it is pretty simple for sure
        Arrays.sort(initial);
        int[] parents = new int[n];
        for(int i : initial){
            parents[find(par, i)]++;
        }

        int ans = -1;  //return the node which could be removed for sure
        int node = -1;
        for(int i = 0; i < initial.length; i++){
            int curr = initial[i];
            if(parents[par[curr]] == 1){
                int size = rank[par[curr]];
                if(size > ans){
                    node = curr;
                    ans = size;
                }
            }
        }

        return node == -1 ? initial[0] : node;
    }

    //SIR SOLVE
    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        int[] par = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
            size[i] = 1;
        }

        // DSU CREATION
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (graph[i][j] == 1) {
                    int p1 = findPar(par, i);
                    int p2 = findPar(par, j);
                    if (p1 != p2) {
                        par[p1] = p2;
                        size[p2] += size[p1];
                    }
                }
            }
        }
        int[] infected = new int[n];
        // INFECTED NODE IN PARTICULAR GROUP
        for (int inf : initial) {
            int p = findPar(par, inf);
            infected[p]++;
        }

        // ANSWER CREATION
        int maxnodesaved = 0;
        Arrays.sort(initial);
        int ans = initial[0];

        for (int inf : initial) {
            int p = findPar(par, inf);
            int nodesinfected = infected[p];
            int sizeofcompo = size[p];
            if (nodesinfected == 1 && sizeofcompo > maxnodesaved) {
                ans = inf;
                maxnodesaved = sizeofcompo;
            }
        }
        return ans;
    }


}
