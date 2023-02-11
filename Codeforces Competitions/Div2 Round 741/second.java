import java.util.*;
import java.io.*;

public class second{

    static int mod = (int) (Math.pow(10, 9)+7);
	static final int dx[] = { -1, 0, 1, 0 }, dy[] = { 0, -1, 0, 1 };
	static final int[] dx8 = { -1, -1, -1, 0, 0, 1, 1, 1 }, dy8 = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static final int[] dx9 = { -1, -1, -1, 0, 0, 0, 1, 1, 1 }, dy9 = { -1, 0, 1, -1, 0, 1, -1, 0, 1 };
	static final int inf = Integer.MAX_VALUE / 2;
	static final long infL = Long.MAX_VALUE / 3;
	static final double infD = Double.MAX_VALUE / 3;
	static final double eps = 1e-10;
	static final double pi = Math.PI;

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
    
        int test = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(4);
        set.add(6);
        set.add(8);
        set.add(9);

        while(test -- > 0){
            

            int len = sc.nextInt();

            char[] inp = sc.nextLine().toCharArray();

            int[] num = new int[len];
            for(int i = 0 ; i < len ; i++){
                num[i] = inp[i] - '0';
            }

            int[] count = new int[10];
            boolean flag = false;
            int[] pos = new int[10];
            Arrays.fill(pos, -1);

            int index = 0;
            for(int i: num){
                if(set.contains(i)){
                    out.println(1);
                    out.println(i);
                    flag = true;
                    break;
                }

                if(pos[i] == -1){
                    pos[i] = index;
                }
                count[i]++;
                index++;
            }

            if(flag) continue;


                        //    0  1  2  3  4  5  6  7  8  9 10  11
            int[] possible = {22,33,55,77,32,25,52,27,72,35,57,75};

            if(count[2]>0){
                
                if(count[2] > 1){
                    out.println(2);
                    out.println(possible[0]);
                    continue;
                }else{
                    if(count[3] > 0 && pos[3] < pos[2]){
                        out.println(2);
                        out.println(possible[4]);
                        continue;
                    }else if(count[5] > 0 && pos[2] < pos[5]){
                        out.println(2);
                        out.println(possible[5]);
                        continue;
                    }else if(count[7] > 0 && pos[2] < pos[7]){
                        out.println(2);
                        out.println(possible[7]);
                        continue;
                    }
                }
                    
            }

            if(count[3] > 0){
                if(count[3] > 1){
                    out.println(2);
                    out.println(possible[1]);
                    continue;
                }else{
                    if(count[5] > 0 && pos[5] > pos[3]){
                        out.println(2);
                        out.println(possible[9]);
                        continue;
                    }
                }                
            }

            if(count[5] > 0){
                if(count[5] > 1){
                    out.println(2);
                    out.println(possible[2]);
                    continue;
                }else{
                    if(count[7] > 0 && pos[5] < pos[7]){
                        out.println(2);
                        out.println(possible[10]);
                        continue;
                    }else if(count[2] > 0 && pos[5] < pos[2] ){
                        out.println(2);
                        out.println(possible[6]);
                    }
                }
            }
            
            if(count[7] > 0){
                if(count[7] > 1){
                    out.println(2);
                   out.println(possible[3]);
                }else if(count[5] > 0 && pos[7] < pos[5]){
                    out.println(2);
                    out.println(possible[11]);
                }else if(count[2] > 0 && pos[7] < pos[2]){
                    out.println(2);
                    out.print(possible[8]);
                }
                
                
            }
        }
        
        out.close();
    }

    //-------------------------------------------------------------------
    //-------------------------------------------------------------------
    //-------------------------------------------------------------------
    //-------------------------------------------------------------------
    //-------------------------------------------------------------------

    public static int add(int a, int b) {
		a+=b;
		if (a>=mod) return a-mod;
		return a;
	}
	
	public static int sub(int a, int b) {
		a-=b;
		if (a<0) a+=mod;
		else if (a>=mod) a-=mod;
		return a;
	}
 
	public static void sort(int[] a) {
		ArrayList<Integer> l=new ArrayList<>();
		for (int i:a) l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) a[i]=l.get(i);
	}
	


    //for calculating binomialCoeff
    public static int binomialCoeff(int n, int k)
    {
        int C[] = new int[k + 1];
        // nC0 is 1
        C[0] = 1;
        for (int i = 1; i <= n; i++) {
            // Compute next row of pascal
            // triangle using the previous row
            for (int j = Math.min(i, k); j > 0; j--)
                C[j] = C[j] + C[j - 1];
        }
        return C[k];
    }

    //Pair with int int 
    public static class Pair{

        public int a;
        public int b;

        Pair(int a , int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString(){
            return a + " -> " + b; 
        }
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