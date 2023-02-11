import java.util.Arrays;

public class BuyAndSellPep {

    //BUY AND SELL - 1
    //My solve!! (kinda required DP, maybe)
    public int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        int[] max = new int[n];
        max[n-1] = prices[n-1];
    
        //As you have done it in two loops ( can you do it one???? )
        // for(int i = n-2; i >= 0; i--){
        //     max[i] = Math.max(max[i+1], prices[i]);
        // }

        // //now i have the max array for sure
        // for(int i = 0; i < n; i++){
        //     if(prices[i] < max[i]){
        //         ans = Math.max(ans, max[i] - prices[i]);
        //     }
        // }

        //THIS IS MUCH BETTER WAY OF DOING THIS BROTHER (in one loop)
        for(int i = n-2; i >= 0; i--){
            max[i] = Math.max(max[i+1], prices[i]);
            if(prices[i] < max[i]){
                ans = Math.max(ans, max[i] - prices[i]);
            }
        }

        return ans;
    }

    //BUY AND SELL STOCK-2 (lol it worked on the very first try!!!) 
    public int maxProfit2(int[] prices) {
        int ans = 0;
        int n = prices.length;

        for(int i = 0; i < n-1; i++){
            if(prices[i+1] > prices[i]){
                ans += prices[i+1] - prices[i];
            }
        }

        return ans;
    }

    //BUY AND SELL STOCK-3 (SOME BASIC LOGIC)
    //So might code have insane numbers of loops and shit (i think there could be a better way)
    //But dude, i def solved it!! i am proud of it for sure now!!!
    //A BIT SMALLER VERSION
    //MERGING ALL THOSE LOOPS BOIS
    public int maxProfit3(int[] prices) {
        int n = prices.length;
        
        int[] lowest = new int[n];
        lowest[0] = prices[0];
        
        int[] highest = new int[n];
        highest[n-1] = prices[n-1];

        //this would give us lowest till now
        int[] sellBest = new int[n];
        int[] buyBest = new int[n];

        for(int i = 1; i < n; i++){
            lowest[i] = Math.min(lowest[i-1], prices[i]);
            if(lowest[i] < prices[i]){
                sellBest[i] = prices[i] - lowest[i];
            }
            sellBest[i] = Math.max(sellBest[i-1], sellBest[i]);
        }

        //this would be highest till
        for(int i= n-2; i >= 0; i--){
            highest[i] = Math.max(highest[i+1], prices[i]);
            if(highest[i] > prices[i]){
                buyBest[i] = highest[i] - prices[i];
            }
            buyBest[i] = Math.max(buyBest[i+1], buyBest[i]);
        }        

        int ans = 0;
        for(int i = 0; i < n; i++){
            ans = Math.max(ans, sellBest[i] + buyBest[i]);
        }

        return ans;
    }


}
