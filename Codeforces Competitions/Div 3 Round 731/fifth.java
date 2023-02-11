import java.util.*;
import java.io.*;

public class fifth{


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

        int test= sc.nextInt();
        while(test -- > 0){

            int n = sc.nextInt();
            int k = sc.nextInt();

            long[] s = new long[n];
            int[] t = new int[k];

            for(int i = 0 ; i < k ; i++){
                t[i] = sc.nextInt();
            }

            for(int i = 0; i < k ; i++){
                s[t[i]-1] = sc.nextLong();
            }

            long[] ans = new long[n];
            long currMin = 0;
            for(int i = 0 ; i < n ; i++ ){

                if(s[i] == 0 && currMin == 0){
                    continue;
                }

                if(s[i] != 0 && currMin == 0){
                    currMin = s[i];
                }

                if(s[i] != 0){
                    if(s[i] <= currMin){
                        ans[i] = s[i];
                        currMin =s[i];
                    }else{
                        ans[i] = currMin + 1;  
                        currMin++;
                    }
                }else{
                    ans[i] = currMin + 1;
                    currMin++;
                }
            }

            currMin = 0;
            long[] ansdual = new long[n];
            for(int i = n-1 ; i >= 0 ; i-- ){

                if(s[i] == 0 && currMin == 0){
                    continue;
                }
                if(currMin == 0 && s[i] != 0){
                    currMin = s[i];
                }

                if(s[i] != 0){
                    if(s[i] <= currMin){
                        ansdual[i] = s[i];
                        currMin =s[i];
                    }else{
                        ansdual[i] = currMin + 1;  
                        currMin++;
                    }
                }else{
                    ansdual[i] = currMin + 1;
                    currMin++;
                }
            }

            // out.println(Arrays.toString(ansdual));

            for(int i = 0 ; i < n ; i++){
                if(ans[i] == 0 && ansdual[i] == 0){
                    ans[i] = 0;
                }else if(ans[i] != 0 && ansdual[i] == 0){
                    ans[i] = ans[i];
                }else if(ans[i] == 0 && ansdual[i] != 0){
                    ans[i] = ansdual[i];
                }else{ 
                    ans[i]= Math.min(ans[i], ansdual[i]);
                }
            }
            
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < n ; i++){
                if(i == n -1){
                    sb.append(ans[i]);
                }else{
                    sb.append(ans[i] + " ");
                }
            }

            String random = sb.toString();
            out.println(random);

            
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