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

        String S = "tale";
        String T = "late";

        String abc = "abcdefghijklmnopqrstuvwxyz";
        char[] alpha = abc.toCharArray();
        //now i have to string
        int[] first = new int[26];
        int[] second = new int[26];

        char[] a = S.toCharArray();
        char[] b = T.toCharArray();

        int cf = 0;
        int cs = 0;
        for( char ch : a){
            first[ch-'a']++;
            cf++;
        }

        for( char ch : b){
            second[ch-'a']++;
            cs++;
        }

        if(Math.abs(cs - cf) >= 2){
            System.out.println("IMPOSSIBLE");
            return;
        }

        if(Math.abs(cs - cf) == 1){
            
            //difference of one character only
            String random = T.substring(0, cs-1);
            char chi = 'a';
            if(cs > cf){
                if(S.compareTo(random) == 0){
                    chi = T.charAt(cs-1);
                    System.out.println("ADD " + chi);
                    return;
                }
            }

            if(cf > cs){

                boolean check = true;
                char ch = 'a';
                for(int i = 0 ;i < 26 ; i++){
                    if((first[i] > 0 && second[i] > 0) || (first[i] == 0 && second[i] == 0)){
                        if(first[i] > second[i]){
                            ch = alpha[i];
                        }
                        check = true;
                    }else{
                        check = false;
                    }
                }

                if(check){
                    System.out.println("JOIN " + ch);
                    return;
                }
            }
        
        }

        if(cs == cf){

            boolean check = true;
            int count = 0;
            int rand = -1;
            int srand = 0;

            for(int i = 0 ;i < 26 ; i++){
                if(second[i] != first[i]){
                    check= false;
                }
            }


            if(check){
                

                for(int i = 0 ; i < a.length ; i++){

                    if(a[i] != b[i]){
                        count++;
                        if(rand == -1){
                            rand = i;
                        }else{
                            srand = i;
                        }
                    }

                }

                if(count == 2){
                    char f = S.charAt(rand);
                    char s = S.charAt(srand);
                    System.out.println("SWAP " + s + " " + f);
                    return;
                }

            }
                
            
        }

        System.out.println("IMPOSSIBLE");
        return;
        



        





        //------------------------------------------------------------------
        
        // Stop writing your solution here. -------------------------------------~~
    }

    //Shortcut function
    public static long lcm(long a , long b){
        return a * (b/gcd(a,b));
    }

    //let's make one for calculating lcm basically
    public static int lcm(int a , int b){
        return (a * b)/gcd(a,b);
    }

    //int version for gcd
    public static int gcd(int a, int b){
        if(b == 0)
            return a;
            
        return gcd(b , a%b);
    }

    //long version for gcd
    public static long gcd(long a, long b){
        if(b == 0)
            return a;

        return gcd(b , a%b);
    }

    //swapping two elements in an array
    public static void swap(int[] arr, int left , int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    //reversing an array
    public static void reverse(int[] arr){
        int left = 0;
        int right = arr.length-1;

        while(left <= right){
            swap(arr, left,right);
            left++;
            right--;
        }
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