public class kthLargest {

    //sir solved this using iterative one, i did it using recursion
    //he return pidx from partition function and check it again and again
    //simple as that bois for sure


    //i have to bring quicksort from the previous code in here
    //and i try to use partitioning as a method of binary search bois
    //this below code did worked bois!!!!!!
    public int findKthLargest(int[] nums, int k) {

        //kth largest index wise mention kro pehle
        int index = nums.length - k;
        int answer = quickSort(nums, 0, nums.length-1, index);
        return answer;
    }

    public static void swap(int[] arr, int left , int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    //we gotta sort this array using quickSort
    //inplace for sure, bitches
    public int quickSort(int[] nums, int l, int e, int k){

        if(l > e) return -1;

        //------partitioning code bois ---------//
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
        b++;
        
        if(b == k){
            return nums[b];
        }
        
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if(k < b){
            left = quickSort(nums, l, b-1, k);
        }else{
            right = quickSort(nums, b+1, e, k);
        }
        
        return left != Integer.MAX_VALUE ? left : right;
        
    }

}
