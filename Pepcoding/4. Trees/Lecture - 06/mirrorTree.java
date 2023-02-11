import PathSum.TreeNode;

public class mirrorTree {
    public static void main(String[] args) {
        
    }
    
    //same tree code (by me)
    //hence this code works
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null || p.val != q.val ) return false;
 
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    //basic level questions in here bois
    //INVERT TREE CODE
    //by me, works too
    public TreeNode invertTree(TreeNode root) {

        if(root == null) return null;

        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root;
    }

    //SYMMETRIC FUNCTION BABY
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return helper(root.left, root.right);
    }
    public boolean helper(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null || p.val != q.val ) return false;
 
        return helper(p.left, q.right) && helper(p.right, q.left);
    }

}
