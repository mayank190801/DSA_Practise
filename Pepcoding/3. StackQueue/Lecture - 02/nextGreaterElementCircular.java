import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        //solve this one baby
        //same thing just twice times
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[nums.length];

        for(int i= 0; i < nums.length * 2; i++){
            int val = nums[i%nums.length];

            while(!stack.isEmpty() && nums[stack.peek()] < val){
                int curr = stack.peek();
                ans[curr] = val;
            }

            if(i < nums.length){
                stack.push(i);
            }
        }

        return ans;
    }
}