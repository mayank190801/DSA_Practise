public class Solution {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */

	//please think thoda sa for the solution no matter what!! 
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

    	if(root == null) return null;

    	TreeNode ans = helper_(root, p);
    	if(ans.val == Integer.MAX_VALUE) return null;
    	return ans;
    	
    }

    public TreeNode helper_(TreeNode root, TreeNode p){
    	if(root == null) return null;

    	TreeNode right = helper_(root.right, p);
    	TreeNode left = helper_(root.left, p);

    	//and the current one
    	TreeNode curr = root.val <= p.val ? null : root;

    	//now compare and return the closet one to p
    	TreeNode ans = new TreeNode(Integer.MAX_VALUE);
    	if(right != null && ans.val > right.val) {
    		ans = right;
    	}

    	if(curr != null && ans.val > curr.val) {
    		ans = curr;
    	}

    	if(left != null && ans.val > left.val) {
    		ans = left;
    	}

    	return ans;
    }


}