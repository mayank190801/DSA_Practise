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
        while(test --> 0){

            int ax, ay, bx, by, fx, fy;
            ax =sc.nextInt();
            ay =sc.nextInt();
            bx =sc.nextInt();
            by =sc.nextInt();
            fx =sc.nextInt();
            fy =sc.nextInt();
            
            if(ax == bx && by == ay )
            {
                out.println(0);
                continue;
            }

            if(ax == bx){
                if(fx == ax){
                    if(fy < ay && fy > by || fy < by && fy > ay){
                        int answer = Math.abs(ax - bx) + Math.abs(ay-by) + 2;
                        out.println(answer);
                        continue;
                    }
                    if(fx < ax && fx > bx || fx < bx && fx > ax){
                        int answer = Math.abs(ax - bx) + Math.abs(ay-by) + 2;
                        out.println(answer);
                        continue;
                    }
                }
            }

            if(ay == by){
                if(fy == ay){
                    if(fx < ax && fx > bx || fx < bx && fx > ax){
                        int answer = Math.abs(ax - bx) + Math.abs(ay-by) + 2;
                        out.println(answer);
                        continue;
                    }
                }
            }

            int answer= Math.abs(ax - bx) + Math.abs(ay-by);
            out.println(answer);

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