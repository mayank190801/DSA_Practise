import java.util.*;

public class slices2 {
    public static void main(String[] args) {
        int[] arr = {0,2000000000,-294967296};
        int answer = numberOfArithmeticSlices(arr);
        System.out.println(answer);
    }

    //MY SOLVE - //ran perfectly for sure!! (beautiful)
    //let's  figure this problem out for sure too now!!! (simple solve!)
    public static int numberOfArithmeticSlices(int[] nums) {
        //this is a fucking bad boi (figure this out for sure now)
        int n = nums.length;
        HashMap<Long, Long>[] dp = new HashMap[n];
        long ans = 0;

        for(int i = 0; i < n; i++){
            dp[i] = new HashMap<>(); //pretty useful

            for(int j = i - 1; j >= 0; j--){
                //simple 
                long cd = (long)(nums[i]) - (long)(nums[j]);
                dp[i].putIfAbsent(cd, 0L);
                
                if(dp[j] != null &&  dp[j].containsKey(cd)){
                    ans += dp[j].get(cd);
                    dp[i].put(cd, dp[i].get(cd) + dp[j].get(cd) + 1);
                }else{
                    dp[i].put(cd, dp[i].get(cd) + 1);
                } 

            }
        }

        return (int)ans;
    }

    //SIR HAVE USED GETORDEFAULT a lot more times,
    //rather than checkin everytime, just check what it will give
    //and tada, less complications

    //UPDATED VERSION WITH FINDING SEQUENCE RATHER THAN SUBSEQUENCE (simple sort no?) (simple sort would work tho)
    public static int numberOfArithmeticSlicesUpgradge(int[] nums) {
        //this is a fucking bad boi (figure this out for sure now)
        Arrays.sort(nums);  //DONE 

        int n = nums.length;
        HashMap<Long, Long>[] dp = new HashMap[n];
        long ans = 0;

        for(int i = 0; i < n; i++){
            dp[i] = new HashMap<>(); //pretty useful

            for(int j = i - 1; j >= 0; j--){
                //simple 
                long cd = (long)(nums[i]) - (long)(nums[j]);
                dp[i].putIfAbsent(cd, 0L);
                
                if(dp[j] != null &&  dp[j].containsKey(cd)){
                    ans += dp[j].get(cd);
                    dp[i].put(cd, dp[i].get(cd) + dp[j].get(cd) + 1);
                }else{
                    dp[i].put(cd, dp[i].get(cd) + 1);
                } 

            }
        }

        return (int)ans;
    }

    //LONGEST ARITHMETIC SLICE
    public static int numberOfArithmeticSlicesUpgradgeLongest(int[] nums) {
        //this is a fucking bad boi (figure this out for sure now)
        // Arrays.sort(nums);  //DONE 
        //much more easier probably

        int n = nums.length;
        HashMap<Long, Long>[] dp = new HashMap[n];
        long ans = 0;
        long length = 0;

        for(int i = 0; i < n; i++){
            dp[i] = new HashMap<>(); //pretty useful

            for(int j = i - 1; j >= 0; j--){
                //simple 
                long cd = (long)(nums[i]) - (long)(nums[j]);
                dp[i].putIfAbsent(cd, 0L);

                if(dp[j] != null &&  dp[j].containsKey(cd)){
                    ans += dp[j].get(cd);
                    length = Math.max(length, dp[i].get(cd));
                    dp[i].put(cd, dp[i].get(cd) + dp[j].get(cd) + 1);
                    
                }else{
                    length = Math.max(length, dp[i].get(cd));
                    dp[i].put(cd, dp[i].get(cd) + 1);
                    
                } 

            }
        }

        return (int)length;
    }
}
