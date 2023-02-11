import java.util.*;
import java.io.*;

public class fourth{


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
            long[] arr = new long[n];
            
            for(int i = 0 ; i < n ; i++){
                arr[i] = sc.nextLong();
            }

            Set<Integer> set =new HashSet<>();
            // int[] ones = new int[32];
            // int totalOnes = 0;
            // int onesIndex= 0;

            

            ArrayList<Integer> answer = new ArrayList<>();

            // long first = curr[0];

            // while(curr > 0){

            // }


            int l = set.size();
            for(int i = 0 ; i < n ; i++){

                // System.out.println(set);

                long num = 0;
                long curr = arr[i];

                int index = 1;
                    while(curr > 0){
                        if(curr%2 == 1){
                            if(!set.contains(index)){
                                set.add(index);
                            }else{
                                l--;
                            }
                        }else{
                            if(set.contains(index)){
                                num += Math.pow(2, index-1);
                                set.add(index); 
                                l--;  
                            }
                        }
                        curr = curr >> 1;
                        index++;
                    }
                   
                
                while(l != 0){
                    if(set.contains(index)){
                        num += Math.pow(2, index-1);
                        l--;
                    }
                    index++;
                }
               
                l = set.size();
                answer.add((int)num);
            }

            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < answer.size() ; i++){
                if(i == answer.size() -1){
                    sb.append(answer.get(i));
                }else{
                    sb.append(answer.get(i) + " ");
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