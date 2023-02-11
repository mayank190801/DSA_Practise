import java.util.Arrays;

public class RussianDoll{

    //Russian Doll bois
    //SO THIS IS A QUESTION OF SIMULTANEOUS LIS

    //We could solve these problems by first sorting one condition
    //and then applying LIS on the other condition

    //THIS BELOW IS MY BASIC LOGIC SOLVE 
    //O(n^2)
    public int maxEnvelopes(int[][] envelopes) {
        //le'ts first sort this 
        //and then apply LIS on it, simple as that

        //pretty basic
        Arrays.sort(envelopes, (a,b) ->{
            if(a[0] - b[0] != 0){
                return a[0] - b[0];
            }else{
                return a[1] - b[1];
            }
        });

        //sorting is done bois
        int len = envelopes.length;
        int[] dp = new int[len];
        int ans = 1;

        //some checks needs to be imposed in those edge cases for sure
        //let's think about it and implement them for real now
        for(int i = 0; i < envelopes.length; i++){
            dp[i] = 1;
            for(int j = i-1; j >= 0; j--){
                if(envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            ans = Math.max(ans, dp[i]); //this was nice for sure!!
        }

        return ans;
    }

   
    //SIR SOLVE
    //O(nlogn)
    //reverse sorting for same elements is the key to solving this question for sure (pretty cool)
    //remember that

    //how is the reverse sorting affecting the answer boi?
    //simply logic thinking would suffice this doubt
    //if we want to make lis 
    //9 7 1 we can take only freakin one value, whereas 
    //1 7 9 we could take all or any two also depending on the question
    //hence reverse sort makes it such that no duplicates could ever come again!!
    
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a,b) ->{
            if(a[0] - b[0] != 0){
                return a[0] - b[0];
            }else{
                return b[1] - a[1]; //biggest part of this question (we didn't wanna take 4 4 again and so we reverse sort it)
            }
        });

        int ans = 1;
        for(int i = 1; i < envelopes.length; i++){
            int cidx = binarySearch(envelopes, 0, ans-1, envelopes[i][1]);
            if(cidx == ans){
                ans++;
            }
            envelopes[cidx][1] = envelopes[i][1]; //always gonna happen bois
        }
        return ans;

    }

    public static int binarySearch(int[][] nums, int si, int ei ,int val){
        while(si <= ei){
            int mid = (si + ei)/2;
            if(nums[mid][1] == val){
                return mid;
            }else if(nums[mid][1] < val){
                si = mid + 1;
            }else{
                ei = mid - 1;
            }
            //simple as that bruh
        }
        return si;
    }
}