public class BuyAndSellKamal {

    //here we will solve according to bhaiya knowledge!!!
    //pretty cool way of applying and using dp for sure
    
    //Single Transaction baby
    //3D array
    public int maxProfit3D(int[] prices) {
        int k= 1;
        int len = prices.length;
        int[][][] dp = new int[prices.length+1][k+1][2];

        //set the bases cases for this case
        for(int i= 0 ; i <= len; i++){
            dp[i][0][1] = Integer.MIN_VALUE;
        }

        dp[0][1][1] = Integer.MIN_VALUE;
        for(int i = 1; i <= len; i++){
            dp[i][1][0] = Math.max(dp[i-1][1][0], dp[i-1][1][1] + prices[i-1]);
            dp[i][1][1] = Math.max(dp[i-1][1][1], dp[i-1][0][0] - prices[i-1]);
        }
        //now set the initial variables accordingly boss!!! (figure that out)
        return dp[len][1][0];
    }

    //1D array bois
    public int maxProfit1D(int[] prices) {
        int len = prices.length;
        int[] sell = new int[len+1];
        int[] buy = new int[len+1];

        buy[0] = Integer.MIN_VALUE;
        for(int i = 1; i <= len ; i++){
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i-1]);
            buy[i] = Math.max(buy[i-1], -prices[i-1]);
        }

        return sell[len];
    }

    //Using only 2 variables!!! (pretty op code for this bad boi for sure)
    public int maxProfit2var(int[] prices) {
        int len = prices.length;
        int sell = 0;
        int buy = Integer.MIN_VALUE;

        for(int i = 1; i <= len ; i++){
            int ele = prices[i-1];
            sell = Math.max(sell, buy + ele);   //selling using last best buying val
            buy = Math.max(buy, -ele);         //buying using last best selling val
        }

        return sell;
    }


    //BUY AND SELL - 2
    //INFI Transaction (we don't care about k anymore)
    //SIR METHOD IS DOPE AS FUCK (but i need to learn how to implement this stuff on my own bitch)
    public int maxProfitInfiTransaction(int[] prices) {
        int len = prices.length;
        int sell = 0;
        int buy = Integer.MIN_VALUE;

        for(int i = 1; i <= len ; i++){
            int ele = prices[i-1];
            int oldSell = sell;                 //saving the old variable (cause it will get updated)
            sell = Math.max(sell, buy + ele);   //selling using last best buying val
            buy = Math.max(buy, oldSell-ele);   //buying using last best selling val
        }
        return sell;
    }

    //BUY AND SELL WITH FEES
    //just changed one line bro!!!
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        int sell = 0;
        int buy = Integer.MIN_VALUE;

        for(int i = 1; i <= len ; i++){
            int ele = prices[i-1];
            int oldSell = sell;                 //saving the old variable (cause it will get updated)
            sell = Math.max(sell, buy + ele);   //selling using last best buying val
            buy = Math.max(buy, oldSell-ele - fee);   //buying using last best selling val
        }
        return sell;
    }


    //BUY AND SELL WITH COOLDOWN
    //1D array solve baby (let's do this)
    public int maxProfitCoolDown1D(int[] prices) {

        //so this piece of code actually works
        int len = prices.length;
        int[] sell = new int[len+1];
        int[] buy = new int[len+1];

        buy[0] = Integer.MIN_VALUE;
        for(int i = 1; i <= len ; i++){
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i-1]);
            buy[i] = Math.max(buy[i-1], (i-2 == 0 ? 0 : sell[i-2])-prices[i-1]);  //this freakin code works lol
        }

        return sell[len];
        
    }

    //BUY AND SELL WITH COOLDOWN
    //2 variables 
    public int maxProfitCoolDownVar(int[] prices) {
        int len = prices.length;
        int sell = 0;
        int buy = Integer.MIN_VALUE;
        int prevSell = 0; //including one more variable to store even one level back that of sell
        
        for(int i = 1; i <= len ; i++){
            int ele = prices[i-1];
            int oldSell = sell;                 //saving the old variable (cause it will get updated)
            sell = Math.max(sell, buy + ele);   //selling using last best buying val
            buy = Math.max(buy, prevSell-ele);   //buying using last best selling val
            prevSell = oldSell;
        }
        return sell;
    }

    //If you need to do it for more than 1Day cooldown, go for queue!!! (implement it there in front of them);
    //simple as that boi!!!!

    //BUY AND SELL (AT MOST 2 TRANSACTIONS)    
    //this freakin works for sure my boi!!! 
    //So happy for this buy and sell question (main concept is having the best shit till now)
    public int maxProfitAtMost2(int[] prices) {
        int len = prices.length;
        int[][][] dp = new int[prices.length+1][3][2];

        //set the bases cases for this case
        for(int i= 0 ; i <= len; i++){
            dp[i][0][1] = Integer.MIN_VALUE;
        }

        dp[0][1][1] = Integer.MIN_VALUE;
        dp[0][2][1] = Integer.MIN_VALUE;

        for(int i = 1; i <= len; i++){
            dp[i][1][0] = Math.max(dp[i-1][1][0], dp[i-1][1][1] + prices[i-1]);
            dp[i][1][1] = Math.max(dp[i-1][1][1], dp[i-1][0][0] - prices[i-1]);
            dp[i][2][0] = Math.max(dp[i-1][2][0], dp[i-1][2][1] + prices[i-1]);
            dp[i][2][1] = Math.max(dp[i-1][2][1], dp[i-1][1][0] - prices[i-1]);
        }
        //now set the initial variables accordingly boss!!! (figure that out)
        return dp[len][2][0];  //we have to give this out as an answer for sure
    }

    //BUY AND SELL (AT MOST 2 TRANSACTIONS)    
    //4 variable now!!!
    //FUCKING HELL YEAHHHHH!!!!
    //NOW I KNOW HOW TO SOLVE THIS FUCKING QUESTION ( i am legendary bro )
    public int maxProfit4Var2Transaction(int[] prices){
        int len = prices.length;
        int sell = 0;
        int buy = Integer.MIN_VALUE;

        int sell2 = 0;
        int buy2 = Integer.MIN_VALUE;
        
        //just look what you need to store every time and do this equations

        for(int i = 1; i <= len ; i++){
            int ele = prices[i-1];

            int oldSell = sell;
            
            sell = Math.max(sell, buy + ele);   //selling using last best buying val
            sell2 = Math.max(sell2, buy2 + ele);
            buy = Math.max(buy, 0-ele);         //buying using last best selling val
            buy2 = Math.max(buy2, oldSell - ele);
        }

        return sell2;
    }


    //BUY AND SELL 4 
    //at most k transactions
    //Using 3D dp for this one
    //THIS METHOD IS FREAKIN LEGENDARY BRUHHH (let's do the other one too in there)
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        int[][][] dp = new int[prices.length+1][k+1][2];

        //set the bases cases for this case
        for(int i= 0 ; i <= len; i++){
            dp[i][0][1] = Integer.MIN_VALUE;
        }

        //make all the min value for this one
        for(int i= 1; i <= k; i++){
            dp[0][i][1] = Integer.MIN_VALUE;
        }

        for(int i = 1; i <= len; i++){
            for(int j = 1; j <= k ;j++){
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i-1]);
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i-1]);
            }
        }
        //now set the initial variables accordingly boss!!! (figure that out)
        return dp[len][k][0]; 
    }

    //BUY AND SELL - 4
    //in terms of variables (now more than 4 variables will be required)
    //pretty massively tricky i guess (above method is more suitable tho)
    public int maxProfit(int k, int[] prices) {
        //do this in practise for next time
    }


}
