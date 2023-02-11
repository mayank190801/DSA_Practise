public class greaterSumTree {
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

    //let's solve this one bois
    //GREATER SUM BST
    
    //JUST CHANGE THE TRAVERSAL DUDE
    //THAT'S IT
    public TreeNode bstToGst(TreeNode root) {
        int[] ans = new int[1];
        bstToGst_(root, ans);
        return root;
    }    

    public void bstToGst_(TreeNode root, int[] ans){
        if(root == null) return;
        bstToGst_(root.right, ans);
        ans[0] += root.val;
        root.val = ans[0];
        bstToGst_(root.left, ans);
        return;
    }

}

