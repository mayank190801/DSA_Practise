import java.util.*;

// import jdk.tools.jlink.internal.SymLinkResourcePoolEntry;

import java.io.*;

public class fifth{

    public static class Graph{

        public int V;
        public ArrayList<ArrayList<Integer>> edges;

        Graph(int V){
            this.V = V;
            edges = new ArrayList<>(V+1);
            for(int i = 0; i <= V ;i++){
                edges.add(new ArrayList<>());
            }
        }

        public void addEdge(int from, int to){
            edges.get(from).add(to);
            edges.get(to).add(from);
        }

        public int solve(){

            Queue<Pair> que = new ArrayDeque<>();
            //simple as that
            que.add(new Pair(0, 0, 1));
            int[] visited = new int[V+1];
            visited[0] = 1;
            int[] distance = new int[V+1];
            distance[0] = 0;

            while(!que.isEmpty()){

                // System.out.println(1);
                Pair current = que.poll();
                int f = current.curr;
                int s = current.dist;
                int l = current.odd;

                distance[f] = s;
                
                for(int edge : edges.get(f)){
                    if(visited[edge] != 1){
                        visited[edge] = 1;
                        if(edge%2 == 1 && l == 0){
                            continue;
                        }else{
                            if(edge%2 == 1){
                                que.add(new Pair(edge, s + 1, 0));
                            }else{
                                que.add(new Pair(edge, s+ 1, l));
                            }
                        }
                    } 
                }

            }

            int max = 0;
            for(int i = 0 ; i < distance.length ; i++){
                max = Integer.max(max, distance[i]);
            }

            // System.out.println(Arrays.toString(distance));
            return max+1;

        }

    }

    public static class Pair{

        public int curr;
        public int dist;
        public int odd;

        Pair(int curr, int dist, int odd){
            this.curr = curr;
            this.dist = dist;
            this.odd = odd;
        }

    }
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        
        // Start writing your solution here. -------------------------------------
        /*
        int n      = sc.nextInt();        // read input as integer
        long k     = sc.nextLong();       // read input as long
        double d   = sc.nextDouble();     // read input as double
        char c = sc.next().charAt(0);     // read input as char
        String str = sc.next();           // read input as String
        String s   = sc.nextLine();       // read whole line as String
        out.println(result);              // print via PrintWriter
        */
        //------------------------------------------------------------------

        int[] T = {0,0,0,1,6,1,0,0};

        int n = T.length;
        Graph g = new Graph(n+1);

        for(int i = 0 ; i < n ;i++){
            if(T[i] != i){
                g.addEdge(T[i], i);
            }
        }

        int answer = g.solve();
        System.out.println(answer);

        //now we simply have the main tree
        //now use Dijkstra simply on this 


        //------------------------------------------------------------------
        
        // Stop writing your solution here. -------------------------------------
        out.close();
    }



    //Shortcut function
    public static long lcm(long a , long b){
        return a * (b/gcd(a,b));
    }

    //let's make one for calculating lcm basically
    public static int lcm(int a , int b){
        return (a * b)/gcd(a,b);
    }

    //int version for gcd
    public static int gcd(int a, int b){
        if(b == 0)
            return a;
            
        return gcd(b , a%b);
    }

    //long version for gcd
    public static long gcd(long a, long b){
        if(b == 0)
            return a;

        return gcd(b , a%b);
    }

    //swapping two elements in an array
    public static void swap(int[] arr, int left , int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    //reversing an array
    public static void reverse(int[] arr){
        int left = 0;
        int right = arr.length-1;

        while(left <= right){
            swap(arr, left,right);
            left++;
            right--;
        }
    }

     
    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;
      
    //-----------MyScanner class for faster input----------
    public static class MyScanner {
      BufferedReader br;
      StringTokenizer st;
 
        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
    
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
    
        int nextInt() {
            return Integer.parseInt(next());
        }
    
        long nextLong() {
            return Long.parseLong(next());
        }
    
        double nextDouble() {
            return Double.parseDouble(next());
        }
    
        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }
   //--------------------------------------------------------
}