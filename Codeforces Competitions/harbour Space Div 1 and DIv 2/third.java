import java.util.*;
import java.io.*;

public class third{

    public static int solve(char[] a){

        int finalAnswer = recurSolve(a, 0, 0,5,5,1);
        return finalAnswer;
    }

    public static int recurSolve(char[] a, int first, int second, int firstLeft, int secondLeft, int kick){

        // System.out.println(first + " " + second + " " + firstLeft + " " + secondLeft + " " + kick );
        //simple as that
        if(kick == 11){
            return 10;
        }
        //base condition simple as that
        if(first > second + secondLeft){
            return kick-1;
        }

        if(second > first + firstLeft){
            return kick-1;
        }

        if(a[kick-1] == '?'){
            //both direction bhejenge
            if(kick%2 == 1){
                int x = recurSolve(a,first + 1, second, firstLeft-1, secondLeft, kick +1);
                int y = recurSolve(a,first, second, firstLeft-1, secondLeft, kick +1);
                return Math.min(x,y);
            }else{
                int x = recurSolve(a,first, second+1, firstLeft, secondLeft-1, kick +1);
                int y = recurSolve(a,first, second, firstLeft, secondLeft-1, kick +1);
                return Math.min(x,y);
            }
        }

        if(kick%2 == 1){
            if(a[kick-1] == '1'){
                return recurSolve(a,first + 1, second, firstLeft-1, secondLeft, kick +1);
            }else{
                return  recurSolve(a,first, second, firstLeft-1, secondLeft, kick +1);
            }
        }else{
            if(a[kick-1] == '1'){
                return recurSolve(a,first, second+1, firstLeft, secondLeft-1, kick +1);
            }else{
                return recurSolve(a,first, second, firstLeft, secondLeft-1, kick +1);
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

        int test = sc.nextInt();

        while(test-- > 0){
            char[] a = sc.nextLine().toCharArray();

            int answer = solve(a);
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
    
    //Pair with int int 
    public static class Pair{

        public int a;
        public int b;

        Pair(int a , int b){
            this.a = a;
            this.b = b;
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