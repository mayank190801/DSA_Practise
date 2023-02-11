import java.util.Random;

public class rangeSum {
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

    //most basic method bitches
    //O(n) time
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;

        int sum = 0;

        sum += rangeSumBST(root.left, low, high);
        sum += rangeSumBST(root.right, low, high);

        if(root.val <= high && root.val >= low){
            sum += root.val;
        }

        return sum;
    }

    //SIR VERSION FOR A BETTER CODE AND SHIT
    //most optimised 
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;

        //definitely much faster for sure bruh
        if(root.val <= high && root.val >= low){
            return rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high) + root.val;
        }else if(low > root.val){
            return rangeSumBST(root.right, low, high);
        }else if(high < root.val){
            return rangeSumBST(root.left, low, high);
        }

        return 0;
    }

}
