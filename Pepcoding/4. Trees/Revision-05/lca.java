class Solution {

    //second method    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if(root == null) return null;

        if(root.val == A.val || root.val == B.val) return root;

        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);

        if(left != null && right != null) return root;
        return left == null ? right : left;
    }


    //third method
    boolean f1 = false;
    boolean f2 = false;

    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {

        f1 = false;
        f2 = false;
        TreeNode ans = helper(root, A, B);
        if(f1 && f2){
            return ans;
        }
        return null;
    }

    public TreeNode helper(TreeNode root, TreeNode A, TreeNode B){
        if(root == null) return null;

        TreeNode temp = null;
        if(root.val == A.val){
            f1 = true;
            temp = root;
        }   

        if(root.val == B.val){
            f2 = true;
            temp = root;
        }

        TreeNode left = helper(root.left, A, B);
        TreeNode right = helper(root.right, A, B);

        if(left != null && right != null) return root;
        return temp == null ? (left == null ? right : left) : temp;
    }

    //not at all method -3 not at all!! totally diff question
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        root.parent = B;

        ParentTreeNode slow = A;
        ParentTreeNode fast = A;

        while(true){
            slow = slow.parent;
            fast = fast.parent.parent;

            if(slow == fast) break;
        }

        ParentTreeNode ans = A;
        while(ans != slow){
            ans = ans.parent;
            slow = slow.parent;
        }

        root.parent = null;
        return ans;
    }


    //height babyy!! da baby??
    public int height(TreeNode node){
        if(node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int h = height(root);
        TreeNode ans = lcaDeepest(root, h);
        return ans;
    }

    public TreeNode lcaDeepest(TreeNode root, int h){
        if(root == null) return null;
        if(h == 0){
            return root;
        }

        TreeNode left = lcaDeepest(root.left, h-1);
        TreeNode right = lcaDeepest(root.right, h-1);

        if(left != null && right != null) return root;
        return left == null ? right : left;
    }

}

















































