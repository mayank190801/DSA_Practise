class Solution {

	//fucking go!
    public int maxPathSum(TreeNode root) {
    	int[] ans = new int[1];
    	ans[0] = Integer.MIN_VALUE;
    	helper(root, ans);
    	return ans[0];
    }

    //best current path iss nodes niche tak boss
    public int helper(TreeNode root, int[] ans){
    	if(root == null) return 0;

    	int leftMax = helper(root.left, ans);
    	int rightMax = helper(root.right, ans);

    	//now think about solving this question bro
    	int cans = leftMax + rightMax + root.val;
    	ans[0] = Math.max(ans[0], cans);


    	//three cases mein se best return kr do
    	int rval = 0;
    	rval = Math.max(rval, root.val);
    	rval = Math.max(rval, root.val + leftMax);
    	rval = Math.max(rval, root.val + rightMax);

    	return rval;
    }



}