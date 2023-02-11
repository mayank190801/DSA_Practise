 class Solution {

 	//you are traversing simply, now figure out when to add what to add baby
    public List<Integer> inorderTraversal(TreeNode root) {
    	//no stack or no recursion , pretty dope stuff, for sure!! (dont' overthink and keep coding)
    	List<Integer> ans = new ArrayList<>();

    	TreeNode node = root;
    	while(node != null){
    		if(node.left == null){
    			ans.add(node.val);  
    			node = node.right;
    		}else{
    			//get the predecssor for once boi
    			TreeNode temp = node.left;
    			while(temp.right != null && temp.right != node){
    				temp = temp.right;
    			}

    			if(temp.right == node){   //we have made it bois
    				temp.right = null;
    				ans.add(node.val);
    				node = node.right;
    			}else{
    				temp.right = node;
    				node = node.left;
    			}
    		}
    	}

    	return ans;
        
    }

     	//you are traversing simply, now figure out when to add what to add baby
    public List<Integer> preorderTraversal(TreeNode root) {
    	//no stack or no recursion , pretty dope stuff, for sure!! (dont' overthink and keep coding)
    	List<Integer> ans = new ArrayList<>();

    	TreeNode node = root;
    	while(node != null){
    		if(node.left == null){
    			ans.add(node.val);  
    			node = node.right;
    		}else{
    			//get the predecssor for once boi
    			TreeNode temp = node.left;
    			while(temp.right != null && temp.right != node){
    				temp = temp.right;
    			}

    			if(temp.right == node){   //we have made it bois
    				temp.right = null;
    				node = node.right;
    			}else{
    				temp.right = node;
    				ans.add(node.val);
    				node = node.left;
    			}
    		}
    	}

    	return ans;
        
    }



      public List<Integer> postorderTraversal(TreeNode root) {
    	//no stack or no recursion , pretty dope stuff, for sure!! (dont' overthink and keep coding)
    	LinkedList<Integer> ans = new LinkedList<>();

    	TreeNode node = root;
    	while(node != null){
    		if(node.right == null){
    			ans.addFirst(node.val);  
    			node = node.left;
    		}else{
    			//get the predecssor for once boi
    			TreeNode temp = node.right;
    			while(temp.left != null && temp.left != node){
    				temp = temp.left;
    			}

    			if(temp.left == node){   //we have made it bois
    				temp.left = null;
    				node = node.left;
    			}else{
    				temp.left = node;
    				ans.addFirst(node.val);
    				node = node.right;
    			}
    		}
    	}


    	return ans;
        
    }

}