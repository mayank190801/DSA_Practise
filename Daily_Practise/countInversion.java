import java.util.Arrays;

public class countInversion {
    public static void main(String[] args) {
        long[] arr = {2, 4, 1, 3, 5};
        long ans = inversionCount(arr, arr.length);
        System.out.println(ans);
    }

    public static long inversionCount(long arr[], long N)
    {
        return mergeSort(arr);
    }

    public static long mergeSort(long arr[]){
        long n = arr.length;
        if(n <= 1) return 0;
        int half = (int)(n/2);
        long ans = 0;

        long[] one = new long[(int)half];
        long[] two = new long[(int)(n - half)];

        for(int i = 0; i < half; i++){
            one[i] = arr[i];
        }

        for(int i = 0; i < (n - half); i++){
            two[i] = arr[half + i];
        }

        ans += mergeSort(one);
        ans += mergeSort(two);
        ans += mergeSortCombine(arr, one, two);
        return ans;
    }

    public static long mergeSortCombine(long[] arr, long[] one, long[] two){
        int n = one.length + two.length;

        int idx = 0;
        int oi = 0;
        int ti = 0;
        long count = 0;
        while(idx < n){
            long oneVal = oi < one.length ? one[oi] : Long.MAX_VALUE;
            long twoVal = ti < two.length ? two[ti] : Long.MAX_VALUE;

            if(twoVal < oneVal && oi < one.length){
                count += (one.length - oi);
            }

            arr[idx] = Math.min(oneVal, twoVal);
            if(oneVal <= twoVal) oi++; else ti++;
            idx++;
        }

        return count;
    }
}
