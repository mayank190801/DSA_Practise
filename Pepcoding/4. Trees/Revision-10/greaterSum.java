class Solution {

	//this actually makes a lot of sense for sure!! (do work upon it brother)
	static int ans = 0;
    public TreeNode bstToGst(TreeNode root) {
    	ans = 0;
    	helper_(root);
    	return ans;
    }

    public void helper_(TreeNode root){
    	helper_(root.right);
    	ans += root.val;
    	root.val = ans;

    	helper_(root.left);
    }

}