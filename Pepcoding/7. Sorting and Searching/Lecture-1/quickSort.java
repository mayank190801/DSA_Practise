public class quickSort {

    public int[] sortArray(int[] nums) {
        
    }

    public static void swap(int[] arr, int left , int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    //we gotta sort this array using quickSort
    //inplace for sure, bitches
    public void quickSort(int[] nums, int l, int e){

        if(l >= e) return;

        int b = l-1;
        int i = l;

        int pivot = nums[e];

        while(i < e){
            //now we come to this eiement,
            if(nums[i] < pivot){
               swap(nums, b+1, i); 
               b++;
            }
            i++;
        }
        
        //now do this until
        swap(nums, b+1, e);
        quickSort(nums, l, b);
        quickSort(nums, b+1, e);
    }



}
