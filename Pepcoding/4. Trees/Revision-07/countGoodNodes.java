class Solution {


    public int goodNodes(TreeNode root) {
    	return goodNodes_(root, Integer.MIN_VALUE);
    }

    public int goodNodes_(TreeNode root, int max){
    	if(root == null){
    		return 0;
    	}

    	int count = 0;
    	if(root.val >= max) count++;
    	int nmax = Math.max(max, root.val);

    	count += goodNodes_(root.left, nmax);
    	count += goodNodes_(root.right, nmax);

    	return count;
    }

}