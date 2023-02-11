class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
    	//find index wise nger for this questio first
    	int n = nums.length;
    	int[] ans = new int[n];  //store indexes
    	Stack<Integer> stack = new Stack<>();

    	for(int i = 0; i <= n; i++){
    		int val = i == n ? Integer.MAX_VALUE : nums[i];

    		while(!stack.isEmpty() && nums[stack.peek()] < val){
    			int idx = stack.pop();
    			ans[idx] = i;
    		}

    		stack.push(i);
    	}


    	//after this answer creation is imp!!! (convert and make some)
    	int[] maxWin = new int[n - k + 1];
    	for(int i = 0; i < n - k + 1; i++){
    		int j = i;
    		while(j < i + k){
    			maxWin[i] = Math.max(maxWin[i], arr[j]);
    			j = ans[j];
    		}
    	}

    	return maxWin;
    }
}