import java.util.*;
import java.io.*;

public class sixth{

    public static int gcd(int a , int b){
        if(b==0){
            return a;
        }
        return gcd(b, a%b);
    }

    public static boolean allEqual(int[]arr){
        // System.out.println(Arrays.toString(arr));
        for(int i = 0 ; i < arr.length-1 ; i++){
            if(arr[i] != arr[i+1]){
                return false;
            }
        }
        return true;
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


        int test =sc.nextInt();
        while(test -- > 0){

            int n = sc.nextInt();
            int[] arr = new int[n];

            for(int i = 0 ; i < n ; i++){
                arr[i] = sc.nextInt();
            }

            if(allEqual(arr)){
                out.println(0);
                continue;
            }

            int count = 0;
            while(true){

                int x = arr[0];
                boolean flag = true;
                for(int i = 0; i < n-1 ; i++){
                    arr[i] = gcd(arr[i], arr[i+1]);
                    if(i != 0){
                        if(arr[i] != arr[i-1]){
                            flag = false;
                        }
                    }
                }
                arr[n-1] = gcd(x, arr[n-1]);
                if(arr[n-1] != arr[n-1-1]){
                    flag = false;
                }
                count++;

                // System.out.println(Arrays.toString(arr));
                if(flag)
                    break;
            }

            out.println(count);
        }

        //------------------------------------------------------------------
        
        // Stop writing your solution here. -------------------------------------
        out.close();
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