class Solution {


    public int rob(TreeNode root) {
    	int[] ans = helper_(root);
    	return Math.max(ans[0], ans[1]);
    }

    public int[] helper_(TreeNode root){
    	if(root == null){
    		return new int[]{0, 0};
    	}

    	int[] left = helper_(root.left);
    	int[] right = helper_(root.right);

    	//now find the best answer for both cases 
    	int[] cans = new int[2];

    	//first is when we take it 
    	//0 taken 1 not taken
    	cans[0] = Math.max(cans[0], left[1] + right[1] + root.val);
    	cans[1] = Math.max(cans[1], left[0] + right[0]);
    	cans[1] = Math.max(cans[1], left[0] + right[1]);
    	cans[1] = Math.max(cans[1], left[1] + right[0]);
    	cans[1] = Math.max(cans[1], left[1] + right[1]);

    	return cans;
    }

}