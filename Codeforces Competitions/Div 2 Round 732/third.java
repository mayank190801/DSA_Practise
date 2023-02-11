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
            // int[] arr = new int[n];
            int[] temp = new int[n];

            int[][] arr = new int[n][2];

            for(int i = 0 ; i < n ; i++){
                arr[i][0] = sc.nextInt();
                arr[i][1] = i;
            }

            Arrays.sort(arr, new Comparator<int[]>(){
                @Override
                public int compare(int[] first, int[] second){
                    return Integer.compare(first[0], second[0]);
                }
            });

            Map<Integer,Integer> count = new HashMap<>();

            boolean flag = true;
            for(int i = 0 ; i < n ; i++){
            
                if(Math.abs(arr[i][1] - i) % 2 != 0){
                    count.putIfAbsent(arr[i][0], 0);
                    count.put(arr[i][0], count.get(arr[i][0])+1);
                }        
            
            }

            for(int key : count.keySet()){
                if(count.get(key) %2 != 0){
                    out.println("NO");
                    flag = false;
                    break;
                }
            }

           if(flag) out.println("YES");
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