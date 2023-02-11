
class Solution{
    static int sortingCost(int N, int arr[]){
        
    	Map<Integer, Integer> count = new HashMap<>();
    	int ans = 0;
    	for(int i= 0; i < N; i++){
    		int curr = arr[i];

    		if(count.containsKey(curr - 1)){
    			count.put(curr, count.get(curr - 1) + 1);
    		}else{
    			cout.put(curr, 1);
    		}
    	}

    	for(int key : count.keySet()){
    		ans = Math.max(ans, count.get(key));
    	}

    	return N - ans;
    }
}