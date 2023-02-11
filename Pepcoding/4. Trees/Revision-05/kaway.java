class Solution {

	//now let's figure out the solution for this question no? - let's solve it brother
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		//root to node path ka code lau pehle toh
		List<TreeNode> path = rootToNodePath(root, target);

		TreeNode block = null;
		ArrayList<Integer> ans = new ArrayList<>();
		for(int i = 0; i < path.size(); i++){
			kDown(path.get(i), block, k - i, ans);
			block = path.get(i);
		}

		return ans;
    }

    //k-down function for this question
    public void kDown(TreeNode root, TreeNode block, int k, ArrayList<Integer> ans){
    	if(root == null || root == block) return;
    	if(k < 0) return;
    	
    	if(k == 0){
    		ans.add(root.val);
    		return;
    	}

    	//simply go in both direction, left and right both! 
    	kDown(root.left, block, k -1, ans);
    	kDown(root.right, block, k -1, ans);
    }


    //root to node path function
    public List<TreeNode> rootToNodePath(TreeNode root, TreeNode target){
    	if(root == null){
    		return new ArrayList<>();
    	}

    	List<TreeNode> ans = new ArrayList<>();
    	if(root.val == target.val){
    		ans.add(root);
    		return ans;
    	}


    	//otherwise find in the left
    	List<TreeNode> left = rootToNodePath(root.left, target);
    	if(left.size() > 0){
    		left.add(root);
    		return left;
    	}

    	List<TreeNode> right = rootToNodePath(root.right, target);
    	if(right.size() > 0){
    		right.add(root);
    		return right;
    	}

    	//empty return
    	return ans;
    }


}