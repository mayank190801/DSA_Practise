class Solution {
	//think once how you could do it 
    public void flatten(TreeNode root) {
    	if(root == null) return;

    	//helper function required
    	helper(root);
    }

    public TreeNode helper(TreeNode root){
    	if(root.left == null && root.right == null) return root;

    	//keep the track of last fucking node no matter how
    	TreeNode prev = null;

    	if(root.left != null){
    		TreeNode last = helper(root.left);
    		TreeNode tempRight = root.right;
    		root.right = root.left;
    		root.left = null;
    		last.right = tempRight;

    		return helper(tempRight);
    	}else{
    		return helper(root.right);
    	}
    }

}