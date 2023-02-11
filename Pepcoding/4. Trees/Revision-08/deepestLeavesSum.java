class Solution {
    public int deepestLeavesSum(TreeNode root) {
    	int[] ans = new int[2];
    	helper_(root, 1, ans);

    	return ans[1];
    }

    public void helper_(TreeNode root, int level, int[] ans){
    	if(root == null) return;

    	if(ans[0] < level){
    		ans[0] = level;
    		ans[1] = root.val;
    	}else if(ans[0] == level){
    		ans[1] += root.val;
    	}

    	helper_(root.left, level + 1, ans);
    	helper_(root.right, level + 1, ans);
    }
}