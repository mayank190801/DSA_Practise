public class insert{
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


    //INSERT INTO BST
    //MY POOR CODE BABYYYYYY

    // public TreeNode insertIntoBST(TreeNode root, int val) {
    //     if(root == null) return new TreeNode(val);
    //     insertIntoBST_(root, val, Integer.MIN_VALUE, Integer.MAX_VALUE);
    //     return root;
    // }

    //some issues in this logic for sure
    public void insertIntoBST_(TreeNode root, int val, int leftVal , int rightVal){
        if(val < root.val && val > leftVal){
            if(root.left == null){
                TreeNode node = new TreeNode(val);
                root.left = node;
                return;
            }else{
                insertIntoBST_(root.left, val, leftVal, root.val);
            }
        }

        if(val > root.val && val < rightVal){
            if(root.right == null){
                TreeNode node = new TreeNode(val);
                root.right = node;
                return;
            }else{
                insertIntoBST_(root.right, val, root.val, rightVal);
            }
        }
        
        return;
    }


    //SIR VERSION OF CODE IS FUCKED UP FOR SURE
    //TO simple to be real for sure man/
    //this hurts toooooo much
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }

        if(root.val < val){
            root.right = insertIntoBST(root.right, val);
        }else{
            root.left = insertIntoBST(root.left, val);
        }

        return root;
    }

}