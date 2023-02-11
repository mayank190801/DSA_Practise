public class delete{
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

    public static void main(String[] args) {
        
    }
    
    //think for this one
    //beautiful logic man
        
    //DELETE INTO BST
    public TreeNode deleteNode(TreeNode root, int key) {

        if(root == null) return null;
        //most brilliant part of the code is here
        //he relies truly on bst , as well as recursion faith for sure
        if(root.val == key){
            if(root.left == null || root.right == null){
                return root.left == null ? root.right : root.left;
            }
            //simple as that
            //remember that
            int mval = max(root.left);
            root.val = mval;
            root.left = deleteNode(root.left, mval);
            
        }else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }else{
            root.left = deleteNode(root.left, key);
        }

        return root;
    }

    //beautiful code for bst baby
    //definitely very less traversals for sure
    public int max(TreeNode root){
        if( root.right == null){ 
            return root.val;
        }
        return max(root.right);
    }






}