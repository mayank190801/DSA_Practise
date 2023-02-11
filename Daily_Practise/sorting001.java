import java.util.Arrays;

public class sorting001 {
    public static void main(String[] args) {
        System.out.println("hey there I am coding in java back again!!");
        //time space stability place application  --- these are the stuff you should know
        int[] arr = { 2, 7, 10, 1, 4,  8, 5, 3};
//        insertionSort(arr);
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr){
        //so pick this element
        for(int i = 1; i < arr.length; i++){
            int curr = arr[i];
            int k;
            for(k = i; k >= 1; k--){
                if(arr[k-1] <= curr) break;
                arr[k] = arr[k-1];
            }
            arr[k] = curr;
        }
    }

    public static void selectionSort(int[] arr){
        //find the smallest element, and then replace it
        for(int i = 0; i < arr.length - 1; i++){
            int ri = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[ri]) ri = j;
            }
            swap(i, ri, arr);
        }
    }

    public static void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
