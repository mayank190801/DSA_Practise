class Solution {

    //simple dfs could solve this question for sure
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        int[] ans = new int[1];
        helper(node, 0, ans);
        return ans[0];
    }

    public void helper(TreeNode node, int curr, int[] ans){
        curr = curr*10 + node.val;

        if(node.left == null && node.right == null){
            System.out.println(curr);
            ans[0] = ans[0] + curr;
            return;
        }

        if(node.left != null)
            helper(node.left, curr, ans);

        if(node.right != null)
            helper(node.right, curr, ans);
    }

}