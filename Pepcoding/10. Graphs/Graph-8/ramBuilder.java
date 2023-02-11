import java.util.Arrays;

public class ramBuilder {
    public static void main(String[] args) {

    }

    static int[] process_queries(int[] A, int[] K_Array, int N, int K){
        Arrays.sort(A);
        int[] answer = new int[K];
        for(int i = 0; i < K; i++){
            int val = K_Array[i];
            int ans = countGreater(A, N, val);
            answer[i] = ans;
        }
        return answer;
    }

    static int countGreater(int arr[], int n, int k)
    {
        int l = 0;
        int r = n - 1;
        int leftGreater = n;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] > k) {
                leftGreater = m;
                r = m - 1;
            }
            else
                l = m + 1;
        }
        return (n - leftGreater);
    }

}
