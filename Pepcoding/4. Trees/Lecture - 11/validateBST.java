public class validateBST {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //validate BST, simple as that
    //fast as fuck boi
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    //helper function with range and all that shit 
    public boolean helper(TreeNode root, long left, long right){
        if(root == null) return true;

        if(!(root.val < right && root.val > left)) return false;
        
        return helper(root.left, left, root.val) && helper(root.right, root.val, right);
    }

    //CODING USING SIR METHOD

    //FIRST METHOD
    //PRETTY ANNOYING CODE FOR SURE MAN
    // public class isvpair{
    //     boolean isbst = false;
    //     long min = Long.MAX_VALUE;
    //     long max = Long.MIN_VALUE;
    // }

    // public boolean isValidBST(TreeNode root){
    //     return isValidBST_(root).isbst;
    // }

    // public isvpair isValidBST_(TreeNode root){
    //     if(root == null) return new isvpair();
    //     isvpair l = isValidBST_(root.left);

    //     if(!l.isbst){
    //         return l;
    //     }

    //     isvpair r= isValidBST_(root.right);
    //     if(!r.isbst){
    //         return r;
    //     }

    //     isvpair mpair = new isvpair();
    //     if(root.val > l.max && root.val < r.min){
    //         mpair.isbst = true;
    //     }
    //     mpair.min = Math.min(l.min, root.val);
    //     mpair.max = Math.max(root.val, r.max);

    //     return mpair;
    // }

    
}
