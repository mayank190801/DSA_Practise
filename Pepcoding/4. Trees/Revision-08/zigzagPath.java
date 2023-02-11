class Solution {


    public int longestZigZag(TreeNode root) {
    	int[] ans = new int[1];
    	helper(root, ans);
    	return ans[0];
    }

    public int[] helper(TreeNode root, int[] ans){
    	if(root == null){
    		return new int[]{0, 0};
    	}

    	int[] left = helper(root.left);
    	int[] right = helper(root.right);

    	int[] cans = new int[2];
    	cans[0] = left[1] + 1;
    	cans[1] = right[0] + 1;

    	ans[0] = Math.max(cans[0], cans[1]);
    	return cans;
    }


}