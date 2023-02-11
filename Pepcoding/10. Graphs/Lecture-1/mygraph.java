import java.util.*;

//Naming convenction is very important in here
public class mygraph {
    public static class Edge{
        int v = 0;
        int wt = 0;

        public Edge(int v, int wt){
            this.v = v;
            this.wt = wt;
        }

        @Override
        public String toString(){
            return "(" + v + "," + wt + ") ";
        }
    }

    static ArrayList<Edge>[] graph; //main graph
    static int n = 9;       //number of vertexes
    
    public static void main(String[] args) {
        init();
        addAll();
        display();
        boolean present = hasPath(1,7, new boolean[n+1]);
        int count = allPath(1, 7, "1", 0, new boolean[n+1]);
        pair ans = heaviestPath(1,7, new boolean[n+1]);
        System.out.println(present);
        System.out.println(count);
        System.out.println(ans);
    }

    public static void addAll(){
        addEdge(1, 2, 10);
        addEdge(1, 4, 10);
        addEdge(2, 3, 2);
        addEdge(3, 4, 8);
        addEdge(3, 8, 3);
        addEdge(3, 9, 2);
        addEdge(8, 9, 5);
        addEdge(4, 5, 5);
        addEdge(5, 6, 7);
        addEdge(5, 7, 6);
        addEdge(6, 7, 6);
//        addEdge(8, 7, 1);// for hamiltonian cycle

//        removeVertex(5);
        // removeEdge(2, 3);
        // removeEdge(3, 8);
//         removeEdge(4, 5);
        // removeEdge(6, 7);
    }

    //simple function for displaying bruh
    public static void display(){
        for(int i= 1; i <= n; i++){
            System.out.print(i + "-> ");
            for(Edge e : graph[i]){
                // System.out.print("(" + e.v + " , " + e.wt + " ) ");
                System.out.print(e);
            }
            System.out.println();
        }       
    }

    public static int findEdge(int u , int v){
        for(int i = 0; i < graph[u].size(); i++){
            Edge e = graph[u].get(i);
            if(e.v == v){
                return i;
            }
        }
        return -1;
    }

    //O(2V) - time complexity
    public static void removeEdge(int u, int v){
        int idx1 = findEdge(u, v);
        graph[u].remove(idx1);

        //swap and remove is also one method for sure!! (don't forget it)
        int idx2 = findEdge(v, u);
        graph[v].remove(idx2);
    }

    public static void removeVertex(int vrtx){
        ArrayList<Edge> list = graph[vrtx];
        //starting from end for some reasons! think why?
        for(int i= list.size()-1; i >= 0; i--){
            int nbr = list.get(i).v;
            removeEdge(vrtx, nbr);
        }

        //Because of complexity and stuff (not used)
        // while(graph[vrtx].size() > 0){
        //     Edge e = graph[vrtx].get(0);
        //     removeEdge(vrtx, e.v);
        // }
    }
    
    public static void addEdge(int u, int v, int wt){
        graph[u].add(new Edge(v, wt));
        graph[v].add(new Edge(u, wt));
    }

    public static void init(){
        graph = new ArrayList[n+1];
        for(int i= 0; i <= n; i++){
            graph[i] = new ArrayList<>();

        }
    }

    //Questions
    //hasPath(int src, int dest, boolean[] vis) //boolean
    //allPath(int src, int dest, String path, String cost, boolean[] vis) //return int
    //Heaviest Path(int src, int dest, boolean[] vis) //return pair
    //kthsmallestpath(int src, int dest, boolean[] vis) //return int

    public static class pair{
        int cost = 0;
        String path = "";

        public pair(int cost, String path){
            this.cost = cost;
            this.path = path;
        }

        @Override
        public String toString(){
            return this.cost + " " + this.path;
        }
    }

    //two method to visit the arrays (basically mark them)
    //just mark the current flag = true
    //or mark the one where you are going to be - true

    public static boolean hasPath(int src, int dest, boolean[] vis){

        //base case
        if(src == dest) return true;

        //premark the current flag
        vis[src] = true;
        boolean check = false;
        for(Edge e : graph[src]){
            if(!vis[e.v]){
                check = check || hasPath(e.v , dest, vis);
            }
        }

        return check;
    }

    public static int allPath(int src, int dest, String path, int cost, boolean[] vis){

        //base case
        if(src == dest){
            System.out.println(path + " " + cost);
            return 1;
        };

        //backtracking used in here for sure
        //premark the current flag
        vis[src] = true;
        int count = 0;
        for(Edge e : graph[src]){
            if(!vis[e.v]){
                count += allPath(e.v, dest, path + e.v, cost + e.wt, vis);
            }
        }
        vis[src] = false;

        return count;
    }

    public static pair heaviestPath(int src, int dest, boolean[] vis){
        //base case
        if(src == dest){
            return new pair(0, dest + "");  //return 0 if found the answer
        };

        //premark the current flag
        vis[src] = true;
        pair ans = new pair(Integer.MAX_VALUE , "");  //if path doesn't exist it will help for sure
        for(Edge e : graph[src]){
            if(!vis[e.v]){
                pair rec = heaviestPath(e.v, dest, vis);

                //greedily update check
                if(rec.cost != Integer.MAX_VALUE && rec.cost + e.wt > ans.cost){
                    ans.cost = rec.cost + e.wt;
                    ans.path = src + rec.path;
                }
            }
        }
        vis[src] = false;
        return ans;
    }

    //two method to solve this
    //infinity to floor & floor & floor

    //for this method, fucking watch heap lectures you bitch!!! 
    //also pending on arrays and sorting lectures you bitch!!! 
    //backlog bitch!!!! (fuck you asshole!!!)

    //priority queue method could be used too - (maxheap or minheap???)
    //minheap - O(logn)
    //maxheap - O(logk) keep the size never bigger than k!!!!! (brilliant method)
    public static int kthsmallestpath(int src, int dest, boolean[] vis){
        //calucalte all the path possible and add them in PQ
        return 0;
    }

    //cycle detection in graph - using dfs and bfs both
    public static boolean cycleDetection(){
        return true;
    }


    //LECTURE - 2 (questions)
    //copy gcc from kamal code
    // GET CONNECTED COMPONENETS
    // METHOD 1 (MARK AT VISITED POINT)
    public static int gcc() {
        boolean[] vis = new boolean[n + 1];
        int compo = 0;
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                dfs(i, vis);
                compo++;
            }
        }
        return compo;
    }

    public static void dfs(int src, boolean[] vis) {
        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.v]) {
                dfs(e.v, vis);
            }
        }
    }

    //METHOD -2 (MARK AT GOING POINT)
    public static int gcc2() {
        boolean[] vis = new boolean[n + 1];
        int compo = 0;
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                vis[i] = true;
                dfs2(i, vis);
                compo++;
            }
        }
        return compo;
    }

    public static void dfs2(int src, boolean[] vis) {
        for (Edge e : graph[src]) {
            if (!vis[e.v]) {
                vis[e.v] = true; 
                dfs(e.v, vis);
            }
        }
    }

    //above code works beautifully for sure!!! 
    //LEETCODE 3139
    public static int makeConnected(int n, int[][] connections) {

        if(connections.length < n - 1){
            return -1;
        }
           
        ArrayList<Integer>[] graph = new ArrayList[n];  //simple
        for(int i= 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        //now simply taking edge and stuff - if no weight it's simple for sure
        for(int[] rel : connections){
            int u = rel[0];
            int v = rel[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        //graph is done pretty much
        int compo = 0;
        boolean[] vis = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!vis[i]){
                dfs(graph, i, vis);
                compo++;
            }
        }

        return compo - 1;
    }

    public static void dfs(ArrayList<Integer>[] graph, int src, boolean[] vis){
        vis[src] = true;
        for(int e : graph[src]){
            if(!vis[e]){
                dfs(graph, e, vis);
            }
        }
        return;
    }

    //Hamiltonian path babies!! 
    //He still uses string, pretty dope ass boring technique!!!
    public static void hamiltonian(int src) {  //point dependent technique for sure!
        boolean[] vis = new boolean[n + 1];
        hamiltonian(src, src, vis, 1, "");// last 1 is number of vertex visitex
    }

    public static void hamiltonian(int osrc, int src, boolean[] vis, int count, String psf) {
        if (count == n) {
            int idx = findEdge(src, osrc); //reduced his code by a lot
            if (idx == -1) {
                System.out.println("Hamiltonian Path" + psf + src);
            } else {
                System.out.println("Hamiltonian Cycle" + psf + src + osrc);
            }
        }

        vis[src] = true;
        for (Edge e : graph[src]) {
            if (!vis[e.v]) {
                hamiltonian(osrc, e.v, vis, count + 1, psf + src);
            }
        }
        vis[src] = false;
    }

    // CYCLE DETECTION

    // METHOD 1

    public static boolean cycleDetection() {
        boolean res = false;
        boolean[] vis = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                res = res || cycleDfs(-1, i, vis);
            }
        }
        return res;
    }

    public static boolean cycleDfs(int par, int src, boolean[] vis) {
        vis[src] = true;
        boolean ans = false;
        for (Edge e : graph[src]) {
            if (!vis[e.v]) {
                ans = ans || cycleDfs(src, e.v, vis);
            } else if (par != e.v) {
                return true;
            }
        }
        return ans;
    }

    // METHOD 2
    public static boolean cycleDetection2() {
        boolean res = false;
        int[] par = new int[n + 1];
        Arrays.fill(par, -1);
        for (int i = 1; i <= n; i++) {
            if (par[i] == -1) {
                par[i] = i;
                res = res || cycleDfs2(i, par);
            }
        }
        return res;
    }

    public static boolean cycleDfs2(int src, int[] par) {
        boolean ans = false;
        for (Edge e : graph[src]) {
            if (par[e.v] == -1) {
                par[e.v] = src;
                ans = ans || cycleDfs2(e.v, par);
            } else if (par[src] != e.v) {
                return true;
            }
        }
        return ans;
    }

    //IS bipartite check using above parent method!!! (boolean only)

    //NUMBER OF ISLANDS MY METHOD!!! 
    public static int numIslands(char[][] grid) {
        int n = grid.length;
      int m = grid[0].length;
      boolean[][] vis = new boolean[n][m];

      int count = 0;
      //after this move through all
      for(int i= 0; i < n; i++){
          for(int j= 0; j < m; j++){
              if(grid[i][j] == '1' && !vis[i][j]){
                  dfsIslands(i,j, grid, vis, n, m);
                  count++;
              }
          }
      }

      return count;
  }
  
   public static void dfsIslands(int x, int y, char[][] grid, boolean[][] vis, int n, int m){
      //move in four direction
      int[] dx = {1,-1,0,0};
      int[] dy = {0,0, 1,-1};

      //after this 
      vis[x][y] = true;
      for(int i = 0; i < 4; i++){
          int cx = x + dx[i];
          int cy = y + dy[i];

          if(cx >= 0 && cx < n && cy >= 0 && cy < m && !vis[cx][cy] && grid[cx][cy] == '1'){
              dfsIslands(cx, cy, grid, vis, n, m);                
          }
      }

      return;
    }

    //number of islands --  sir method 
    //he didn't make visited array and used the previous shit for his own benefit!!! - OP stuff
    //Remember this technique for sure!!
    public int numIslandsSirMethod(char[][] grid) {
        int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int island = 0;
        int r = grid.length;
        int c = grid[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    islandDFS(grid, i, j, dir);
                    island++;
                }
            }
        }
        return island;
    }


    public static void islandDFS(char[][] grid, int sr, int sc, int[][] dir) {
        grid[sr][sc] = '0';
        for (int[] d : dir) {
            int nr = sr + d[0];
            int nc = sc + d[1];
            if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == '1') {
                islandDFS(grid, nr, nc, dir);
            }
        }
    }

    //---- (next question) -- //
    //MAX AREA OF ISLAND - my method 
    //ACCEPTED 7ms!!!!
      public int maxAreaOfIsland(int[][] grid) {

        //convert grid to char char, why not?? (simple shit)
      int n = grid.length;
      int m = grid[0].length;
      boolean[][] vis = new boolean[n][m];

      char[][] gridd = new char[n][m];
      for(int i= 0; i < n; i++){
          for(int j= 0; j < m; j++){
              gridd[i][j] = grid[i][j] == 1 ? '1' : '0';
          }
      }

      int count = 0;
      //after this move through all
      for(int i= 0; i < n; i++){
          for(int j= 0; j < m; j++){
              if(gridd[i][j] == '1' && !vis[i][j]){
                  count = Math.max(count, dfsIslandss(i,j, gridd, vis, n, m));
              }
          }
      }

      return count;
  }
  
   public static int dfsIslandss(int x, int y, char[][] grid, boolean[][] vis, int n, int m){
      //move in four direction
      int[] dx = {1,-1,0,0};
      int[] dy = {0,0, 1,-1};

      //after this 
      int count = 0;
      vis[x][y] = true;
      for(int i = 0; i < 4; i++){
          int cx = x + dx[i];
          int cy = y + dy[i];

          if(cx >= 0 && cx < n && cy >= 0 && cy < m && !vis[cx][cy] && grid[cx][cy] == '1'){
              count += dfsIslandss(cx, cy, grid, vis, n, m);                
          }
      }

      return count + 1;
    }


    //Later on SIR METHOD -  MAX AREA OF ISLAND
    public int maxAreaOfIsland(int[][] grid) {
        int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int maxArea = 0;
        int r = grid.length;
        int c = grid[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    int cislandArea = islandDFS2(grid, i, j, dir);// current island area
                    maxArea = Math.max(maxArea, cislandArea);
                }
            }
        }
        return maxArea;
    }

    public static int islandDFS2(int[][] grid, int sr, int sc, int[][] dir) {
        grid[sr][sc] = 0;
        int count = 0;
        for (int[] d : dir) {
            int nr = sr + d[0];
            int nc = sc + d[1];
            if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1) {
                count += islandDFS2(grid, nr, nc, dir);
            }
        }
        return count + 1;
    }

    // -- ( new question ) --
    //COUNT SUB ISLAND MY METHOD -- FOR SURE!!! 
    //WORKS FOR SURE BOI!!!! 
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        //replace grid names
        int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int count = 0;
        int r = grid2.length;
        int c = grid2[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid2[i][j] == 1) {
                    if(islandDFS2(grid2, grid2, i, j, dir)) count++;
                }
            }
        }
        return count;
    }

    public static boolean islandDFS2(int[][] grid1, int[][] grid2, int sr, int sc, int[][] dir) {
        boolean flag = true;

        //IMPORTANT FUCKING POINT, DON'T FUCKING RETURN 
        //WAIT A SECOND 
        //Previous method was also correct, since i didn't updated grid2[sr][sc] = 0 before returning!!
        
        if(grid1[sr][sc] == 0) flag = false;  //don't return, otherwise it will cause problems!!
        grid2[sr][sc] = 0;

        for (int[] d : dir) {
            int nr = sr + d[0];
            int nc = sc + d[1];
            if (nr >= 0 && nc >= 0 && nr < grid2.length && nc < grid2[0].length && grid2[nr][nc] == 1) {
                boolean res = islandDFS2(grid2, grid1, nr, nc, dir);
                flag = flag && res;  //basic logic bruh!! (use bitmasking at times)
            }
        }
        return flag;
    }


    //SIR METHOD FOR SURETY
    //COUNT OF SUB ISLANDS BRUH!!!
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int ans = 0;
        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[0].length; j++) {
                if (grid2[i][j] == 1) {
                    boolean isSubIsland = subIslandDfs(grid1, grid2, i, j, dir);
                    if (isSubIsland) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    public static boolean subIslandDfs(int[][] grid1, int[][] grid2, int sr, int sc, int[][] dir) {
        boolean ans = true;
        if (grid2[sr][sc] > grid1[sr][sc]) {
            ans = false;
        }
        grid2[sr][sc] = 0; //i didn't mark it zero, simple no?
        for (int[] d : dir) {
            int nr = sr + d[0];
            int nc = sc + d[1];
            if (nr >= 0 && nc >= 0 && nr < grid1.length
                    && nc < grid1[0].length && grid2[nr][nc] == 1) {
                boolean res = subIslandDfs(grid1, grid2, nr, nc, dir);
                ans = (ans && res);
            }
        }
        return ans;
    }


    // -- ( new question ) -- ( simple )
    //dividing in set, simple stuff boi!! (using parent array)

    //BIPARTITE CHECK
    public static void typeOfCycle(int[][] graph) {
        boolean bipartite = isBipartite(graph);
        if (!bipartite) {
            System.out.println("false");
            return;
        }
        boolean cycle = false;// call for cycle in graph
        if (cycle) {
            System.out.println("Even length cycle");
        } else {
            System.out.println("Non cyclic");
        }
    }
    //you can never detect old length cycles in your life
    //Can be only detected using bipartiteness of your stuff!!! (important)

    //If even length of cycle is even in the graph
    //bipartie + check if cycle is present!!

    //Successfull code by sir!! (pretty dope shit for sure!!)
    public static boolean isBipartite(int[][] graph) {
        int n = graph.length; 
        int[] vis = new int[n];  //0 -> set 2 //1 -> set1
        Arrays.fill(vis, -1);
        boolean res = true;
        for(int i= 0; i < n; i++){
            if(vis[i] == -1){
                res = res && bipartiteDfs(graph, i ,vis, 0);
            }
        }
        return res;
    }

    public static boolean bipartiteDfs(int[][] graph, int src, int[] vis, int color){
        vis[src] = color;
        boolean res = true;
        for(int e : graph[src]){
            if(vis[e] == -1){
                res = res && bipartiteDfs(graph, e, vis, (color + 1)%2);
            }else if(vis[e] == vis[src]) return false;
        }

        return res;
    }

    //Jaate time mark krne vaala method kaise hoga???
    //socho sochio
    //Pretty easy to convert it into different form for sure!! (try it on your own brother)

    //Number of distinct islands!! - Using StringBuilder and stuff
    public int numDistinctIslands(int[][] grid) {
        int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        String[] sdir = { "D", "R", "U", "L" };
        HashSet<String> island = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder structure = getStructure(grid, i, j, dir, sdir);
                    island.add(structure.toString());
                }
            }
        }
        return island.size();
    }

    public static StringBuilder getStructure(int[][] grid, int sr, int sc, int[][] dir, String[] sdir) {
        grid[sr][sc] = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int nr = sr + dir[i][0];
            int nc = sc + dir[i][1];
            if (nr >= 0 && nc >= 0 && nr < grid.length
                    && nc < grid[0].length && grid[nr][nc] == 1) {
                StringBuilder recAns = getStructure(grid, nr, nc, dir, sdir);
                ans.append(sdir[i]);
                ans.append(recAns);
            }
        }
        ans.append("B"); //for marking backtracking and shit!! pretty cool for sure
        //mine was a bit different!! ( based on the number theory !!)
        return ans;
    }


    // -- ( new question -- ) -- 
    //ISLAND PERIMETER -- (Sir CODE)
    //Pretty dope for sureeee!! (check and compare your code with his!!) 
    //FUCKING MUCH FASTER BITCH!!! - 6ms only, and no recursion calls, pretty dope!
    public int islandPerimeter(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int ans = 0;
        int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    ans += 4;
                    for (int[] d : dir) {
                        int nr = i + d[0];
                        int nc = j + d[1];
                        if (nr >= 0 && nc >= 0 && nr < r && nc < c && grid[nr][nc] == 1) {
                            ans--;
                        }
                    }
                }
            }
        }
        return ans;
    }


    //SURROUND REGION (Smart method) - By sir for sure
    //just go through the boundary and find the one touching the boundary, fuck him bitches!!
    //WAY FUCKING FASTER SOLVE FOR SURE DUDE!!! (crazy fast speed for this question, i love it)
    public static void solve(char[][] board) {

        int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(i == 0 || j == 0 || i == board.length -1 || j == board[0].length - 1){
                    if(board[i][j] == 'O'){
                        markFlowing(board,i,j, dir);
                    }
                }
            }
        }

        //now just go through it and update it neatfly for sure bruh!!
        for(int i= 0; i < board.length; i++){
            for(int j= 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }

    }


    public static void markFlowing(char[][] board, int sr, int sc, int[][] dir){
        board[sr][sc] = '.';

        for (int[] d : dir) {
            int nr = sr + d[0];
            int nc = sc + d[1];
            if (nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length && board[nr][nc] == 'O') {
                markFlowing(board, nr, nc, dir);
            }
        }
    }


    //NUMBER OF ENCLAVES (sir method -- pretty similar question for sure!! - easy as fuck --)
    public static int numEnclaves(int[][] board) {

        int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(i == 0 || j == 0 || i == board.length -1 || j == board[0].length - 1){
                    if(board[i][j] == 1){
                        markFlowing(board,i,j, dir);
                    }
                }
            }
        }

        //now just go through it and update it neatfly for sure bruh!!
        int count = 0;
        for(int i= 0; i < board.length; i++){
            for(int j= 0; j < board[0].length; j++){
                if(board[i][j] == -1){
                    board[i][j] = 1;
                }else if(board[i][j] == 1) count++;
            }
        }
    
        return count;
    }


    public static void markFlowing(int[][] board, int sr, int sc, int[][] dir){
        board[sr][sc] = -1;

        for (int[] d : dir) {
            int nr = sr + d[0];
            int nc = sc + d[1];
            if (nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length && board[nr][nc] == 1) {
                markFlowing(board, nr, nc, dir);
            }
        }
    }

    //JOURNEY TO THE MOON!! ( pretty annoying for sure !)
    //Solved!! ( could be solved using inbuilt method of geting and calculating, rather than arrarylist)

    //WE CAN NEVER COUNT NUMBER OF CYCLES IN THE GRAPH!!! NO MATTER WHAT!!! (NOT POSSIBLE) - Important point

    //BFS mark at removal!! (pretty dope shit!) - jab removal tak mark ni!!
    public static void bfs(int src, int data) {
        Queue<Integer> que = new LinkedList<>();
        que.add(src);
        boolean[] vis = new boolean[n + 1];
        int datalevel = -1;
        int level = 0;
        boolean isCyclic = false;
        while (que.size() > 0) {
            int size = que.size();
            while (size-- > 0) {
                int top = que.poll();
                if (datalevel == -1 && top == data) {  //longest and shortest path level could be known from this
                    datalevel = level;
                }
                if (vis[top]) {  //again comes from other part!! (means one cycle exist for sure)
                    isCyclic = true;
                    continue;
                }
                vis[top] = true;
                for (Edge e : graph[top]) {
                    if (!vis[e.v]) {
                        que.add(e.v);
                    }
                }
            }
            level++; //keep leveling up boi!! (one level at a time kind of bfs!!!)
        }
        System.out.println(data + " is found at llevel: " + datalevel);
        System.out.println("CyclicGraph: " + isCyclic);
    }

    // BFS MARK AT ADDING
    //Each vertex comes single time!!! (pretty smart for sure!!)  -- pre addition optimisation
    //pretty smart if you ask me!! (definitely work way better than this world for sure)

    public static void bfsOpti(int src, int data) {  //cycle detection and normal level bfs
        Queue<Integer> que = new LinkedList<>();
        que.add(src);
        int[] vis = new int[n + 1];// visited of parent  //ye parent visited hai ya ni vaala logic
        Arrays.fill(vis, -1);
        int datalevel = -1;
        int level = 0;
        boolean isCyclic = false;
        vis[src] = src;
        while (que.size() > 0) {  //for making some levels!! this tech works pretty well
            int size = que.size();
            while (size-- > 0) {
                int top = que.poll();
                if (top == data) {
                    datalevel = level;
                }

                for (Edge e : graph[top]) {
                    if (vis[e.v] == -1) {
                        vis[e.v] = top;
                        que.add(e.v);
                    } else if (vis[top] != e.v) { //dono ka parent same ni!! mtlb different paths se aaya re tu!!
                        isCyclic = true;
                    }
                }
            }
            level++;
        }

        System.out.println(data + "is found at llevel: " + datalevel);
        System.out.println("CyclicGraph: " + isCyclic);
    }

    //HOMEWORK with bfs!!
    //gcc //bipartite - using bfs should be done!!

    //-- (new question) -- (figure it out boi)

    //Trying number of operations to make network connected using BFS!! (try it on your own)
    public static int makeConnectedBFS(int n, int[][] connections) {
        if(connections.length < n - 1){  //base condition for check!! (no worries)
            return -1;
        }

        //making a dope ass graph for this question boi!
        ArrayList<Integer>[] graph = new ArrayList[n];  //simple
        for(int i= 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        //now simply taking edge and stuff - if no weight it's simple for sure
        for(int[] rel : connections){
            int u = rel[0];
            int v = rel[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        int[] vis = new int[n];
        int count = 0;
        for(int i= 0; i < n; i++){
            if(vis[i] == 1) continue;
            Queue<Integer> que = new ArrayDeque<>();
            //pre addition
            que.add(i);
            vis[i] = 1;
            while(!que.isEmpty()){
                int curr = que.poll();
                for(int edge : graph[curr]){
                    if(vis[edge] == 0){
                        vis[edge] = 1;
                        que.add(edge);
                    }
                }
            }
            count++;
        }
        return count - 1;
    }


    // -- (new question) --
    //SIMULTANEOUS BFS bois!! (let's do it!!)
    //THIS FUCKER GOT ACCEPTED WITH BLAZING SPEED BOIS!!!!
    public int orangesRotting(int[][] grid) {
        
        //apply bfs on rotten oranges!!
         int rows = grid.length;
         int cols = grid[0].length;
         int healthy = 0;
     
         Queue<Pair> que = new ArrayDeque<>(); //pretty good
         for(int i= 0; i < rows; i++){
             for(int j= 0; j < cols; j++){
                 if(grid[i][j] == 1) healthy++;
                 if(grid[i][j] == 2){
                     que.add(new Pair(i,j));
                 }
             }
         }
         
         if(que.isEmpty() && healthy == 0){
             return 0;
         }
        
         int[][] dir = {{1,0}, {-1,0}, {0,1}, {0, -1}};
 
         int time = -1;
         while(!que.isEmpty()){
             
             //mark before start bois!
             //pop and remove
             int size = que.size();
             while(size --> 0){
                 Pair curr = que.poll();
                 int x = curr.a;
                 int y = curr.b;
 
                 for(int[] d : dir){
                     int cx = x + d[0];
                     int cy = y + d[1];
 
                     if(cx >= 0 && cy >= 0 && cx < rows && cy < cols && grid[cx][cy] == 1){
                         grid[cx][cy] = 2;
                         healthy--;
                         que.add(new Pair(cx, cy));
                     }
                 }
             }     
            time++;
        }
        return healthy == 0 ? time : -1;
    }
     
    public static class Pair{
        public int a;
        public int b;
 
        Pair(int a, int b){
            this.a = a;
            this.b = b;
        }
    }

    //ROTTEN ORANGES SIR CODE - (without using pair class, everything else is same as fuck)
    public int orangesRotting(int[][] grid) {
        int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        Queue<Integer> que = new LinkedList<>();
        int r = grid.length;
        int c = grid[0].length;
        int foc = 0;// fresh orange count
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 2) {
                    que.add(i * c + j);
                }
                if (grid[i][j] == 1) {
                    foc++;
                }
            }
        }
        if (foc == 0) {
            return 0;
        }
        int time = 0;
        while (que.size() > 0) {
            int size = que.size();
            while (size-- > 0) {
                int top = que.poll();
                int i = top / c;
                int j = top % c;
                for (int[] d : dir) {
                    int nr = i + d[0];
                    int nc = j + d[1];
                    if (nr >= 0 && nc >= 0 && nr < r && nc < c && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        que.add(nr * c + nc);
                        foc--;
                        if (foc == 0) {
                            return time + 1;
                        }
                    }
                }
            }
            time++;
        }
        return -1;
    }

    // -- (new question) -- 
    // 0 - 1 Matrix for sure
    //LOL MY CODE WORKS FOR SURE!!! (at 21 ms, with using extra Pair class)
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        
        int[][] ans = new int[rows][cols];

        Queue<Pair> que = new ArrayDeque<>(); //pretty good
        for(int i= 0; i < rows; i++){
            for(int j= 0; j < cols; j++){
                if(mat[i][j] == 0){
                    que.add(new Pair(i,j));
                }
            }
        }
        
        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0, -1}};
        int time = 0;
        while(!que.isEmpty()){
            //pop and remove
            int size = que.size();
            while(size --> 0){
                Pair curr = que.poll();
                int x = curr.a;
                int y = curr.b;
                ans[x][y] = time;

                for(int[] d : dir){
                    int cx = x + d[0];
                    int cy = y + d[1];

                    if(cx >= 0 && cy >= 0 && cx < rows && cy < cols && mat[cx][cy] == 1){
                        mat[cx][cy] = -1;
                        que.add(new Pair(cx, cy));
                    }
                }
            }     
           time++;
       }
        
        return ans;
    }

    //SIR CODE FOR THIS PROBLEM 
    //EXACTLY SAME RUN TIME AS MINE BOIS!!! -- FUCK YEAHHHH!!
    public int[][] updateMatrix(int[][] mat) {
        int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int r = mat.length;
        int c = mat[0].length;
        int[][] ans = new int[r][c];
        Queue<Integer> que = new LinkedList<>();
        int one = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (mat[i][j] == 0) {
                    que.add(i * c + j);
                } else {
                    one++;
                }
            }
        }

        int level = 1;
        while (que.size() > 0) {
            int size = que.size();
            while (size-- > 0) {
                int top = que.poll();
                int i = top / c;
                int j = top % c;
                for (int[] d : dir) {
                    int nr = i + d[0];
                    int nc = j + d[1];
                    if (nr >= 0 && nc >= 0 && nr < r && nc < c && mat[nr][nc] == 1) {
                        ans[nr][nc] = level;
                        mat[nr][nc] = 0;
                        que.add(nr * c + nc);
                        one--;
                        if (one == 0) {
                            return ans;
                        }
                    }
                }
            }
            level++;
        }
        return ans;
    }


    // -- (new question) --

    //ONLY SIR CODE, NOT AVAILABLE ANYWHERE ELSE BROTHER!
    // GET FOOD
    // SGNLE SOURCE

    public int getFood(char[][] grid) {
        int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int r = grid.length;
        int c = grid[0].length;
        int level = 1;
        Queue<Integer> que = new LinkedList<>();
        a: for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '*') {
                    que.add(i * c + j);
                    grid[i][j] = 'X';
                    break a;
                }
            }
        }

        while (que.size() > 0) {
            int size = que.size();
            while (size-- > 0) {
                int top = que.poll();
                int i = top / c;
                int j = top % c;
                for (int[] d : dir) {
                    int nr = i + d[0];
                    int nc = j + d[1];
                    if (nr >= 0 && nc >= 0 && nr < r && nc < c && grid[nr][nc] != 'X') {
                        if (grid[nr][nc] == '#') {
                            return level;
                        }
                        que.add(nr * c + nc);
                        grid[nr][nc] = 'X';

                    }
                }
            }
            level++;
        }

        return -1;
    }

    // SIMULTANEOUS BFS

    public int getFood(char[][] grid) {
        int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int r = grid.length;
        int c = grid[0].length;
        int level = 1;
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '#') {
                    que.add(i * c + j);
                    grid[i][j] = 'X';
                }
            }
        }

        while (que.size() > 0) {
            int size = que.size();
            while (size-- > 0) {
                int top = que.poll();
                int i = top / c;
                int j = top % c;
                for (int[] d : dir) {
                    int nr = i + d[0];
                    int nc = j + d[1];
                    if (nr >= 0 && nc >= 0 && nr < r && nc < c && grid[nr][nc] != 'X') {
                        if (grid[nr][nc] == '*') {
                            return level;
                        }
                        que.add(nr * c + nc);
                        grid[nr][nc] = 'X';

                    }
                }
            }
            level++;
        }

        return -1;
    }


    //-- (new question) -- 

    //Walls and gates -- let's try this one out for our clarity no matter what!! (let's solve this bad boi!)
    //THIS CODE RUN FLAWLESSLY -- written by me!! hehehehe
    public void wallsAndGates(int[][] rooms) {
        //go to each gate, add them in queue, then simply keep moving on   
        int rows = rooms.length;
        int cols = rooms[0].length;
        
        Queue<Pair> que = new ArrayDeque<>(); //pretty good
        for(int i= 0; i < rows; i++){
            for(int j= 0; j < cols; j++){
                if(rooms[i][j] == 0){
                    que.add(new Pair(i,j));
                }
            }
        }
        
        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0, -1}};
        int time = 0;
        while(!que.isEmpty()){
            //pop and remove
            int size = que.size();
            while(size --> 0){
                Pair curr = que.poll();
                int x = curr.a;
                int y = curr.b;
                
                for(int[] d : dir){
                    int cx = x + d[0];
                    int cy = y + d[1];

                    if(cx >= 0 && cy >= 0 && cx < rows && cy < cols && rooms[cx][cy] > rooms[x][y] && rooms[cx][cy] != -1){
                        rooms[cx][cy] = time + 1;
                        que.add(new Pair(cx, cy));
                    }
                }
            }     
           time++;
       }
        
        return;

    }


    //Shortest Path in binary matrix solve kro!! 
    //SOLVED BY ME -- took some time in debugging!! Should have been more careful!!
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        if(grid[0][0] == 1) return -1;
        if(grid[rows - 1][cols - 1] == 1) return -1;

        Queue<Integer> que = new ArrayDeque<>();
        que.add(0);

        //pre mark no?
        grid[0][0] = 1;
        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0, -1}, {1,-1}, {-1,1}, {1,1}, {-1, -1}}; //syrup pike so jao bas

        int times = 0;
        while(!que.isEmpty()){
            int size = que.size();
            while(size --> 0){
                int top = que.poll();
                int r = top/cols;
                int c = top%cols;
    
                if(r == (rows - 1) && c == (cols - 1)){
                    return times + 1;  //update
                }

                for(int[] d : dir){
                    int cx = r + d[0];
                    int cy = c + d[1];

                    if(cx >= 0 && cy >= 0 && cx < rows && cy < cols && grid[cx][cy] == 0){
                        grid[cx][cy] = 1;
                        que.add(cx * cols + cy);
                    }
                }
            }
            times++;
        }

        return -1;
    }


    //SIR VERSION OF CODE!!! for the above problem
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, -1 }, { -1, 1 }, { 1, 1 }, { -1, -1 } };
        int r = grid.length;
        int c = grid[0].length;
        if (r == 1 && c == 1 && grid[0][0] == 0) {
            return 1;
        }
        if (grid[0][0] == 1 || grid[r - 1][c - 1] == 1) {
            return -1;
        }
        int level = 1;
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        grid[0][0] = 1;
        while (que.size() > 0) {
            int size = que.size();
            while (size-- > 0) {
                int top = que.poll();
                int i = top / c;
                int j = top % c;
                for (int[] d : dir) {
                    int nr = i + d[0];
                    int nc = j + d[1];
                    if (nr >= 0 && nc >= 0 && nr < r && nc < c && grid[nr][nc] == 0) {
                        if (nr == r - 1 && nc == c - 1) {
                            return level + 1;
                        }
                        grid[nr][nc] = 1;
                        que.add(nr * c + nc);
                    }
                }
            }
            level++;
        }
        return -1;
    }

    // -- (new question) -- 

    //Bus Route Question!!!!
    //Code by me!! (first) -- run at 114ms, present in lecture - 4
   // BUS ROUTES

    public int numBusesToDestination(int[][] routes, int src, int tar) {
        if (src == tar) {
            return 0;
        }
        HashMap<Integer, List<Integer>> map = new HashMap<>();// stand vs bus no
        int max = 0;
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                int stand = routes[i][j];
                int bus = i;
                if (!map.containsKey(stand)) {
                    map.put(stand, new ArrayList<>());
                }
                map.get(stand).add(bus);
                max = Math.max(max, stand);
            }
        }

        Queue<Integer> que = new LinkedList<>();
        boolean[] busvis = new boolean[routes.length];
        boolean[] standvis = new boolean[max + 1];
        que.add(src);
        standvis[src] = true;
        int level = 1;
        while (que.size() > 0) {
            int size = que.size();
            while (size-- > 0) {
                int currstand = que.poll();
                List<Integer> currstandbuses = map.get(currstand);
                for (int cbusboard : currstandbuses) {
                    if (!busvis[cbusboard]) {
                        for (int nextstop : routes[cbusboard]) {
                            if (!standvis[nextstop]) {
                                if (nextstop == tar) {
                                    return level;
                                }
                                que.add(nextstop);
                                busvis[cbusboard] = true;
                                standvis[nextstop] = true;
                            }
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }
}


//CHECK EDGE WITH QUERY - UNDIRECTED GRAPH - path availble or not check
public static boolean[] checkEdgeWihQuery(int[][] query) {
    boolean[] vis = new boolean[n + 1];
    HashMap<Integer, Set<Integer>> map = new HashMap<>();
    HashSet<Integer> compo = new HashSet<>();
    for (int i = 1; i <= n; i++) {
        if (!vis[i]) {
            compo = new HashSet<>();
            dfsQuery(i, vis, compo);
            System.out.println(compo);
            for (int k : compo) {
                map.put(k, compo);
            }
        }
    }
    boolean[] ans = new boolean[query.length];
    for (int i = 0; i < query.length; i++) {
        int u = query[i][0];
        int v = query[i][1];
        if (map.containsKey(u) && map.get(u).contains(v)) {
            ans[i] = true;
        }
    }
    for (boolean ele : ans) {
        System.out.print(ele + " ");
    }
    return ans;
}

