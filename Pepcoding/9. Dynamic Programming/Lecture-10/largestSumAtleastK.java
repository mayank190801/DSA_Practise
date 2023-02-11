import java.util.Arrays;

public class largestSumAtleastK {

    public static void main(String[] args) {
        long[] a = {1, 1, 1, 1, 1, 1};
        long n = a.length;
        long k = 2;
        long ans = maxSumWithK(a, n, k);
        System.out.println(ans);
    }

    //PERFECT CODE WRITTEN BY ME 
    //JUST THINK ACCORDING TO QUESTION NA!!!
    //STEP BY STEP (WHAT IS NECESSARY AND THEN WHAT COULD HAPPEN)
    //THINK FUCKER
    public static long maxSumWithK(long a[], long n, long k)
    {
        //now let's put some logic into the game
        //k subarrays ending at all the indexes bruh, till n-1 element
        long[] kthEnd = new long[(int)n+1];

        long csum = 0;
        long ans = 0;

        //Applying kadanes on this stuff for sure
        for(int i= 0; i < n; i++){
            csum += a[i];
            kthEnd[i+1] = csum;
            if(csum < 0){
                csum = 0;
            }else{
                ans = Math.max(ans, csum); //greater than zero for sure
            }
        }

        //go till kth element and start fromt 
        long fAns = Long.MIN_VALUE;
        long sum = 0;
        for(int i = 0; i < k; i++){
            sum += a[i];  //simple addition for sure
        }

        fAns = Math.max(sum, fAns);
        for(int i = (int)k; i < n; i++){
            sum -= a[(int)(i-k)];
            sum += a[i];
            long temp = sum;
            
            if(kthEnd[(int)(i-k+1)] > 0){
                temp += kthEnd[(int)(i-k+1)];
            }
            
            fAns = Math.max(fAns, temp);
        }
        
        return fAns;
    }

    
    
}
