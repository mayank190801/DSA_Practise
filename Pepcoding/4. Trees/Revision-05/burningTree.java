
public class burningTree{
	public List<List<Integer>> burningTree(TreeNode root, TreeNode ref) {
		//we can have a map from 0 to end onwards no?




	}

	//two more functions 
	//one helper
	//other would be allDown
	//& map for sure

	public int burningTree_(TreeNode root, TreeNode ref, Map<Integer, ArrayList<Integer>> map){
		if(root == null) return -1;

		if(root.val == ref.val){	
			allDown(root,null, 0, map);
			return 1;
		}

		int left = burningTree_(root.left, ref, map);
		if(left != -1){
			allDown(root, root.left, left, map);
			return left + 1;
		}
		
		int right = burningTree_(root.right, ref, map);
		if(right != -1){
			allDown(root, root.right, right, map);
			return right + 1;
		}

		return -1;
	}

	//simply function baby
	public void allDown(TreeNode root, TreeNode blocked, int time, Map<Integer, ArrayList<Integer>> map){
		if(root == null || root == blocked) return;

		if(!map.containsKey(time)){
			map.put(time, new ArrayList<>());
		}

		map.get(time).add(root.val);

		allDown(root.left, blocked, time + 1, map);
		allDown(root.right, blocked, time + 1, map);
	}


}

