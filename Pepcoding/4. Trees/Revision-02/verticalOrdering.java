class Solution {

	class Pair{
		int val;
		int level;

		Pair(int val, int level){
			this.level = level;
			this.val = val;
		}
	}

	//map and recursion could be used
    public List<List<Integer>> verticalTraversal(TreeNode root) {
    	Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    	List<List<Integer>> ans = new ArrayList<>();  

    	if(root == null) return;

    	int[] min = {0};
    	verticalHelper(root, 0, 0, map, min);

    	int low = min[0];

    	while(map.containsKey(low)){
    		ArrayList<Pair> clist = map.get(low);
    		Collections.sort(clist, (a,b) -> a.level == b.level ? a.val - b.val : a.level - b.level);
    		low++;
    	}

		low = min[0];
		int idx = 0;
		while(map.containsKey(low)){
			ArrayList<Integer> clist = new ArrayList<>();
			for(int i = 0; i < map.get(low).size(); i++){
				clist.add(map.get(low).get(i).val);
			}
			low++;
		}

    	return ans;
    }


    public void verticalHelper(TreeNode curr, int col, int row, Map<Integer, ArrayList<Pair>> map, int[] min){

    	if(curr == null) return;
    	min[0] = Math.min(min[0], col);

    	if(!map.containsKey(col)){
    		map.put(col, new ArrayList<>());
    	}
    	map.get(col).add(new Pair(curr.val, row));

    	verticalHelper(curr.left, col-1, row+1, map);
    	verticalHelper(curr.right, col+1, row+1, map);

    	return;
    }

}