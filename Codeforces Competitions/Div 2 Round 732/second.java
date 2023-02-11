import java.util.*;

// import jdk.tools.jlink.internal.SymLinkResourcePoolEntry;

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
        char[] alpha = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        while(test -- > 0){

            int n = sc.nextInt();
            int m = sc.nextInt();

            int[][] answer = new int[m][26];

            char[][] arr = new char[n][m];
            char[][] jumb = new char[n-1][m];

            for(int i = 0; i < n ; i++){
                arr[i] = sc.nextLine().toCharArray();
            }

            for(int i = 0; i < n-1 ; i++){
                jumb[i] = sc.nextLine().toCharArray();
            }

            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < m ; j++){
                    answer[j][arr[i][j] - 'a']++;
                }
            }

            for(int i = 0 ; i < n-1 ; i++){
                for(int j = 0 ; j < m ; j++){
                    answer[j][jumb[i][j] - 'a']--;
                }
            }

            StringBuilder sb = new StringBuilder();


            for(int i = 0 ; i < m ;  i++){
                for(int j = 0 ; j< 26 ; j++ ){
                    if(answer[i][j] != 0){
                        sb.append(alpha[j]);
                    }
                }
            }

            String random = sb.toString();

            out.println(random);
            
            // System.out.println(Arrays.deepToString(arr));
            // System.out.println(Arrays.deepToString(answer));

        }

        //------------------------------------------------------------------
        
        // Stop writing your solution here. -------------------------------------
        out.flush();
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