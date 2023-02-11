import java.util.*;

public class Diameter {

    public static class TreeNode {
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

    //height 
    public int height(TreeNode root){
        if(root == null) return -1;
        return Math.max(height(root.left),height(root.right)) + 1;
    }

    //first case
    //using height function baby
    //O(n^2) for this case
    public int diameterOfBinaryTree(TreeNode root) {

        if(root == null) return 0;

        int ld = diameterOfBinaryTree(root.left);
        int rd = diameterOfBinaryTree(root.right);
        int currd = height(root.left) + height(root.right) + 2;

        return Math.max(Math.max(ld, rd), currd);
    }

    //second case baby
    //pretty tricky if you think about it
    //Time O(n) for this one

    static int mdia = 0;
    //only check the one who are passing, it will automatically take in
    //those which are not traversed through this way due to postorder traversal
    public int diameterOfBinaryTree(TreeNode root) {
        mdia = 0;
        height(root);
        return mdia;
    } 
    
    public int height(TreeNode root){
          if(root == null) return -1;

        int lh = height(root.left);
        int rh = height(root.right);

        //one liner coding bruh
        mdia = Math.max(mdia, lh + rh + 2);
        //this is height function only but a bit optimised for sure
        return Math.max(lh, rh) + 1;
    }


    //third case now 
    //using int array
    //the coolest of all question, working in post order for these question
    //diameter is definitely a bit tricky of all the thing
    //just rememeber the base concept and you will be good to go
    public int diameterOfBinaryTree(TreeNode root){
        int[] ans = helper(root);
         return ans[1];
      }
      
      public int[] helper(TreeNode root){
            if(root == null){
              return new int[]{-1, 0};
          }
  
          int[] left = helper(root.left);
          int[] right = helper(root.right);
  
          int[] ans = new int[2];
          ans[0] = Math.max(left[0], right[0]) + 1;
          ans[1] = Math.max(Math.max(left[1], right[1]) , left[0] + right[0] + 2);
  
          return ans;
      }
}
