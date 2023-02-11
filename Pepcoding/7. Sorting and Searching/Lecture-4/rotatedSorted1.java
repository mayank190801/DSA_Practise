public class rotatedSorted1{

    public static void main(String[] args) {
        
    }

    //smaller code without duplicates!!!!! (Important bois)
    //set one point as reference and try matching your answer with that bad boii 

    //LESS CODE TO MAKE IT EASIER 
    //BY SIR 
    public int search(int[] nums, int target) {
        int si = 0;
        int ei = nums.length -1;
        while(si <= ei){
            //simple as fuck code boi, why don't you get that no?
            //exact same logic as mine, but his implementation skills 
            //are pretty op for sure man
            int mid = ei - (ei-si)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[si] < nums[mid]){
                if(target >= nums[si] && target < nums[mid])
                    ei = mid-1;
                else   
                    si = mid+1;
            }else{
                if(target <= nums[ei] && target > nums[mid])
                    si = mid+1;
                else
                    ei = mid-1;
            }


        }

    }




    //let's sovlve this bad boi
    //this is disgust for sure my man, ydk how to sovle this fucked up 
    //question, and you forget how to build the damn logic and solve this bad boy in here
    //i am really pissed for sure
    public int search(int[] nums, int target) {
        int s = nums[0];
        int e = nums[nums.length-1];

        int left = 0;
        int right = nums.length-1;

        while(left <= right){
            int middle = right - (right - left)/2;
            if(target == nums[middle]) return middle;

            if(nums[middle] < e){
                if(nums[middle] < target && target <= e){
                    left = middle+1;
                    s = nums[middle];
                }else{
                    right = middle-1;
                    e = nums[middle];
                }
            }else{
                if(nums[middle] > target && target >= s){
                    left = middle+1;
                    s = nums[middle];
                }else{
                    right = middle-1;
                    e = nums[middle];
                }
            }
        }

        return -1;
    
    }





}