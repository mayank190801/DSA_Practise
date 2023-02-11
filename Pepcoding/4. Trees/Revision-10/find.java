class Solution {


    public TreeNode searchBST(TreeNode root, int val) {

        //iterative or recursive
        if(root == null) return null;

        if(root.val == val) return root;

        TreeNode left = searchBST(root.left, val);
        TreeNode right = searchBST(root.right, val);

        if(left != null || right != null){
            return left != null ? left : right;
        }

        return null;
    }


}