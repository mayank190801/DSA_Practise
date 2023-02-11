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

        //let's figure this brute force out
        int test = sc.nextInt();

        while(test -- > 0){

            

            int lines = sc.nextInt();
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] mono = new int[n];
            int[] polo = new int[m];

            ArrayList<Integer> answer = new ArrayList<>(n+m);

            for(int i = 0 ; i < n ; i++){
                mono[i] = sc.nextInt();
            }
            for(int i = 0 ; i < m ; i++){
                polo[i] = sc.nextInt();
            }

            int l = 0;
            int r = 0;

            boolean flag = true;
            while(l < n || r < m){

                if(l < n && r < m){

                    if(mono[l] == 0){
                        answer.add(0);
                        l++;
                        lines++;
                        continue;
                    }

                    if(polo[r] == 0){
                        answer.add(0);
                        r++;
                        lines++;
                        continue;
                    }

                    //dono hi ni hai
                    if(mono[l] < polo[r]){

                        if(mono[l] <= lines){
                            answer.add(mono[l]);
                            l++;
                        }else{
                            flag = false;
                            break;
                        }

                        continue;

                    }else{

                        if(polo[r] <= lines){
                            answer.add(polo[r]);
                            r++;
                        }else{
                            flag = false;
                            break;
                        }
                        continue;
                    }

                }

                if(l < n){

                    if(mono[l] == 0){
                        answer.add(0);
                        l++;
                        lines++;
                        continue;
                    }

                    if(mono[l] <= lines){
                        answer.add(mono[l]);
                        l++;
                    }else{
                        flag = false;
                        break;
                    }


                }

                if(r < m){

                    if(polo[r] == 0){
                        answer.add(0);
                        r++;
                        lines++;
                        continue;
                    }

                    if(polo[r] <= lines){
                        answer.add(polo[r]);
                        r++;
                    }else{
                        flag = false;
                        break;
                    }

                }

            }

            StringBuilder sb = new StringBuilder();

            if(flag){
                for(int i = 0 ; i < answer.size() ; i++){
                    if(i == answer.size() -1){
                        sb.append(answer.get(i));
                    }else{
                        sb.append(answer.get(i) + " ");
                    }
                }

                String random = sb.toString();
                out.println(random);
            }else
                out.println(-1);

        
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