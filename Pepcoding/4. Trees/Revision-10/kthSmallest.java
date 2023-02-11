class Solution {
	//let's solve this problem buddy

	int ans = -1;
	int count = 0;
    public int kthSmallest(TreeNode root, int k) {
    	//int left count and right count simple no?
    	ans = -1;
    	count = 0;

    	kthSmallest_(root, k);
    	return ans;
    }

    public void kthSmallest_(TreeNode root, int k){
    	if(root == null) return;

    	kthSmallest_(root.left);
    	count++;
    	if(count == k){
    		ans = root.val;
    	}

    	kthSmallest_(root.rightf);
    }


}