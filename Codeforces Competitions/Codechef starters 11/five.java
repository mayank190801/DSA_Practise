import java.util.*;
import java.io.*;

public class five{

    static int mod = (int) (Math.pow(10, 9)+7);
	static final int dx[] = { -1, 0, 1, 0 }, dy[] = { 0, -1, 0, 1 };
	static final int[] dx8 = { -1, -1, -1, 0, 0, 1, 1, 1 }, dy8 = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static final int[] dx9 = { -1, -1, -1, 0, 0, 0, 1, 1, 1 }, dy9 = { -1, 0, 1, -1, 0, 1, -1, 0, 1 };
	static final int inf = Integer.MAX_VALUE / 2;
	static final long infL = Long.MAX_VALUE / 3;
	static final double infD = Double.MAX_VALUE / 3;
	static final double eps = 1e-10;
	static final double pi = Math.PI;
    static List<Integer> primeNumbers = new ArrayList<>();
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));

        int test = sc.nextInt();

        while(test -- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] arr = new int[n];
            for(int i = 0; i < n ; i++) arr[i] = sc.nextInt();

            int[] first = new int[n];
            int[] second = new int[n];

            //find the index of the first greater than zero element
            int index = -1;
            for(int i = 0; i < n ; i++){
                if(arr[i] > 0){
                    index = i;
                    break;
                }
            }

            if(index == -1){
                //print out the array itself and contniue
                for(int i= 0; i < n ; i++){
                    out.print(arr[i] + " ");
                }
                out.println();
                continue;
            }

            //now index is our massiah
            int temp = index;
            //now run two
            for(int i = index; i < n; i++){
                //run loop in this direction
                //simple logic 
                int back = ((i-1)+n)%n;
                int front = ((i+1)+n)%n;

                if(arr[back] > 0 || arr[front] > 0){
                    first[i] = 0;
                }else{
                    first[i] = first[back]-1;
                }
            }

            for(int i = 0; i <= index ; i++){

                int back = ((i-1)+n)%n;
                int front = ((i+1)+n)%n;
                if(arr[back] > 0 || arr[front] > 0){
                    first[i] = 0;
                }else{
                    first[i] = first[back]-1;
                }
            }


            //now everything same but in oppostive directions only
            //simple as that 
            for(int i = index; i >= 0; i--){
                //run loop in this direction
                //simple logic 
                int back = ((i-1)+n)%n;
                int front = ((i+1)+n)%n;

                if(arr[back] > 0 || arr[front] > 0){
                    second[i] = 0;
                }else{
                    second[i] = second[front]-1;
                }
            }

            for(int i = n-1; i >= index ; i--){

                int back = ((i-1)+n)%n;
                int front = ((i+1)+n)%n;

                if(arr[back] > 0 || arr[front] > 0){
                    second[i] = 0;
                }else{
                    second[i] = second[front]-1;
                }
            }

            
            // System.out.println(Arrays.toString(second));
            for(int i= 0; i <n ; i++){
                first[i] = Math.min(first[i], second[i]);
            }

            // out.println(Arrays.toString(first));
            

            int[] remem = new int[n];

            //now i have to set some condition for every digit out there
            for(int i = 0; i < n ; i++){
                int back = ((i-1)+n)%n;
                int front = ((i+1)+n)%n;

                if(arr[i] == 0){
                    if(first[i] == 0){
                        if(arr[back] > 0 && arr[front] > 0){
                            //that means 
                            remem[i] = 0;
                        } else{
                            //whenever gets the chace, first two tries are 1
                            //simple as that
                            remem[i] = 2;
                        }
                    }else{
                        //in this only we have multiple test cases to be honest
                        //just think a bit
                        if(first[back] == first[front]){
                            remem[i] = 0;
                        }else{
                            remem[i] = 2;
                        }
                    }
                }else{
                    //now we have to think if its some number
                    //this was easy
                    if(first[i] == 0){
                        if(arr[back] > 0 && arr[front] > 0){
                            //that means 
                            remem[i] = 0;
                        } else{
                            //whenever gets the chace, first two tries are 1
                            //simple as that
                            remem[i] = 1;
                        }
                    }else{
                        //in this only we have multiple test cases to be honest
                        remem[i] = -1;
                    }
                }

            }

            // out.println(Arrays.toString(remem));

            //so now we have to calculate sum tricky stuff 
            //these maths is going to be a lot trickier, for every digit to be honest
            long answer = 0;

            if(k == 0){
                for(int i : arr){
                    answer += i;
                }

                out.println(answer);
                continue;
            }

    
            for(int i = 0; i < n ; i++){
                if(arr[i] > 0){
                    answer += arr[i];

                    //so now let's think
                    //this is now perfect for numbers
                    if(remem[i] == 0){
                        answer += k*2;
                    }else if(remem[i] == 1){
                        answer += k*2 - 1;
                    }else{
                        if(k > 1){
                            answer += (k-1)*2;
                        }
                    }

                }else{
                    //arr[i] == 0;
                    //now is many cases part 
                    //now i have to fix this part of the code only, super simple
                    //let's look into the matter

                    if(first[i] == 0){
                        if(remem[i] == 0){
                            answer += k*2;
                        }else{
                            if(k > 2){
                                answer += (k-1)*2;
                            }else{
                                answer += k;
                            }
                        }
                    }else{
                        //what about this code now
                        //this case is most typical to be honest
                        //let's face it and solve i
                        if(remem[i] == 0){
                            if(k > Math.abs(first[i])){
                                answer += (k-Math.abs(first[i]))*2;
                            }
                        }else{
                            if(k > -first[i]){
                                if( k + first[i] > 2){
                                    answer += (k+first[i]-1)*2;
                                }else{
                                    answer += k+first[i];
                                }           
                            }
                        }
                    }

                }

                // out.println(answer);
            }


            // out.println(Arrays.toString(remem));

            out.println(answer);
            //now for 
        }

        out.close();
    }

    //-------------------------------------------------------------------
    //-------------------------------------------------------------------
    //-------------------------------------------------------------------
    //-------------------------------------------------------------------
    //-------------------------------------------------------------------

    //prime sieve
    public static void primeSieve(int n){
        BitSet bitset = new BitSet(n+1);
        for(long i = 0; i < n ; i++){
            if (i == 0 || i == 1) {
                bitset.set((int) i);
                continue;
            }
            if(bitset.get((int) i)) continue;
            primeNumbers.add((int)i);
            for(long j = i; j <= n ; j+= i)
                bitset.set((int)j);
        }
    }

    //number of divisors
    public static int countDivisors(long number){
        if(number == 1) return 1;
        List<Integer> primeFactors = new ArrayList<>();
        int index = 0;
        long curr = primeNumbers.get(index);
        while(curr * curr <= number){
            while(number % curr == 0){
                number = number/curr;
                primeFactors.add((int) curr);
            }    
            index++;
            curr = primeNumbers.get(index);
        }

        if(number != 1) primeFactors.add((int) number);
        int current = primeFactors.get(0);
        int totalDivisors = 1;
        int currentCount = 2;
        for (int i = 1; i < primeFactors.size(); i++) {
            if (primeFactors.get(i) == current) {
                currentCount++;
            } else {
                totalDivisors *= currentCount;
                currentCount = 2;
                current = primeFactors.get(i);
            }
        }
        totalDivisors *= currentCount;
        return totalDivisors;
    }

    //now adding next permutation function to java hehe
    public static boolean next_permutation(int[] p) {
        for (int a = p.length - 2; a >= 0; --a)
          if (p[a] < p[a + 1])
            for (int b = p.length - 1;; --b)
              if (p[b] > p[a]) {
                int t = p[a];
                p[a] = p[b];
                p[b] = t;
                for (++a, b = p.length - 1; a < b; ++a, --b) {
                  t = p[a];
                  p[a] = p[b];
                  p[b] = t;
                }
                return true;
              }
        return false;
    }

    //finding the value of NCR in O(RlogN) time and O(1) space
    public static long getNcR(int n, int r)
    {
        long p = 1, k = 1;
        if (n - r < r) r = n - r;

        if (r != 0) {
            while (r > 0) {
                p *= n;
                k *= r;
                long m = __gcd(p, k);
                p /= m;
                k /= m;
                n--;
                r--;
            }
        }
        else {
            p = 1;
        }
        return p;
    }
 
    //for ncr calculator
    public static long __gcd(long n1, long n2)
    {
        long gcd = 1;
        for (int i = 1; i <= n1 && i <= n2; ++i) {
            // Checks if i is factor of both integers
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }



    //is vowel function 
    public static boolean isVowel(char c)
    {
        return (c=='a' || c=='A' || c=='e' || c=='E' || c=='i' || c=='I' || c=='o' || c=='O' ||     c=='u' || c=='U');
    }   

    //two add two big numbers with some mod 
    public static int add(int a, int b) {
		a+=b;
		if (a>=mod) return a-mod;
		return a;
	}
	
    //two sub two numbers
	public static int sub(int a, int b) {
		a-=b;
		if (a<0) a+=mod;
		else if (a>=mod) a-=mod;
		return a;
	}
 
    //to sort the array with better method
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

    //Triplet with int int int
    public static class Triplet{

        public int a;
        public int b;
        public int c;

        Triplet(int a , int b, int c){
            this.a = a;
            this.b = b;
            this.c = c;
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

    //
     //for char array
     public static void swap(char[] arr, int left , int right){
        char temp = arr[left];
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