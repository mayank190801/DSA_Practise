import java.util.Arrays;

public class sorting001 {
    public static void main(String[] args) {
        System.out.println("hey there I am coding in java back again!!");
        //time space stability place application  --- these are the stuff you should know
        int[] arr = { 2, 7, 10, 1, 4,  8, 5, 3};
        insertionSort(arr);
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
}
