import java.util.*;
import java.io.*;

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

        int test = sc.nextInt();

        while(test -- > 0){

            int n = sc.nextInt();
            int[] first = new int[n];
            int[] second = new int[n];

            int totalF = 0;
            int totalS = 0;
            for(int i = 0 ; i < n ; i++){
                first[i] = sc.nextInt();
                totalF += first[i];
            }

            for(int i = 0 ; i < n ; i++){
                second[i] = sc.nextInt();
                totalS += second[i];
            }

            int k  = n - n/4;
            Arrays.sort(first);
            Arrays.sort(second);

            PriorityQueue<Integer> queF = new PriorityQueue<>();
            PriorityQueue<Integer> queS = new PriorityQueue<>();

            for(int i = 0; i < n ; i++){
                queF.add(first[i]);
                queS.add(second[i]);
            }

            

            while(k < queF.size()){
                totalF -= queF.poll();
                totalS -= queS.poll();
            }

           


            // out.println(queF);
            // out.println(queS);
            // int firstSum = 0;
            // int secondSum =0;

            // // int index = n-1;
            // // int r = k;

            // while(r > 0){
            //     firstSum += first[index--];
            //     r--;
            // }
            // index = n-1;
            // r = k;
            // while(r > 0){
            //     secondSum += second[index--];
            //     r--;
            // }

            int additional = 0;
            // int firstPointer = n - k;
            // int secondPointer = n - k;

            while(totalF <totalS){
                n++;
                k = n - n/4; 

                totalF += 100;
                queF.add(100);
                queS.add(0);

                while(k < queF.size()){
                    totalF -= queF.poll();
                    totalS -= queS.poll();
                }

                additional++;
            }

            out.println(queF);
            out.println(queS);

            out.println(additional);
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