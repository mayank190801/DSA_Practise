class Solution {

	//let's figure that out 
    public int[] dailyTemperatures(int[] temp) {

    	int n = temp.length;
    	int[] ans = new int[n];
    	Stack<Integer> stack = new Stack<>();

    	for(int i= 0; i <= n; i++){
    		int val = i == n ? Integer.MAX_VALUE : temp[i];
    		while(!stack.isEmpty() && temp[stack.peek()] < val){
    			int idx = stack.pop();
    			ans[idx] = i == n ? 0 : i - idx;
    		}
    		stack.add(i);
    	}

    	return ans;
       
    }
}