public class mergeSort{
    public static void main(String[] args) {
        
    }

    //let's code our own mergeSort for a moment boi (both types, try going forward with it)
    //then your own quickSort
    public int[] sortArray(int[] nums) {
        mergeSort(nums);
        return nums;   
    }

    //we will then solve inversion count with out own method for sure
    //not a impossible thing to do, but definitely give it your shot
    //now just follow the steps bois
    public void mergeSort(int[] nums){
        
        //base case
        if(nums.length <= 1){
            return;
        }

        //divide 
        int middle = (0 + nums.length)/2;
        int[] left = new int[middle];
        int[] right = new int[nums.length-middle];
        
        for(int i = 0; i < middle; i++){
            left[i] = nums[i];
        }

        for(int j = middle; j < nums.length; j++){
            right[j-middle] = nums[j];
        }

        
        //sort
        mergeSort(left);
        mergeSort(right);

        //merge
        mergeLeftRight(nums, left, right);

    }

    //the merging function basically bois
    public void mergeLeftRight(int[] nums, int[] left, int[] right){
        //simple shit bois, just put this function to work now
        int s1 = 0;
        int s2 = 0;
        int index = 0;

        //simple shit
        while(s1 != left.length && s2 != right.length){
            if(left[s1] < right[s2]){
                nums[index++] = left[s1];
                s1++;
            }else{
                nums[index++] = right[s2];
                s2++;
            }
        }

        vghj//simple shit 
        while(s1 != left.length){
            nums[index++] = left[s1];
            s1++;
        }

        //simple shit
        while(s2 != right.length){
            nums[index++] = right[s2];
            s2++;
        }

    }


    //GOTTA FIGURE OUT THE INPLACE MERGING AND SHIT
    //ASAP
    //FOR RIGHT NOW HE TOLD PRETTY BASIC METHOD
    //YOU FIGURE THE OTHER ONE YOUR OWN WHEN YOU CAME BY IT



    // //let's code this down 
    // public static void mergeSort(int[] nums, int si, int ei) {
    //     if(si > ei) return;
    //     int mid = (si + ei)/2;

    //     mergeSort(nums, si, mid);
    //     mergeSort(nums, mid+1, ei);
    //     merge2ArrayOutplace(nums, si, ei, mid);

    // }

    // //this is somewhat a poor shot his mergesort
    // public static void merge2ArrayOutplace(int[] nums, int si, int ei, int mid){
    //     int s1 = si;
    //     int e1 = mid;
    //     int s2 = mid+1;
    //     int e2 = ei;

    //     int[] left = new int[e1-s1+1];
    //     for(int i = 0;i < left.length; i++){
    //         left[i] = nums[i];
    //     }
    //     int[] right = new int[e2-s2+1];
    //     for(int i = 0; i < right.length ;i++){
    //         right[i] = nums[i + left.length];
    //     }

    //     int p1 = 0;//left
    //     int p2 = 0;//right
    //     int p = 0;

    //     while(p1 != left.length & p2 != right.length){
    //         if(left[p1] < right[p2]){
    //             nums[]
    //         }
    //     }
    // }



}