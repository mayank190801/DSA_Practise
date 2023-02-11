public class sort012 {

    public static void main(String[] args) {
        
    }

    //let's do this bois
    //yehi socha tha boss, clearnly implemented boss
    //just like a boss bruh!!! keep solving problems and keep getting better
    //for sure, and keep hustling bruh
    public void sortColors(int[] nums) {
        int pt = 0;
        int zero = 0;
        int two = nums.length-1;

        while(pt <= two){
            if(nums[pt] == 0){
                swap(nums, zero, pt);
                zero++;
                pt++;
            }else if(nums[pt] == 1){
                pt++;
            }
            else{
                //swap with two and reduce it by one 
                swap(nums, pt, two);
                two--;
            }
        }
        
    }

    public void swap(int[] arr, int left , int right){
        arr[left] = (arr[left] + arr[right]) - (arr[right] = arr[left]);
    }

}
