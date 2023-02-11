import java.util.*;
import java.io.*;

public class three{

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

    public static class graph{

        //this is a directed graph
        //now make a set storage for all of them
        public ArrayList<ArrayList<Integer>> g;
        public int n;
        //set for all the elements for easy remove
        // public ArrayList<
        public ArrayList<Set<Integer>> parents;

        graph(int n){

            this.n = n;
            g = new ArrayList<>(n+1);
            for(int i= 0; i <= n; i++){
                g.add(new ArrayList<>());
            }

            parents = new ArrayList<>(n+1);
            for(int i= 0; i <= n; i++){
                parents.add(new HashSet());
            }
        }

        public void addEdge(int from, int to){
            g.get(from).add(to);
            parents.get(to).add(from);
        }

        public int count(){

            //first step to put all elements with zero parents in the queue
            //sorted set could be used tooo
            
            PriorityQueue<Integer> que = new PriorityQueue<>();
            for(int i = 1; i <= n ; i++){
                if(parents.get(i).size() == 0){
                    que.add(i);
                }
            }

            //and current que as always baby
            //making new one 
            int[] visited= new int[n+1];
            ArrayList<Integer> store = new ArrayList<>();

            int count = 0;

            while(true){
                while(!que.isEmpty()){
                    //we will keep working
                    int curr = que.poll();
                    visited[curr] = 1;

                    for(int i : g.get(curr)){
                        if(visited[i] == 1) continue;

                        parents.get(i).remove(curr);
                        if(parents.get(i).size() == 0){
                            if(i > curr){
                                que.add(i);
                            }else{
                                store.add(i);
                            }
                        }
                    }
                }

                if(store.size() == 0){
                    break;
                }

                for(int i : store){
                    que.add(i);
                }

                store = new ArrayList<>();
                count++;
            } 

            for(int i = 1; i < n ; i++){
                if(visited[i] == 0){
                    return -2;
                }
            }

            return count;
        }


    }
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
    
        int test = sc.nextInt();

        while(test -- > 0){

            int n = sc.nextInt();

            graph graph = new graph(n);

            for(int i= 0; i < n ; i++){
                int k = sc.nextInt();
                for(int j = 0; j < k ; j++){
                    int pos = sc.nextInt();
                    graph.addEdge(pos, i+1);
                }
            }

            // if(graph.isLoop()){
            //     out.println(-1);
            //     continue;
            // }

            //now i know that loop is not there atleast
            out.println(graph.count()+1);
          

            //they both are ready now
            //now first check if there is no cycle present
            //first very condition
            // System.out.println(graph.g);
            // System.out.println(graph.parents);
        }
        
        out.close();
    }

    //-------------------------------------------------------------------
    //-------------------------------------------------------------------
    //-------------------------------------------------------------------
    //-------------------------------------------------------------------
    //-------------------------------------------------------------------

    public static class segmentTree{

        public long[] arr;
        public long[] tree;
        public long[] lazy;

        segmentTree(long[] array){
            int n = array.length;
            arr = new long[n];
            for(int i= 0; i < n; i++) arr[i] = array[i];
            tree = new long[4*n + 1];
            lazy = new long[4*n + 1];
        }

        public void build(int s, int e, int index){
            if(s == e){
                tree[index] = arr[s];
                return;
            }
            int mid = (s + e)/2;
            build(s, mid, 2*index);
            build(mid+1, e, 2*index + 1);
            tree[index] = Math.max(tree[2*index], tree[2*index+1]);
        }

        //now we have to build query function
        //there are different overlap in it, not very complicated, but definitely a lot useful
        //you should learn them for sure
        public long query(int s, int e, int sr, int er, int index){
            if(lazy[index] != 0){
                tree[index] = lazy[index];
                if(s != e){
                    lazy[2*index+1] = lazy[index];
                    lazy[2*index] = lazy[index];
                }
                lazy[index] = 0;
            }
            if(er < s || sr > e) return Integer.MIN_VALUE;
            if(sr <= s && e <= er) return tree[index];
            int mid = (s + e)/2;
            long left = query(s, mid, sr, er, 2*index);
            long right = query(mid+1, e, sr, er, 2*index+1);
            return Math.max(left, right);
        }

        public void update(int s, int e, int indexr, int increment, int index){
            if(lazy[index] != 0){
                tree[index] = lazy[index];
                if(s != e){
                    lazy[2*index+1] = lazy[index];
                    lazy[2*index] = lazy[index];
                }
                lazy[index] = 0;
            }
            if(indexr < s || indexr > e) return;
            if(s == e) tree[indexr] = increment;
            int mid = (s + e)/2;
            update(s, mid, indexr, increment, 2*index);
            update(mid+1, e, indexr, increment, 2*index + 1);
            tree[index] = Math.max(tree[2*index+1], tree[2*index]);
        }

        public void updateRangeLazy(int s, int e, int sr, int er, long increment, int index){
            if(lazy[index] != 0){
                tree[index] = lazy[index];

                if(s != e){
                    lazy[2*index + 1] = lazy[index];
                    lazy[2*index] = lazy[index];
                }
                lazy[index] = 0;
            }
            if(sr > e || er < s) return;
            if(sr <= s && e <= er){
                tree[index] = increment;
                if(s != e){
                    lazy[2*index + 1] = increment;
                    lazy[2*index] = increment;
                }
                return;
            }
            int mid = (s + e)/2;
            updateRangeLazy(s, mid, sr, er, increment, 2*index);
            updateRangeLazy(mid+1, e, sr, er, increment, 2*index + 1);
            tree[index] = Math.max(tree[2*index], tree[2*index+1]);
        }

    }

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