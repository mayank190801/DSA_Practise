public class rotatedArray {

    //METHOD BEST , just figure out yourself
    //SPACE O(1)
    //TIME O(N)
    public static void main(String[] args) {
        int arr[] = {1, 20, 2, 10};   
        int ans = maxValue(arr);
        System.out.println(ans);
    }

    //PRETTY SIMPLE SOLVE BOIS
    public static int maxValue(int[] arr){
        int sum = 0;
        int csum = 0;
        int ans = 0;
        int n = arr.length;

        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            csum += i*arr[i];
        }

        ans = csum;
        for(int i = 1; i < arr.length; i++){
            int last = arr[i-1];
            csum -= sum;
            csum += n*last;
            ans = Math.max(ans, csum);
        }

        return ans;
    }

    
}
