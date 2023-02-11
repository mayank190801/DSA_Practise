import java.util.*;
import java.io.*;

public class dijkstra{

    public class Graph{

        private int V;
        private List<List<Pair>> edges;

        Graph(int V){
            this.V = V;
            //simply add pair this time, cause we need two information
            //just believe in god and keep working hard
            edges = new ArrayList<>(V+1);
            for(int i = 0 ; i < V ; i++){
                edges.add(new ArrayList<>());
            }
        }

        public void addEdge(int from, int to , int weight){
            //i can use string and all, but no necessary now
            edges.get(from).add(new Pair(to, weight));
            edges.get(to).add(new Pair(from, weight));
        }

        public void dijkstra(int src){
            //from source to all other nodes we have to find
            Set<Integer> visited = new HashSet<>();
            int[] dist = new int[V+1];

            Arrays.fill(dist, Integer.MAX_VALUE);
            //never an issue
            SortedSet<Pair> set = new TreeSet<>(new Comparator<Pair>(){
                @Override
                public int compare(Pair one, Pair two){
                    return Integer.compare(one.b, two.b);
                }
            });

            set.add(new Pair(src, 0));
            dist[src]= 0;
            visited.add(src);

            //now we willl loop through all the edges
            while(!set.isEmpty()){
                Pair curr = set.first();
                set.remove(set.first());

                int nodeCurr = curr.a;
                int distCurr = curr.b;

                for(Pair edge : edges.get(nodeCurr)){

                    int nodeEdge = edge.a;
                    int distEdge = edge.b;

                    if(!visited.contains(nodeEdge)){
                        //then work on this section
                        if( distCurr + distEdge < dist[nodeEdge]){
                            
                            if(set.contains(edge)){
                                set.remove(edge);
                            }
                            
                            dist[nodeEdge] = distCurr + distEdge;
                            set.add(new Pair(nodeEdge, dist[nodeEdge]));
                        }

                    }

                }

                System.out.println(Arrays.toString(dist));

            }

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


        //now we will be implementing this bullshit algo
        //seriusly it confused me for a long long long long long time


        Graph g = new Graph(6);













        //------------------------------------------------------------------
        
        // Stop writing your solution here. -------------------------------------
        out.close();
    }

    //-------------------------------------------------------------------
    //-------------------------------------------------------------------
    //-------------------------------------------------------------------
    //-------------------------------------------------------------------
    //-------------------------------------------------------------------

    //Sorted Set Implementation
    //Simple two lines are enough hehe
    // SortedSet<Integer> set = new TreeSet<>();
    // System.out.println(set.first());

    //for calculating binomialCoeff
    public static int binomialCoeff(int n, int k)
    {
        int C[] = new int[k + 1];
        // nC0 is 1
        C[0] = 1;
        for (int i = 1; i <= n; i++) {
            // Compute next row of pascal
            // triangle using the previous row
            for (int j = Math.min(i, k); j > 0; j--)
                C[j] = C[j] + C[j - 1];
        }
        return C[k];
    }

    //Pair with int int 
    public static class Pair{

        public int a;
        public int b;

        Pair(int a , int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString(){
            return a + " -> " + b; 
        }
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