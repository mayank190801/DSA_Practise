import java.util.*;

// import jdk.tools.jlink.internal.SymLinkResourcePoolEntry;

import java.io.*;
import java.lang.reflect.Array;

public class third{

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

        int nodes = sc.nextInt();
        int edges = sc.nextInt();

        int[] friends = new int[nodes+1];
        int[] less = new int[nodes+1];

        Map<Integer, Integer> fri = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        Set<Integer> good = new HashSet<>();

        for(int i = 1 ; i <= nodes ; i++){
            good.add(i);
        }

        int[][] arr = new int[edges][2];

        for(int i = 0 ; i < edges ; i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        int queries = sc.nextInt();
        //i should have querries at one place idiot
        int[][] que = new int[queries][3];
        int b ,c ;
        for(int i = 0  ; i < queries ; i++){
            int a = sc.nextInt();
            if( a == 3){
                que[i][0] = 3; 
            }else{
                b = sc.nextInt();
                c = sc.nextInt();
                que[i][0] = a;
                que[i][1] = b;
                que[i][2] = c;
            }
        }
        
        for(int i = 0 ; i < edges; i++){
            int a = arr[i][0];
            b = arr[i][1];

            //now let's think
            fri.putIfAbsent(a, 0);
            fri.putIfAbsent(b, 0);

            fri.put(a, fri.get(a) + 1);
            fri.put(b, fri.get(b) + 1);

            c = Math.max(a, b);
            int d = Math.min(a, b);

            count.putIfAbsent(c, 0);
            count.putIfAbsent(d, 0);
            count.put(c, count.get(c) + 1);

            if(fri.get(d) == count.get(d)){
                good.add(d);
            }else{
                if(good.contains(d)){
                    good.remove(d);
                }
            }

            if(fri.get(c) == count.get(c)){
                good.add(c);
            }else{
                if(good.contains(c)){
                    good.remove(c);
                }
            }
            

        }

        //a set is important to keep the track of all the utha patang stuff
        //rememeber that

        for(int i = 0 ; i < queries ; i++){
            int x = que[i][0];

            if(x == 3){
                // out.println(good);
                out.println(good.size());

            }else if(x == 1){
                // out.println("did i happened");
                int a = que[i][1];
                b = que[i][2];
                
                //now let's think
                fri.putIfAbsent(a, 0);
                fri.putIfAbsent(b, 0);

                fri.put(a, fri.get(a) + 1);
                fri.put(b, fri.get(b) + 1);

                c = Math.max(a, b);
                int d = Math.min(a, b);

                count.putIfAbsent(c, 0);
                count.putIfAbsent(d, 0);
                count.put(c, count.get(c) + 1);

                if(fri.get(d) == count.get(d)){
                    good.add(d);
                }else{
                    if(good.contains(d)){
                        good.remove(d);
                    }
                }
               
                if(fri.get(c) == count.get(c)){
                    good.add(c);
                }else{
                    if(good.contains(c)){
                        good.remove(c);
                    }
                }
                
            }else{

                int a = que[i][1];
                b = que[i][2];

                //now let's think
                fri.putIfAbsent(a, 0);
                fri.putIfAbsent(b, 0);

                fri.put(a, fri.get(a) - 1);
                fri.put(b, fri.get(b) - 1);

                c = Math.max(a, b);
                int d = Math.min(a, b);

                count.putIfAbsent(c, 0);
                count.putIfAbsent(d, 0);
                count.put(c, count.get(c) - 1);

                if(fri.get(d) == count.get(d)){
                    good.add(d);
                }else{
                    if(good.contains(d)){
                        good.remove(d);
                    }
                }
               
                if(fri.get(c) == count.get(c)){
                    good.add(c);
                }else{
                    if(good.contains(c)){
                        good.remove(c);
                    }
                }
              
            }


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