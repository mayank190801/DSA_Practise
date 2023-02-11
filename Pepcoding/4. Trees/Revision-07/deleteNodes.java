class Solution {

	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		List<TreeNode> ans = new ArrayList<>();
		if(root == null) return ans;

		int[] del = new int[1001];
		for(int i : to_delete){
			del[i] = 1;
		}
		
		if(del[root.val] != 1) ans.add(root);
		delNodes_(root, del, ans);
		return ans;
    }

    public void delNodes_(TreeNode root, int[] del, List<TreeNode> ans){

    	if(root == null) return;
    	delNodes_(root.left, del, ans);
    	delNodes_(root.right, del, ans);

    	int curr = root.val;

    	if(del[curr] == 1){
    		if(root.left != null && del[root.left.val] != 1){
    			ans.add(root.left);
    			root.left = null;
    		}
    		
    		if(root.right != null && del[root.right.val] != 1){
    			ans.add(root.right);
    			root.right = null;
    		}
    	}else{
    		if(root.left != null && del[root.left.val] == 1){
    			root.left = null;
    		}
    		
    		if(root.right != null && del[root.right.val] == 1){
    			root.right = null;
    		}
    	}

    }




}