
public class abcSubseq {

    public static void main(String[] args) {
        String curr = "abcabc";
        int ans = fun(curr);
        System.out.println(ans);
    }

    public static int fun(String s)
    {
        //figuring this out should be muchh easier
        //some error is happening at some position, hmm, think once
        long mod = 1000_000_007;
        long c = 0;
        long b = 0;
        long a = 0;

        int n = s.length();
        for(int i= n - 1; i >= 0; i--){
            char ch = s.charAt(i);
            if(ch == 'c'){
                c++;
            }else if(ch == 'b'){
                b = (b + c)%mod;
            }else{
                a = (a + b + c)%mod;
            }
        }

        return (int)(a%mod);
    }

}
