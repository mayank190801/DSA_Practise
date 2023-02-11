class Solution {

	//let's think about this question right??
	//Iterative for sure
    public List<Integer> rightSideView(TreeNode root) {
    	List<Integer> ans = new ArrayList<>();
    	if(root == null) return ans;

    	Queue<TreeNode> que = new ArrayDeque<>();
    	que.add(root);

    	while(!que.isEmpty()){
    		int size = que.size();
    		boolean flag = false;
    		while(size --> 0){
    			TreeNode top = que.pop();
    			if(!flag) ans.add(top.val);
    			flag = true;

    			if(top.right != null)
    				que.add(top.right);
    			if(top.left != null)
    				que.add(top.left);


    		}
    	}
    	return ans;
    }

    //uss level ka right most element baby!! , or simply keep updating no?
    //that level is achieved first time!! so put that element in
    int mlevel = -1;
    public List<Integer> rightSideView(TreeNode root) {
    	List<Integer> ans = new ArrayList<>();
    	rightHelper(root, 0, ans);
    	return ans;
    }

    public  void rightHelper(TreeNode node , int level, List<Integer> ans){
    	if(node == null) return;

    	if(mlevel < level){
    		mlevel = level;
    		ans.add(node.val);
    	}

    	//otherwise
    	rightHelper(node.right,level + 1, ans);
    	rightHelper(node.left, leve + 1, ans);

    	return;
    }


}












