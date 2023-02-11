public class create{
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

     //CREATE BALANCED BST

     public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length-1);
    }    

    public TreeNode sortedArrayToBST(int[] nums, int si, int ei) {

        if(si > ei) return null;

        int mid = (si + ei) /2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, si, mid-1);
        root.right = sortedArrayToBST(nums, mid+1, ei);

        return root;
        
    }


    

}