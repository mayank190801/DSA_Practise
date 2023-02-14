import java.util.Arrays;

public class ShellSort {
    //using shell sort
    public static void main(String[] args) {
        int[] arr = { 2, 7, 10, 1, 8, 5, 3, 4};
        shellSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr){
        int n = arr.length;
        int gap = n / 2;

        while(gap > 0){
            for(int j = gap; j < n; j++){
                for(int i = j - gap; i >= 0; i -= gap){
                    if(arr[i] > arr[i + gap]){
                        swap(arr, i, i + gap);
                    }else break;
                }
            }
            gap = gap/2;
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
