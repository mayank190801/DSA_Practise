public class flattenTree{
    
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

    //let's do this bad boy, and solve it
    //100% faster 
    //O(N^2)
    public void flatten(TreeNode root) {
        if(root == null) return;

        flatten(root.left);
        flatten(root.right);

        if(root.left == null && root.right == null) return;

        if(root.right == null){
            root.right = root.left;
            root.left = null;
        }

        if(root.left == null) return;

        //otherwise find the tail bois
        TreeNode tail = root.left;  
        while(tail.right != null) tail = tail.right;
        
        tail.right = root.right;
        root.right = root.left;
        root.left = null;
    }
    
    //now doing it in O(N)
    //just changing return type bois
    //flatten without manually finding tail
    //even faster approach, cause we are getting tail out of nowhere tbh
    public void flatten(TreeNode root){
        flatten_(root);
    }

    public TreeNode flatten_(TreeNode root) {
        if(root == null) return null;

        TreeNode ltail = flatten_(root.left);
        TreeNode rtail = flatten_(root.right);

        if(root.left == null && root.right == null) return root;

        if(root.right == null){
            root.right = root.left;
            root.left = null;
            return ltail;
        }

        if(root.left == null) return rtail;

        //otherwise find the tail bois
        TreeNode tail = ltail;
        tail.right = root.right;
        root.right = root.left;
        root.left = null;

        return rtail;
    }

    


}