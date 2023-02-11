class Solution {


    public TreeNode sortedArrayToBST(int[] nums) {
        return helper_(0, nums.length - 1, nums);
    }

    //you need for sure
    public TreeNode helper_(int l, int r, int[] nums){
        if(l > r) return null;

        int mid = (l + r)/2;
        int val = nums[mid];

        TreeNode root = new TreeNode(root);
        root.left = helper_(root, mid + 1, r, nums);
        root.right = helper_(root, l, mid - 1, nums);
    
        return root;
    }


}