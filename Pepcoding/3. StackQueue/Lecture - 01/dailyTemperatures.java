import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //number of days to wait for the next best basically
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];

        for(int i = 0; i <= temperatures.length ; i++){
            int val= i == temperatures.length? Integer.MAX_VALUE : temperatures[i];

            while(!stack.isEmpty() && temperatures[stack.peek()] < val){
                int curr = stack.pop();
                ans[curr] = i == temperatures.length ? 0 : i - curr;
            }

            stack.push(i);
        }

        return ans;
    
    }
}