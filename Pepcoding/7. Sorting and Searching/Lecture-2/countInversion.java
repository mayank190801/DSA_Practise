public class countInversion{

    //DOPE ASS CODE, AND IT RUNS WOW
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        long ans = mergeSort(arr);
        return ans;
    }

    
    //we will then solve inversion count with out own method for sure
    //not a impossible thing to do, but definitely give it your shot
    //now just follow the steps bois
    public static long mergeSort(long[] nums){
        
        //base case
        long ans = 0;
        if(nums.length <= 1){
            return 0;
        }

        //divide 
        int middle = (0 + nums.length)/2;
        long[] left = new long[middle];
        long[] right = new long[nums.length-middle];
        
        for(int i = 0; i < middle; i++){
            left[i] = nums[i];
        }

        for(int j = middle; j < nums.length; j++){
            right[j-middle] = nums[j];
        }

        
        //sort
        ans += mergeSort(left);
        ans += mergeSort(right);

        //merge
        ans += mergeLeftRight(nums, left, right);
        return ans;
    }

    //the merging function basically bois
    public static long mergeLeftRight(long[] nums, long[] left, long[] right){
        //simple shit bois, just put this function to work now
        int s1 = 0;
        int s2 = 0;
        int index = 0;
        long cans = 0;

        //simple shit
        while(s1 != left.length && s2 != right.length){
            if(left[s1] <= right[s2]){
                nums[index++] = left[s1];
                s1++;
            }else{
                nums[index++] = right[s2];
                s2++;
                cans += (left.length - s1);
            }
        }

        //simple shit
        while(s1 != left.length){
            nums[index++] = left[s1];
            s1++;
        }

        //simple shit
        while(s2 != right.length){
            nums[index++] = right[s2];
            s2++;
        }

        return cans;
    }
}