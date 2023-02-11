public class preInorder{
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
   
    //PRE and IN creation of Tree
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //i have to properly construct a tree like this and that to be honest        
        return helper(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int ps, int pe, int ls, int le ){

        if(ps > pe){
            return null;
        }

        int i = 0;
        for(i = ls; i <= le; i++){
            if(preorder[ps] == inorder[i]){
                break;
            }
        }

        TreeNode temp = new TreeNode(preorder[ps]);
        int lcount = i - ls;
        temp.left = helper(preorder, inorder, ps+1 , ps+lcount , ls, ls +lcount-1);
        temp.right = helper(preorder, inorder, ps+lcount+1, pe, ls+lcount+1, le);
        return temp;

    }

}