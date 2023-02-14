import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {  //let's write the code for this bad boy
        int[] arr = { 2, 7, 10, 1, 8, 5, 3, 4};
        quickSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr){
        //pick the last element and place it at the correct pos
        helper(arr, 0, arr.length - 1);
    }

    public static void helper(int[] arr, int st, int en){
        if(st >= en) return;

        int pick = arr[en];
        int header = st;
        for(int i = st; i < en; i++){
            if(arr[i] < pick) {
                swap(arr, header, i);
                header++;
            }
        }

        swap(arr, header, en);
        helper(arr, st, header-1);
        helper(arr, header + 1, en);
        //now send other two halves for work
    }

    //swapper should be used here for sure
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
