import java.util.*;
import java.io.*;

public class first{

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

        int test = sc.nextInt();

        while(test -- > 0){

            int n = sc.nextInt();
            int chord = sc.nextInt();

            Map<Integer, Integer> connect = new HashMap<>();
            for(int i = 0 ; i < chord ; i++){
                int f = sc.nextInt();
                int s = sc.nextInt();

                connect.put(f, s);
                connect.put(s, f);
            }

            //now add all the unadded keys
            //find the middle and work it through
            int[] remaining = new int[(n-chord)*2];
            int index = 0;
            for(int i  = 1 ; i <= 2 * n ; i++){
                if(!connect.containsKey(i)){
                    remaining[index++] = i;
                }
            }

            Arrays.sort(remaining);
            // System.out.println(Arrays.toString(remaining));
            int middle = n-chord;
            for(int i = 0 ; i < n-chord ; i++){
                connect.put(remaining[i], remaining[middle]);
                connect.put(remaining[middle], remaining[i]);
                middle++;
            }

            //so now all the connections are perfect i just have to count now
            //simple as that shouldn't be too hard
            Set<Integer> counted= new HashSet<>();

            int answer = 0;
            for(int i = 1 ; i <= 2 * n ; i++){
                //first pair pakdo and calculate kar daalo, simple as that
                int first = i;
                int second = connect.get(i);
                for(int j = first + 1 ; j < second; j++){
                    if(!counted.contains(i)){
                        if(connect.get(j) > second){
                            answer++;
                        }
                    }
                }
                counted.add(first);
                counted.add(second);
            }
            out.println(answer);

        }

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