class Solution {

	//let's figure that out now no?
	//definitely in post order traversal for sure
    public TreeNode removeLeafNodes(TreeNode root, int target) {
    	TreeNode dummy = new TreeNode(-1);
    	dummy.left = root;

    	leafNode_(dummy, target);
    	TreeNode ans = dummy.left;
    	dummy.left = null;

    	return ans;
    }

    public boolean leafNode_(TreeNode root, int target){
    	if(root == null) return false;	

    	//something for us for sure!! (really interesting)
    	boolean left = leafNode_(root.left, target);
    	boolean right = leafNode_(root.right, target);

    	if(left && root.left.val == target){
    		root.left = null;
    	}

    	if(right && root.right.val == target){
    		root.right = null;
    	}

    	//simple
    	if(root.left == null && root.right == null) return true;
    	return false;
    }

    //if left is leaf node and val target
    //remove and it

    //if current is leaf node
    //we can put dummy node if i want



}