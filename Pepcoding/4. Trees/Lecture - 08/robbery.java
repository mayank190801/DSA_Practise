public class robbery {
    public static void main(String[] args) {
        
    }

    //think about this robbery for a second and move on
    public int rob(TreeNode root) {
        int[] answer = rob_(root);
        return Math.max(answer[0], answer[1]);
    }

    public int[] rob_(TreeNode root){
        if(root == null){
            return new int[]{0,0};
        }

        int[] left = rob_(root.left);
        int[] right = rob_(root.right);

        int[] ans = new int[2];
        //chori kri
        ans[0] = root.val + left[1] + right[1];
        
        //chori ni kri
        // ans[1] = Math.max(ans[1], left[0] + right[1]);
        // ans[1] = Math.max(ans[1], left[1] + right[0]);
        // ans[1] = Math.max(ans[1], left[0] + right[0]);
        // ans[1] = Math.max(ans[1], left[1] + right[1]);
        //simple one liner baby
        ans[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return ans;
    }
    
}
