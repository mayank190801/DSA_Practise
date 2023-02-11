class Solution {
 
    public List<List<Integer>> levelOrder(TreeNode root) {
    	  Queue<TreeNode> que = new ArrayDeque<>();
    	List<List<Integer>> ans = new ArrayList<>();
        
        if(root == null) return ans;
    	que.add(root);

    	while(!que.isEmpty()){
    		int size = que.size();
    		List<Integer> cans = new ArrayList<>();
    		while(size --> 0){
    			TreeNode top = que.poll();   //practise in here boi!

    			//and add all the rem in there obi
    			if(top.left != null)
    				que.add(top.left);

    			if(top.right != null)
    				que.add(top.right);

    			cans.add(top.val);
    		}
    		ans.add(cans);
    	}

    	return ans;
    }

    //think of a recursive solution for this bad boi!! (think think think)
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> ans = new ArrayList<>();
    	levelOrderHelper(root, 1, ans);
    	return ans;
    }

    public void levelOrderHelper(TreeNode root, int level, List<List<Integer>> ans){
    	if(root == null) return;

    	if(ans.size() < level){
    		ans.add(new ArrayList<>());
    	}
    	ans.get(level-1).add(root.val);

    	levelOrderHelper(root.left, level + 1, map);
    	levelOrderHelper(root.right, level + 1, map);
    	return;
    }

    //ease bois ease bois
    //use hashmap or whatever you want for this question, pretty simple


}