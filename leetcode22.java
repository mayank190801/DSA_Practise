public class leetcode22 {
    public static void main(String[] args) {

    }

    //let's figure this math out - how we can solve it better
    //maybe work on improving it even more for sure
    public static int getMaximumGenerated(int n) {
        int[] ans = new int[n + 1];
        if(n == 0) return 0;
        if(n == 1) return 1;
        ans[1] = 1;
        int max = 1;
        for(int i = 2; i <= n; i++){
           if(i % 2 == 0){
               ans[i] = ans[i/2];
           }else{
               ans[i] = ans[i/2] + ans[i/2 + 1];
           }
           max = Math.max(ans[i], max);
        }
        return max;
    }
}
