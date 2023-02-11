public class mergeSir {

    public static void mergeSort(int[] nums, int si, int ei) {
        if (si >= ei) {
            return;
        }
        int mid = (si + ei) / 2;
        mergeSort(nums, si, mid);
        mergeSort(nums, mid + 1, ei);
        merge2ArraysOutplace(nums, si, ei, mid);
    }

    public static void merge2ArraysOutplace(int[] nums, int si, int ei, int mid) {
        int s1 = si;
        int e1 = mid;
        int s2 = mid + 1;
        int e2 = ei;
        int[] left = new int[e1 - s1 + 1];
        for (int i = 0; i < left.length; i++) {
            left[i] = nums[s1 + i];
        }
        int[] right = new int[e2 - s2 + 1];
        for (int i = 0; i < right.length; i++) {
            right[i] = nums[s2 + i];
        }
        int p1 = 0;// left
        int p2 = 0;// right
        int p = s1;// own
        while (p1 != left.length && p2 != right.length) {
            if (left[p1] < right[p2]) {
                nums[p] = left[p1];
                p1++;
            } else {
                nums[p] = right[p2];
                p2++;
            }
            p++;
        }
        while (p1 < left.length) {
            nums[p] = left[p1];
            p1++;
            p++;
        }
        while (p2 < right.length) {
            nums[p] = right[p2];
            p2++;
            p++;
        }
    }

    // MERGE 2 ARRAYYS INPLACE
    public static void merge2ArraysInplace(int[] nums, int si, int ei, int mid) {
        int p1 = si;
        int p2 = mid + 1;
        while (p1 < p2 && p2 <= ei) {
            if (nums[p1] < nums[p2]) {
                p1++;
            } else {
                int val = nums[p2];
                int i = p2;
                while (i > p1) {
                    nums[i] = nums[i - 1];
                    i--;
                }
                nums[p1] = val;
                p1++;
                p2++;
            }
        }
    }
    
}
