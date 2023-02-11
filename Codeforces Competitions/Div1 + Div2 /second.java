import java.util.*;
import java.io.*;

public class second{

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
            int h = sc.nextInt();
            int w = sc.nextInt();

            int[][] t = new int[h][w];
            t[0][0] = 1;
            t[0][w-1] = 1;
            t[h-1][0] = 1;
            t[h-1][w-1] = 1;

            for(int i = 2 ; i < w ; i+= 2){
                if(i+1 == w-1){
                    continue;
                }
                t[0][i] = 1;
            }

            for(int i = 2 ; i < w ; i+= 2){
                if(i+1 == w-1){
                    continue;
                }
                t[h-1][i] = 1;
            }

            for(int i = 2 ; i < h ; i+= 2){
                if(i+1 == h-1){
                    continue;
                }
                t[i][0] = 1;
            }

            for(int i = 2 ; i < h ; i+= 2){
                if(i+1 == h-1){
                    continue;
                }
                t[i][w-1] = 1;
            }

            for(int i = 0 ; i < h ; i++){
                for(int j = 0 ; j < w ; j++){
                    System.out.print(t[i][j]);
                }
                System.out.print("\n");
            }

            System.out.println();
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