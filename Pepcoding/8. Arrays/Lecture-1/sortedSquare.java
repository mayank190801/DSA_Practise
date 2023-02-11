public class sortedSquare {

    //METHOD 1 - Basic sorting and shit
    //METHOD 2 - O(n) single traversal //extra space for answer is doable

    //LOL NOT POSSIBLE, path gya code bc
    //METHOD 3 - O(n) single traversal + //NO EXTRA SPACE (try doing in inplace boi)

    //let's solve it in O(n)
    //two pointers baby, they are used a lot for sure, be used to them now
    public int[] sortedSquares(int[] nums) {
        int l = 0;
        int r = nums.length-1;

        int[] answer = new int[nums.length];
        int index = nums.length-1;

        while(l <= r){
            if(Math.abs(nums[l]) < Math.abs(nums[r])){
                answer[index] = nums[r] * nums[r];
                r--;
            }else{
                answer[index] = nums[l] * nums[l];
                l++;
            }
            index--;
        }

        return answer;
    }
    
}
