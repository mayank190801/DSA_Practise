class Solution {

	static int max = 0;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
    	max = 0;
    	counter_(root, n, x);
        if(max > n/2) return true; else return false;
    }

    public int counter_(TreeNode root, int n, int x){

    	if(root == null) return 0;

    	int left = counter_(root.left, n, x);
    	int right = counter_(root.right, n, x);


    	if(root.val == x){
    		max = Math.max(left, right);
    	}

    	if(root.left != null && root.left.val == x){
    		max = Math.max(max, n - left);
    	}

    	if(root.right != null && root.right.val == x){
    		max = Math.max(max, n - right);
    	}

    	return left + right + 1;
    }



}