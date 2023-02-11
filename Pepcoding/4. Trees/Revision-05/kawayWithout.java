class Solution {

	//let's figure out this solution boss
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    	ArrayList<Integer> ans = new ArrayList<>();
        helper(root, target, k, ans);
        return ans;
    }

    public int helper(TreeNode root, TreeNode target, int k, ArrayList<Integer> ans){
    	if(root == null) return;

    	if(root.val == target.val){
    		kDown(root, null, k, ans);
    		return k-1;
    	}

    	//otherwise simply 
	    int leftVal = helper(root.left, target, k, ans);
	    if(leftVal >= 0){
	    	kDown(root, root.left, target, leftVal, ans);
	    	return leftVal - 1;
	    }

    	int rightVal = helper(root.right, target, k, ans);
    	if(rightVal >= 0){
    		kDown(root, root.right, target, rightVal, ans);
	    	return rightVal - 1;	
    	}

    	return -1;
    }

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




}