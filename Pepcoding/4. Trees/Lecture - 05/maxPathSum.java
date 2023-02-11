public class maxPathSum{

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

    //solve this bad boy
    //max path sum

    //when you are facing such random stupid min ka min errors
    //try leveling it up to long and shit, and it won't create such errors in future
    //having a team with such brainy techniques helps
    long ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        if(root == null) return 0;
        long dummy = helper(root);
        return (int)ans;
    }

    
    public long helper(TreeNode root){
        if(root == null) return Integer.MIN_VALUE;
        long lv = helper(root.left);
        long rv = helper(root.right);
        
        //checking for the static answer in post order
        //static answer shit is crazy for sure man, i love it 
        ans = Math.max(ans,root.val);
        ans = Math.max(ans, Math.max(lv,rv) + root.val);
        ans = Math.max(ans, lv + rv + root.val);

        //returning what we want in every case
        return Math.max((Math.max(lv, rv) + root.val), root.val);
    }

    //rather than using static, you could use int[] array with space of two,
    //to return , return and answer value for sure, pretty cool if you ask me
    //trees are a brainer for sure
}