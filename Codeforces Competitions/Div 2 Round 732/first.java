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

            int[] a  = new int[n];
            int[] b = new int[n];

            for(int i = 0 ; i < n ; i++){
                a[i] = sc.nextInt();
            }

            for(int i = 0 ; i < n ; i++){
                b[i] = sc.nextInt();
            }

            int sum = 0;
            for(int i = 0 ; i < n ; i++){
                sum += a[i] - b[i];
            }

            if(sum != 0){
                out.println(-1);
                continue;
            }

            ArrayList<Integer> pos = new ArrayList<>();
            ArrayList<Integer> neg = new ArrayList<>();

            for(int i = 0 ; i < n ; i++){
                if(a[i] - b[i] > 0){
                    for(int j  = 0 ; j < Math.abs(a[i]-b[i]); j++){
                        neg.add(i+1);
                    }
                }else if(a[i] -b[i] < 0){
                    for(int j  = 0 ; j < Math.abs(a[i]-b[i]); j++){
                        pos.add(i+1);
                    }
                }else{

                }
            }

            out.println(pos.size());
            for(int i = 0 ;i < pos.size() ; i++){
                out.println(neg.get(i) + " " + pos.get(i));
            }

          
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