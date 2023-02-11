class Solution {

	//could be solved easily with level order traversal for sure
    public int findBottomLeftValue(TreeNode root) {
    	int[] ans = new int[2];
    	helper_(root, 1, ans);
    	return ans[1];
    }

    public void helper_(TreeNode root, int level, int[] ans){
    	if(root == null) return;

    	if(level > ans[0]){
    		ans[0] = level;
    		ans[1] = root.val;
    	}

    	helper_(root.left, level + 1, ans);
    	helper_(root.right, level + 1, ans);
    }

}