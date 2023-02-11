class Solution {
    public int leastBricks(List<List<Integer>> wall) {

    	//suppose all the times spaces comes in between
    	Map<Integer, Integer> spaces = new HashMap<>();
    	int max = 0;

    	for(List<Integer> rows : wall){
    		int len = 0;
    		for(int i= 0; i < rows.size() - 1; i++){
    			int bricks = rows.get(i);
    			len += bricks;
    			spaces.put(len, spaces.getOrDefault(len, 0) + 1);
    			max = Math.max(max, spaces.get(len));
    		}
    		
    	}

    	return wall.size() - max;
    }
}