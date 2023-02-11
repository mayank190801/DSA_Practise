class Solution {

	//so the code is definitely accepted bruh!! (using ngel and nger, yuhoo)
    public int trap(int[] height) {

    	//let's try solving this problem with ngel an nger
    	int total = 0;
    	Stack<Integer> stack = new Stack<>();

    	int n = height.length;
    	for(int i = 0; i <= n; i++){
    		int val = i == n ? 0 : height[i];

    		while(!stack.isEmpty() && height[stack.peek()] < val){
    			int lger = i == n ? -1 : i;
    			int cheight = height[stack.pop()];    			
    			int lsel = stack.isEmpty() ? -1 : stack.peek();

    			//now i have to stuf
    			int hlger = lger == -1 ? 0 : height[lger];
    			int hlsel = lsel == -1 ? 0 : height[lsel];

    			int min = Math.min(hlger, hlsel);
    			if(min < cheight) continue;

    			//after this
    			int total += Math.abs(min - cheight) * (lger - lsel - 1);
    		}

    		stack.push(i);
    	}

    	return total;

        
    }
}