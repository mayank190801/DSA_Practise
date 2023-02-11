class Solution {

    //soch ek baar lauda bc, kaise hoga ye solve for sure? Huh??
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }

        if(root.val > val){
            if(root.right == null){
                root.right = new TreeNode(val);
            }else
                root.right = insertIntoBST(root.right, val);

        }else{
            if(root.left == null){
                root.left = new TreeNode(val);
            }else
                root.left = insertIntoBST(root.left, val);
        }     

        return root;
    }



}