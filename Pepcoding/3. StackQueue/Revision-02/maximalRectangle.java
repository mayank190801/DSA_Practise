class Solution {
    public int maximalRectangle(char[][] matrix) {
    	//let's solve it one more time boss

    	int rows = matrix.length;
    	int cols = matrix[0].length;

    	int[] arr = new int[cols];

    	int fans = 0;
    	for(int i = 0; i < rows; i++){
    		//update arr simply
    		for(int j = 0; j < cols; j++){
    			arr[j] = matrix[i][j] == '1' ? arr[j] + 1 : 0;
    			int area = maxHisto(arr);
    			fans = Math.max(fans, area);
    		}
    	}

    	return fans;

    }

    public int maxHisto(int[] a){
    	int n = a.length;
    	Stack<Integer> stack = new Stack<>();
	    int fans = 0;

	    for(int i= 0; i <= n; i++){
	    	int val = i == n ? Integer.MIN_VALUE : a[i];

	    	while(!stack.isEmpty() && a[stack.peek()] > val){
	    		int nserIdx = i;
	    		int height = a[stack.pop()];
	    		// while(!stack.isEmpty() && height == a[stack.peek()]) stack.pop();
	    		int nselIdx = stack.isEmpty() ? -1 : stack.peek();

	    		int area = height * (nserIdx - nselIdx - 1);
	    		fans = Math.max(fans, area);
	    	}

	    	stack.push(i);
	    }

    	return fans;
    }


    
}