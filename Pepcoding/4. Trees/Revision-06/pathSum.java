class Solution {
	//first part
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        targetSum -= root.val;
        if(root.left == null && root.right == null && targetSum == 0) return true;

        //after this
        boolean res = false;
        res = res || hasPathSum(root.left, targetSum);
        res = res || hasPathSum(root.right, targetSum);

        return res;
    }


    //second part
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(root, targetSum, ans, curr);
        return ans;
    }

    public void helper(TreeNode root, int targetSum, List<List<Integer>> ans, List<Integer> curr){
    	if(root == null) return;
    	curr.add(root.val);
    	targetSum -= root.val;

    	if(root.left == null && root.right == null){
    		if(targetSum == 0){
    			ans.add(new ArrayList<>(curr));
    		}
    		return;
    	}

    	helper(root.left, targetSum, ans, curr);
    	helper(root.right, targetSum, ans, curr);

    	curr.remove(curr.size() - 1);
    }

    //path sum - 3
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return counter(root, targetSum, 0, map);
    }

    public int counter(TreeNode root, int targetSum, int currSum, Map<Integer, Integer> map){
    	if(root == null) return 0;

    	//we are at new node right!
    	currSum += root.val;
    	map.put(currSum, map.getOrDefault(currSum, 0) + 1);

    	int cnt = 0;
    	if(map.containsKey(currSum - targetSum)){
    		cnt += map.get(currSum - targetSum);
    	}

    	cnt += counter(root.left, targetSum, currSum, map);
    	cnt += counter(root.right, targetSum, currSum, map);

    	map.put(currSum, map.get(currSum) - 1);

    	return cnt;
    }


}






















