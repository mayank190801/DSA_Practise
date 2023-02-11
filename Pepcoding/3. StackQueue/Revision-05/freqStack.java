class FreqStack {

	Map<Integer, Integer> freq = new HashMap<>();
	Map<Integer, Stack<Integer>> levels = new HashMap<>();

	int maxFreq = 0;

    public FreqStack() {
    	freq = new HashMap<>();
    	levels = new HashMap<>();	
    	maxFreq = 0;
    }
    
    public void push(int val) {
    	int nFreq = freq.getOrDefault(val, 0) + 1;

    	if(nFreq > maxFreq){
    		levels.put(nFreq, new Stack<>().add(val));
    		maxFreq = nFreq;
    	}

    	freq.put(val, nFreq);        
    }
    
    public int pop() {
    	
    	if(levels.get(maxFreq).size() == 0){
    		maxFreq--;
    	}

    	int cmax = levels.get(maxFreq).pop();
    	//reduce its 
    	freq.put(cmax, freq.get(cmax) - 1);
    	return cmax;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */