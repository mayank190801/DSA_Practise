

public class constructBuildings {
    public static void main(String[] args) {
        int N = 10;
        int ans = TotalWays(N);
        System.out.println(ans);
    }

    public static int TotalWays(int N) {
        long[] zero = new long[N];
        long[] one = new long[N];
        long mod = 1000000007;

        zero[0] = 1;
        one[0] = 1;
        for(int i= 1; i < N; i++){
            zero[i] = (zero[i-1] + one[i-1])%mod;
            one[i] = zero[i-1];
        }

        //now at Nth pos
        long sum = (zero[N-1] + one[N-1])%mod;
        long ans = (sum * sum) % mod;
        return (int)ans;
    }



}
