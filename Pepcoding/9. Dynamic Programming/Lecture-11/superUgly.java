import java.util.PriorityQueue;

public class superUgly {

    //FIGURE OUT THE MISTAKE IN THIS CODE ASAP
    //LOGIC IS SUPER DOPE FOR SURE

    //let's figure this one out
    //SIMILAR TO UGLY NUMBERS 2 CODE!! (simple as that)
    //we could use PQ (for this work) 
    public static int nthSuperUglyNumber(int n, int[] primes) {
        int len = primes.length;
        int[] ptr = new int[len];
        int[] dp = new int[n];
        dp[0] = 1;

        for(int i = 1; i < dp.length; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < len;j++){
               min = Math.min(min, primes[j] * dp[ptr[j]]); 
            }
            dp[i] = min;
            for(int j= 0 ;j < len; j++){
                if(primes[j] * dp[ptr[j]] == min){
                    ptr[j]++;
                }
            }
        }

        return dp[n-1];
    }

    //OPTIMIZED USING PQ (simple logic)
    public static int nthSuperUglyNumberPQ(int n, int[] primes) {
        int len = primes.length;
        int[] ptr = new int[len];
        int[] dp = new int[n];
        dp[0] = 1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0] * dp[a[1]] - b[0] * dp[b[1]]));  //primes[i], ptr[i];
        
        for(int i = 0; i < len; i++){
            pq.add(new int[]{primes[i], 0});
        }

        for(int i = 1; i < dp.length; i++){
            int[] min = pq.poll();  //first val with min  //(logn)
            int val = min[0] * dp[min[1]];
            pq.add(new int[]{min[0], min[1] + 1});

            //simple basic logic you could figure out
            if(dp[i-1] == val){
                i--;
                continue;
            }

            dp[i] = val;
        }

        return dp[n-1];
    }
    
}

    
}
