class Solution {

	//figure this out as fast as you can boi! (please and move on from this asap!!)
    public TreeNode deleteNode(TreeNode root, int key) {

    	if(root == null) return;

    	if(root.val == key){
    		if(root.left == null || root.right == null){
    			return root.left == null ? root.right : root.left;
    		}

    		int mval = max(root.left);
    		root.val = mval;
    		root.left = deleteNode(root.left, mval);

    	}else if(root.val < key){
    		root.right = deleteNode(root.right, key);
    	}else{
    		root.left = deleteNode(root.left, key);
    	}

    	return root;
    }

    public int max(TreeNode node){
    	while(node.left != null){
    		node = node.left;
    	}
    	return node.val;
    }


}