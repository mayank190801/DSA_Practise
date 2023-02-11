class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	//simply 
    	List<List<Integer>> ans = new ArrayList<>();
    	if(root == null) return ans;
    
    	Stack<TreeNode> st = new Stack<>();
    	st.add(root);

    	boolean ltr = true;  //pointer baby
    	while(!st.isEmpty()){
    		int size = st.size();
    		Stack<TreeNode> temp = new Stack<>();
    		ArrayList<Integer> cans = new ArrayList<>();
    		while(size--> 0){
    			TreeNode top = st.pop();   
    			cans.addd(top.val);

    			if(ltr){
    				if(top.left != null)
    					temp.add(top.left);
    				if(top.right != null)
    					temp.add(top.right);
    			}else{
    				if(top.right != null)
    					temp.add(top.right);
    				if(top.left != null)
    					temp.add(top.left);    				
    			}
    		}

    		st = temp;
    		ltr = !ltr;  //dope as fuck
    		ans.add(cans);
    	}

    	return ans;
    }
}