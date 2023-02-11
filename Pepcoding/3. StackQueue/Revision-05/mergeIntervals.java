class Solution {

    public int[][] merge(int[][] intervals) {
    	//sorting is v.imp
    	Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

    	//what should i use huh?
    	Stack<Integer> st = new Stack<>();
    	st.push(intervals[0][0]);
    	st.push(intervals[0][1]);

    	int n = intervals.length();
    	for(int i = 1; i < n; i++){    		
    		//now solving this ahead
    		int start = intervals[i][0];
    		int end = intervals[i][1];

    		int last = st.pop();
    		if(start > last){
    			st.push(last);
    			st.push(start);
    			st.push(end);
    		}else{
    			st.push(Math.max(last, end));
    		}
    	}

    	// System.out.println(st);
    	//now convert this to something eatable for sure
    	int[][] ans = new int[st.size()/2][2];
    	int idx = st.size()/2;
    	while(!st.isEmpty()){
    		ans[idx][1] = st.pop();
    		ans[idx][0] = st.pop();
    	}
    	
    	return ans;
    }

}