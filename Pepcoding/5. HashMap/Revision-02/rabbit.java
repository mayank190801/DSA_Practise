class Solution {


	//let's figure this out for sure
    public int numRabbits(int[] answers) {
    	Map<Integer, Integer> map = new HashMap<>();

    	int count = 0;
    	for(int i= 0; i < n; i++){
    		int curr = answers[i];

    		if(map.containsKey(curr)){
    			if(map.get(curr) == curr + 1){
    				count += curr + 1;
    				map.remove(curr);
    			}
    		}

    		map.put(curr, map.getOrDefault(curr, 0) + 1);
    	}

    	for(int key : map.keySet()){
    		count += key + 1;
    	}

    	return count;
    }

}