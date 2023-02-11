import java.util.Arrays;

public class maxSumIncreasing {
    public static void main(String[] args) {

        int[] arr = {44 ,42 ,38 ,21, 15 , 22,13 ,27};
        int n = arr.length;
        
        System.out.println(maxSumIS(arr, n));
    }

    //TIME O(n^2) //simple as that
    //my code (works superb for sure!!!)
    public static int maxSumIS(int arr[], int n)  
	{  
        //let's figure this out
        int[] dp = new int[n]; //dp basically
        dp[0] = arr[0];
        for(int i= 1; i< n; i++){
            dp[i] = arr[i];
            for(int j= i-1; j >= 0; j--){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
        }

        int answer = 0;
        for(int i : dp){
            answer = Math.max(answer, i);
        }

        return answer;
	}  

    


    
}
