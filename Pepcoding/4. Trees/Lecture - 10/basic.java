public class basic{
    //Bst bois
    //let's do this and finish trees aaj for sure
    //except hw and revision
    //FINISH TREES FOR GOD SAKE

    //CEIL FLOOR AND SHIT CAN BE SOLVED USING O(N) approach, always remember that 
    //THIS SHOULD BE EASY ENOUGH
    
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

    //homework for the classes
    //converted sorted list into bst, try it on your own


    //DELETE INTO BST
    public TreeNode deleteNode(TreeNode root, int key) {
        
    }



}