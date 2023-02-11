public class BalancedBinaryTree {
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    //let's figure this out from here and out
    //it got accepted lol, i am pretty good as far as i think 
    //not really bad heh
    public boolean isBalanced(TreeNode root) {
        int ans = helper(root);
        return ans == -1 ? false : true;
    }

    //simple height function bois
    public int helper(TreeNode root){
        if(root == null) return 0;

        //doing this to stop calls from happening
        int left = helper(root.left);
        if(left == -1) return -1;

        //pretty cool way of doing this shit
        int right = helper(root.right);
        if(right == -1) return -1;
        
        if(Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }

    //LET'S SEE SIR FUNCTION BOI


}
