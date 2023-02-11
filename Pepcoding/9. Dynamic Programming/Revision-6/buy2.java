public class buy2 {
    public static void main(String[] args) {

    }

    //correct code for sure! (pretty glad about it not gonna lie bruh!)
    public int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        int current = prices[n - 1];
        for(int i = n - 2; i >= 0; i--){
            if(current > prices[i]){
                ans += current - prices[i];
            }
            current = prices[i];
        }
        return ans;
    }
}
