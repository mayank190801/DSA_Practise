public class prevPermutation {

    
    //never say never
    public int[] prevPermOpt1(int[] arr) {
        //3 4 9 7 8 4 2 1 1 3 4 (just think about this one)
        int len = arr.length;
        int i = len-2;

        while(i >= 0 && arr[i] <= arr[i+1]){
            i--;
        }

        //now next element is bigger for sure
        if(i == -1) return arr;

        //lol after so many tries it got actually accepted for sure
        //this is pretty cool for sure man!!! Not at all sad or unsad
        int ele = arr[i];
        int index = i+1;
        boolean flag = true;
        //could have been easier with while loop, just needed to add one more
        //check in that question bc
        for(int j = len-1; j > i; j--){
            if(arr[j] < ele){
                if(!flag)
                    if(arr[j] != arr[index]) break;
                
                index = j;
                flag = false;
            }
        }

        swap(arr, i, index);
        return arr;

    }
    
    public void swap(int[] nums, int i , int j){
        nums[i] = (nums[i] + nums[j]) - (nums[j] = nums[i]);
    }   
}
