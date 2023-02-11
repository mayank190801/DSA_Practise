public class paintFence {

    //let's do this bad boi, and solve it for lrea
    //ATLAST SOLVED ON MY OWN!!!!!!
    //Tricky, sir ki tips help aayi bahuuutttt!!
    //USING LAST 2 DIFF AND SAME!!!! (simple as that)
    public static long countWays(int n,int k)
    {
        if(n == 1) return k;
    
        long mod = 1_000_000_007;
        long diff = k*(k-1);
        long same = k;

        for(int i = 2; i < n; i++){
            long temp = same;
            same = diff%mod;
            diff = ((diff * (k-1))%mod + (temp * (k-1))%mod)%mod;
        }

        return (same + diff)%mod;
    }

}
