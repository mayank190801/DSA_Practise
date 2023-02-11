class Solution {

	//let's try solving this bad boi for sure baby
    public int[] nextGreaterElements(int[] nums) {

    	int n = nums.length;
    	int[] ans = new int[n];
    	Arrays.fill(ans, -1);
    	Stack<Integer> stack = new Stack<>();

    	for(int i = 0; i < 2 * n; i++){
    		int val = nums[i%n];

    		while(!stack.isEmpty() && nums[stack.peek()] < val){
    			int idx = stack.pop();
    			ans[idx] = nums[i];
    		}

    		stack.push(i%n);
    	}

    	return ans;
    }

}