class Solution {

    //first the O(n^2) approach
    public int height(TreeNode node){
        if(node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        int heightLeft = height(root.left);
        int heightRight = height(root.right);

        int leftAns = diameterOfBinaryTree(root.left);
        int rightAns = diameterOfBinaryTree(root.right);
    
        return Math.max(leftAns, Math.max(rightAns, heightLeft + heightRight));
    }


    //now think of an better approach for this question, just don't find the answer again and again
    //height should be called no? 

     public int diameterOfBinaryTree(TreeNode root) {
        int[] ans = new int[1];
        helper(root, ans);
        return ans[0];
    }

    public int helper(TreeNode node, int[] ans){
        if(node == null) return 0;
        int leftH = helper(node.left, ans);
        int rightH = helper(node.right, ans);

        ans[0] = Math.max(leftH + rightH , ans[0]);
        return Math.max(leftH, rightH) + 1;
    }


}