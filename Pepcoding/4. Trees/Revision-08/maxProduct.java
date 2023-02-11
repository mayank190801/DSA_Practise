class Solution {

	//let's figure out how we can actually solve it no matter what
    public int maxProduct(TreeNode root) {
    	long[] ans = new long[1];
    	long sum = sum_(root);
    	helper_(root, sum, ans);
    	long mod = 1_000_000_007;
    	long ans = ans[0] % mod;

    	return (int)(ans);
    }

    //function to calculate the overall sum
    public long sum_(TreeNode root){
    	if(root == null) return 0;
    	return sum_(root.left) + sum_(root.right) + root.val;
    }


   	public long helper_(TreeNode root, long sum, long[] ans){

   		if(root == null){
   			return 0;
   		}

   		long left = helper_(root.left, sum, ans);
   		long right = helper_(root.right, sum, ans);

   		long csum = left + right + root.val;
   		long cans = (sum - csum) * csum;
   	
   		ans[0] = Math.max(ans[0], cans);
   		return csum;
   	}

    //mostly in post order i think so, let's try to code it for sure
    //that would be actually helpful for sure

}