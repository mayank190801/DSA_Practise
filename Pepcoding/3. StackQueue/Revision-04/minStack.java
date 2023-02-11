class MinStack {

	Stack<Long> st;
	long min = 
    public MinStack() {
    	st = new Stack<>();
        min = 0;   //will be updated when needed
    }
    
    public void push(int vall) {

    	long val = vall;
    	if(st.isEmpty()){
    		st.push(val);
    		min = val;
    	}

    	if(val < min){
    		st.push(2*val - min);
    		min = val;
    	}else{
    		st.push(val);
    	}
        
    }

    public void pop() {
    	int val = (int)(st.pop());
    	if(val < min){
    		//update min simple
    		long nmin = 2 * min - val;
    		min = nmin;
    	}

    	return val;
    }
    
    public int top() {
    	int val = (int)(st.peek());
    	return val;        
    }
    
    public int getMin() {
        return (int)(min);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */