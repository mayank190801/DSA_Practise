public class quickSir {
    // QUICK SORT

    public void quickSort(int[] nums, int si, int ei) {
        if (si >= ei) {
            return;
        }
        int pidx = partition(nums, si, ei, nums[ei]);
        quickSort(nums, si, pidx - 1);
        quickSort(nums, pidx + 1, ei);
    }

    public int partition(int[] nums, int si, int ei, int pval) {
        int i = si, j = si;
        while (j <= ei) {
            if (nums[i] <= pval) {
                swap(nums, i, j);
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i - 1;
    }

    public static void swap(int[] arr, int left , int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    
}
