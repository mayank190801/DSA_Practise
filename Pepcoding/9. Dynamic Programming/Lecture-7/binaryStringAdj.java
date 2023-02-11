public class binaryStringAdj{

    public static void main(String[] args) {
        // int ans = binarySringNo2Same(4);
        // System.out.println(ans);
        int ans1 = binarySringNo3Same(3);
        System.out.println(ans1);
        
    }

    //2^n to n complexity conversion using DP!!!
    public static int binarySringNo2Same(int n){
        int zero = 1;
        int one = 1;
        for(int i= 1; i < n; i++){
            int temp = one;
            one = zero;
            zero = temp + zero;
        }

        return one + zero;
    }

    //same above code but used for submission bois!!!
    long countStrings(int n) {
        // code here
        long mod = 1_000_000_007;
        long zero = 1;
        long one = 1;
        for(int i= 1; i < n; i++){
            long temp = one%mod;
            one = zero%mod;
            zero = (temp + zero)%mod;
        }

        return (one + zero)%mod;
    }

    //Binary string with no 3 adjacent '1' of length n  
    //let's solve this bad boi (same concept but a bit advanced)
    //basically how we are making one more answers baby
    public static int binarySringNo3Same(int n){

        int zero = 1;
        int one = 1;
        int oneone = 0;

        for(int i= 1; i < n; i++){
            int zerot = zero;
            int onet = one;
            zero = zero + one + oneone;
            one = zerot;
            oneone = onet;
        }

        return one + zero + oneone;
    }



}