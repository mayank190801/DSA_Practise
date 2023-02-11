class Solution {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
    	int n = popped.length;
    	Stack<Integer> stack = new Stack<>();

    	int idx = 0;
    	for(int i= 0; i < n; i++){  
    		while(stack.isEmpty() || popped[i] != stack.peek()){
    			if(idx >= n) break;
    			stack.push(pushed[idx]);
    			idx++;

    		}

    		if(popped[i] != stack.peek()) return false;
    		stack.pop();
    	}

    	return true;
        
    }

}