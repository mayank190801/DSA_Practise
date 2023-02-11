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

        char[] alpha = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        while(test -- > 0){

            String s = sc.nextLine();
            char[] str = s.toCharArray();
            int n = s.length();

            int l , r;
            l = 0;
            r = 0;

            boolean flag =false;
            for(int i = 0 ; i < n ; i++){
                if(str[i] == 'a'){
                    l = i;
                    r = i;
                    flag = true;
                    break;
                }
            }

            if(!flag){
                out.println("NO");
                continue;
            }

            boolean correct = true;
            for(int i = 0 ; i < n ; i++){

                if(i == 0){
                    l--;
                    r++;
                    continue;
                }

                if(l >= 0 || r < n){
                    if(l >= 0 && r < n){
                        if(str[l] == alpha[i]){
                            l--;
                            continue;
                            
                        }else if(str[r] == alpha[i]){
                            r++;
                            continue;
                        }else{
                            correct = false;
                            break;
                        } 
                    }

                    if(l >= 0){
                        if(str[l] == alpha[i]){
                            l--;
                        }else{
                            correct = false;
                            break;
                        }
                    }

                    if( r < n){
                        if(str[r] == alpha[i]){
                            r++;
                        }else{
                            correct = false;
                            break;
                        }
                    }

                }else{
                    correct = false;
                    break;
                }
            }

            if(correct) out.println("YES"); else out.println("NO");
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