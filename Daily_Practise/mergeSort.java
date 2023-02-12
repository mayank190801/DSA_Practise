import java.util.Arrays;

public class mergeSort {
    public static void main(String[] args) {
        int[] arr = { 2, 7, 10, 1, 4,  8, 5, 3};
//        mergeSort(arr);
//        System.out.println(Arrays.toString(arr));
        int[] tarr = {1,5,10,3,7,11};
        sorter(tarr, 0,2,3 ,5);
        System.out.println(Arrays.toString(tarr));
    }

    //first apply it on normal array simple as that bro please right??
    //Using gap method -- really new method, seen it for the first time for sure -- learn and grow brother







    public static void sorter(int[] arr, int fs, int fe, int ss, int se){

    }

    public static void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] mergeSort(int[] arr){
        //base condition
        int len = arr.length;
        if(len <= 1) return arr;

        //diving
        int middle = len/2;
        int[] fhalf = new int[middle];
        int[] shalf = new int[len - (middle)];

        int mi = 0;
        for(int i = 0; i < fhalf.length; i++){  //this makes some sense for sure
            fhalf[i] = arr[mi];
            mi++;
        }
        for(int i = 0; i < shalf.length; i++){
            shalf[i] = arr[mi];
            mi++;
        }

        //sorting
        int[] one = mergeSort(fhalf);
        int[] two = mergeSort(shalf);

        //merging
        mi = 0;
        int oi = 0;
        int ti = 0;

        while(mi < len){
            int val1 = oi == one.length ? Integer.MAX_VALUE : one[oi];
            int val2 = ti == two.length ? Integer.MAX_VALUE : two[ti];

            if(val1 < val2) oi++; else ti++;
            arr[mi] = Math.min(val1, val2);
            mi++;
        }

        return arr;
    }
}
