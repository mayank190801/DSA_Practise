public class maxSumAdjacents {


    //Method -1  recursino (har point pr jao, fir aage bado do direction and best answer static se store kr lo)

    //Method -2  DP (your own logic, agar ek space ke pehle ka best le aao bas)
    
    //this should do it for sure!!
    //simple logic, take the best from one space behind adjacent baby
    //and not take the adjacent one!!!
   public static int findMaxSum(int arr[], int n) {
        int f = arr[0];
        int s = 0;

        for(int i= 1; i < n; i++){
            int temp = f;
            f = s + arr[i];
            s = Math.max(temp, s);
        }

        return Math.max(f,s);
    }
    
}
