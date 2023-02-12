import java.util.Arrays;

public class mergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1,3,5,7,9};
        int[] arr2 = {2,4,6,8,10,12,14,15};

        sortInplace(arr1, arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    public static void sortInplace(int[] arr1, int[] arr2) {
        double n = arr1.length;
        double m = arr2.length;

        int gap = (int)Math.ceil((n + m)/2.0);  //pretty simple I guess, this could work
        while(gap != 0){
            int i = 0;
            int j = gap;   //start from this index

            while(j < (n + m)){
                if(i < n && j < n){
                    if(arr1[i] > arr1[j]){
                        swap(arr1, arr1, i, j);
                    }
                }else if(i < n && j >= n){
                    if(arr1[i] > arr2[(int)(j-n)]){
                        swap(arr1, arr2, i, (int)(j-n));
                    }
                }else{
                    if(arr2[(int)(i-n)] > arr2[(int)(j-n)]){
                        swap(arr2, arr2, i-(int)n, j-(int)n);
                    }
                }

                i++;
                j++;
            }

            //now reduce the gap simply
            if(gap == 1) break;
            gap = (int)Math.ceil((gap)/2.0);
        }
    }

    public static void swap(int[] one, int[] two, int i, int j){
        int temp = one[i];
        one[i] = two[j];
        two[j] = temp;
    }
}
