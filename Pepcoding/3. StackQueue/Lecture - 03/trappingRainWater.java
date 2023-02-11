import java.util.Stack;

class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        int current = 0;

        //now move on 
        //simple shit for sure
        //in freakin single iteration

        for(int i = 0; i < height.length; i++){
            while(!stack.isEmpty() && height[stack.peek()] < height[current]){
                int top = stack.pop();
                if(stack.isEmpty()) break;

                //simple bitchy logic thing was there only
                int boundedHeight = Math.min(height[current], height[stack.peek()]) - height[top];
                int distance = current - stack.peek() -1;
                ans += boundedHeight * distance;
            }   
            stack.push(current++);
        }

        return ans;
    }
}