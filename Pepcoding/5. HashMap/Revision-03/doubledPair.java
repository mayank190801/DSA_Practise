class Solution {


    public boolean canReorderDoubled(int[] arr) {
    	
    	Arrays.sort(arr);
    	HashMap<Integer, Integer> count = new HashMap<>();
    	int n = arr.length;
    	for(int i = 0; i < n; i++){
    		if(arr[i] > 0) break;

    		int curr = arr[i];
    		if(count.containsKey(curr * 2)){
    			count.put(curr * 2, count.get(curr * 2) - 1);
    			if(count.get(curr * 2) == 0) count.remove(curr * 2);
    		}else{
    			count.put(curr, count.getOrDefault(curr, 0) + 1);
    		}
    	}   

    	if(count.size() != 0) return false;
    	for(int i = n-1; i >= 0; i--){
    		if(arr[i] <= 0) break;

    		int curr = arr[i];
    		if(count.containsKey(curr * 2)){
    			count.put(curr * 2, count.get(curr * 2) - 1);
    			if(count.get(curr * 2) == 0) count.remove(curr * 2);
    		}else{
    			count.put(curr, count.getOrDefault(curr, 0) + 1);
    		}
    	}   

    	return count.size() == 0;
    }


}